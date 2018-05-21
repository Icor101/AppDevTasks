package riya.com.mini_task_main;

import android.content.ClipData;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import riya.com.mini_task_main.data.Adapter;
import riya.com.mini_task_main.data.RecyclerTouchListener;
import riya.com.mini_task_main.data.model.PersonalDetails;
import riya.com.mini_task_main.data.remote.BasicDetails;
import riya.com.mini_task_main.data.remote.MiniTaskService;

public class MainActivity extends AppCompatActivity implements BottomSheetFragment.OnFragmentInteractionListener {

    private Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private MiniTaskService mService;
    private BottomSheetBehavior behavior;
    CoordinatorLayout coordinatorLayout;


    ArrayList<BasicDetails> basicDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        Realm.init(this);
        mService = ApiUtils.getMiniTaskService();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new Adapter(this, basicDetails, new Adapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "User id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ViewGroup bottomSheet=(ViewGroup) findViewById(R.id.bottom_sheet);
        behavior=BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (behavior.getState() != BottomSheetBehavior.STATE_EXPANDED)
                {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("data",position);
                    BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                    bottomSheetFragment.setArguments(bundle);
                    bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                    //BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                   // bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                }
                else
                {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        loadDetails();

    }

    private void loadDetails() {
        mService.getName().enqueue(new Callback<PersonalDetails[]>() {
            @Override
            public void onResponse(Call<PersonalDetails[]> call, Response<PersonalDetails[]> response) {

                if (response.isSuccessful()) {
                    PersonalDetails personalDetails[] = response.body();

                    for (PersonalDetails personalDetail : personalDetails) {
//                        mAdapter.updateAnswers(personalDetail);
                        BasicDetails basicDetail = new BasicDetails();
                        basicDetail.setid(personalDetail.getId());
                        basicDetail.setName(personalDetail.getName());
                        basicDetail.setUsername(personalDetail.getUsername());
                        basicDetails.add(basicDetail);
                        Log.d("MainActivity", "ID: " + personalDetail.getId() + " Name: " + personalDetail.getName());
                    }
                    mAdapter.notifyDataSetChanged();
                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    Log.d("MainActivity", "Status Code: " + statusCode);
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<PersonalDetails[]> call, Throwable t) {
                showErrorMessage();
                Log.d("MainActivity", "error loading from API");
                Log.d("MainActivity", "Error caused by: " + t.getMessage());
            }

            private void showErrorMessage() {
                System.out.println("Error Occurred!!");
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("MainActivity","Interacted with fragment URI: " + uri);
    }
}
