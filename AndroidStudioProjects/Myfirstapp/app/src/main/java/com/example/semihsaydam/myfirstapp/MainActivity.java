package com.example.semihsaydam.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeMusician();

        //changeImage camel case
        //change_image snake
    }

    public void changeImage (View view) {


     ImageView imageView = findViewById(R.id.imageView);
     imageView.setImageResource(R.drawable.photo1);
     imageView.setImageResource(R.drawable.photo3);
     imageView.setImageResource(R.drawable.photo2);

    }

    public void makeMusician() {

        musician james= new musician("Semih","Guitan",22);
        
    }
}
