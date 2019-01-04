package com.example.administrator.point24game;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextA = (EditText) findViewById(R.id.editTextA);
        final EditText editTextB = (EditText) findViewById(R.id.editTextB);
        final EditText editTextC = (EditText) findViewById(R.id.editTextC);
        final EditText editTextD = (EditText) findViewById(R.id.editTextD);
        final TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        final Button btnA = (Button) findViewById(R.id.btnA);
        final Button btnRandom = (Button) findViewById(R.id.btnRandom);
        final Button btnExit = (Button) findViewById(R.id.btnExit);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a= Integer.valueOf(editTextA.getText().toString());
                int b = Integer.valueOf(editTextB.getText().toString());
                int c = Integer.valueOf(editTextC.getText().toString());
                int d = Integer.valueOf(editTextD.getText().toString());
                Point point = new Point(a, b, c, d);
                textViewResult.setText(point.getResult());
            }
        });
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = 10;
                int a = (int)(Math.random()*n+1);
                int b = (int)(Math.random()*n+1);
                int c = (int)(Math.random()*n+1);
                int d = (int)(Math.random()*n+1);
                editTextA.setText(String.valueOf(a));
                editTextB.setText(String.valueOf(b));
                editTextC.setText(String.valueOf(c));
                editTextD.setText(String.valueOf(d));
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
