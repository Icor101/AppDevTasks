package riya.com.taskfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    public void next()
    {
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                EditText et1=(EditText) findViewById(R.id.Movie);
                EditText et2=(EditText)findViewById(R.id.Rating);
                String Movie=et1.getText().toString();
                String Rating=et2.getText().toString();
                intent.putExtra("Movie",Movie);
                intent.putExtra("Rating",Rating);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next();
    }
}
