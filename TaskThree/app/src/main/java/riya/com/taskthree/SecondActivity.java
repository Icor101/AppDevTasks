package riya.com.taskthree;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        final TextView t = (TextView) findViewById(R.id.t);
        Snackbar.make(t, "SecondActivity", Snackbar.LENGTH_LONG).show();

    }
}
