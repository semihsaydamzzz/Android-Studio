package com.example.semihsaydam.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    TextView  resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        resultText=findViewById(R.id.textView);


    }
    public void sum(View view){

        if(editText.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("boş bırakma");
        } else {
            int a = Integer.parseInt(editText.getText().toString());
            int b = Integer.parseInt(editText2.getText().toString());

            int resultInteger = a + b;

            resultText.setText("Result:" + resultInteger);
        }

    }
    public void deduct(View view){
        if(editText.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("boş bırakma");
        } else {
            int a = Integer.parseInt(editText.getText().toString());
            int b = Integer.parseInt(editText2.getText().toString());

            int resultInteger = a - b;

            resultText.setText("Result:" + resultInteger);
        }

    }
    public void multiply(View view){
        if(editText.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("boş bırakma");
        } else {
            int a = Integer.parseInt(editText.getText().toString());
            int b = Integer.parseInt(editText2.getText().toString());

            int resultInteger = a * b;

            resultText.setText("Result:" + resultInteger);
        }

    }
    public void divide(View view){

        if(editText.getText().toString().matches("") || editText2.getText().toString().matches(""))
        {
            resultText.setText("boş bırakma");
        } else {
            int a = Integer.parseInt(editText.getText().toString());
            int b = Integer.parseInt(editText2.getText().toString());

            int resultInteger = a / b;

            resultText.setText("Result:" + resultInteger);
        }
    }

}
