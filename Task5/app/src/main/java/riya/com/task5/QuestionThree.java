package riya.com.task5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static riya.com.task5.R.layout.activity_question_three;

public class QuestionThree extends AppCompatActivity {
    private Button b3,b1,b2,b4,n;
    public boolean ans3=false;
    public void next() {
        Intent intent=getIntent();
        final Boolean ans2=intent.getExtras().getBoolean("Answer2");
        final Boolean ans1=intent.getExtras().getBoolean("Answer1");
        b3=findViewById(R.id.q3c);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans3=true;
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b1=findViewById(R.id.q3a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b2=findViewById(R.id.q3b);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b4=findViewById(R.id.q3d);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        n=findViewById(R.id.Finish);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionThree.this, Result.class);
                intent.putExtra("Answer2",ans2);
                intent.putExtra("Answer1",ans1);
                intent.putExtra("Answer3",ans3);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);
        next();
    }
}
