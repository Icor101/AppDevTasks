package riya.com.tasktwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int clickVal=0;
    private Button button;
    private TextView eText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        eText= findViewById(R.id.eText);
        button.setOnClickListener(this);
    }
    public void showMessage()
    {
        TextView tv=(TextView) findViewById(R.id.eText);
        tv.setText("GoodBye World");
    }
    public void showMessage2()
    {
        TextView tv=(TextView) findViewById(R.id.eText);
        tv.setText("Hello World!");
    }
    @Override
    public void onClick(View v) {
        clickVal++;
        if(clickVal%2==1)
            showMessage();
        else
            showMessage2();
    }
}
