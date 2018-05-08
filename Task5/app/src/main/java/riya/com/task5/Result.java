package riya.com.task5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent I=getIntent();
        boolean ans1,ans2,ans3;
        TextView R1=findViewById(R.id.res1);
        TextView R2=findViewById(R.id.res2);
        TextView R3=findViewById(R.id.res3);
        ans1= I.getExtras().getBoolean("Answer1");
        ans2=I.getExtras().getBoolean("Answer2");
        ans3=I.getExtras().getBoolean("Answer3");
        if(ans1==true)
            R1.setText("Question 1: Correct");
        else
            R1.setText("Question 1: Incorrect");
        if(ans2==true)
            R2.setText("Question 2: Correct");
        else
            R2.setText("Question 2: Incorrect");
        if(ans3==true)
            R3.setText("Question 3: Correct");
        else
            R3.setText("Question 3: Incorrect");
    }
}
