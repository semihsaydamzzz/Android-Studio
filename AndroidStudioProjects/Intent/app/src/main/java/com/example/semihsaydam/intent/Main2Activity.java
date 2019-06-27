package com.example.semihsaydam.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView= findViewById(R.id.textView2);
        Intent intent= getIntent();
        intent.getStringExtra("input");
        textView.setText(intent.getStringExtra("input"));

    }

    public void changeScreen(View view){

        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent2);

    }
}
