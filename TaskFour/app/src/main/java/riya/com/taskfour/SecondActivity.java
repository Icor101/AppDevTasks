package riya.com.taskfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String Movie;
    String Rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        Movie=intent.getStringExtra("Movie");
        Rating=intent.getStringExtra("Rating");
        TextView tv_Movie=(TextView)findViewById(R.id.tv1);
        TextView tv_Rating=(TextView)findViewById(R.id.tv2);
        tv_Movie.setText(Movie.toString());
        tv_Rating.setText(Rating.toString());
    }
}
