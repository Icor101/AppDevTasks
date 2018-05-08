package riya.com.task5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionOne extends AppCompatActivity {
    private Button b1,b2,b3,b4,n;
    public boolean ans1=false;
    public void next() {
        n=findViewById(R.id.next);
        b1=findViewById(R.id.q1a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b2=findViewById(R.id.q1b);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b3=findViewById(R.id.q1c);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b4=findViewById(R.id.q1d);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans1=true;
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionOne.this,q2.class);
                intent.putExtra("Answer1",ans1);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        next();
    }
}
