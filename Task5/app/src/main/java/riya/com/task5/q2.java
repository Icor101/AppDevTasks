package riya.com.task5;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class q2 extends AppCompatActivity {
    private Button b1,b2,b3,b4,n;
    public boolean ans2=false;
    public void next() {
        Intent intent=getIntent();
        final Boolean ans1=intent.getExtras().getBoolean("Answer1");
        b1=findViewById(R.id.q2a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans2=true;
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b2=findViewById(R.id.q2b);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b3=findViewById(R.id.q2c);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        b4=findViewById(R.id.q2d);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#fffacd"));
            }
        });
        n=findViewById(R.id.next);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(q2.this, QuestionThree.class);
                intent.putExtra("Answer2",ans2);
                intent.putExtra("Answer1",ans1);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);
        next();
    }
}
