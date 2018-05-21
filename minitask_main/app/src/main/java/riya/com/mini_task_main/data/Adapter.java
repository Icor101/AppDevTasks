package riya.com.mini_task_main.data;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import riya.com.mini_task_main.R;
import riya.com.mini_task_main.data.model.PersonalDetails;
import riya.com.mini_task_main.data.remote.BasicDetails;

/**
 * Created by BBMishra on 16-May-18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private RecyclerView recyclerView;
    private int mExpandedPosition=(-1);
    private List<BasicDetails> mBasicDetails;
    private List<PersonalDetails> mPersonalDetails;
    private Context mContext;
    private PostItemListener mBDListener;
    public TextView name,username,id;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, id, username,email,address;
        public View details;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            id = (TextView) view.findViewById(R.id.id);
           username= (TextView) view.findViewById(R.id.username);
        }
    }

    Adapter(List<BasicDetails> BD)
    {
        this.mBasicDetails=BD;
    }
    public Adapter(Context context, List<BasicDetails> posts, PostItemListener itemListener) {
        mBasicDetails = posts;
        mContext = context;
        mBDListener = itemListener;
    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.user_list_row, parent, false);
        ViewHolder viewHolder=new ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, final int position) {
       BasicDetails BD = mBasicDetails.get(position);
//        TextView name = holder.name;
//       TextView username=holder.username;
//       TextView id=holder.id;
       holder.username.setText(BD.getUsername());
       holder.name.setText(BD.getName());
       holder.id.setText(Integer.toString(BD.getid()));
    }

    @Override
    public int getItemCount() {
        return mBasicDetails.size();
    }

    private BasicDetails getBD(int adapterPosition) {
        return mBasicDetails.get(adapterPosition);
    }
//    public void updateAnswers(PersonalDetails PD) {
//        PD.setName(PD.getName());
//        PD.setId(PD.getId());
//        PD.setUsername(PD.getUsername());
//        notifyDataSetChanged();
//    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}
