package com.example.semihsaydam.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.semihsaydam.storingdata", Context.MODE_PRIVATE);

        int age= 40;

        sharedPreferences.edit().putInt("userAge", age).apply(); //Hafızaya kaydetmek

        int savedAge= sharedPreferences.getInt("userAge",0); //hafızaya kaydetti mi diye kontrol etmek. kaydetmediyse default 0
        System.out.println("saved value:" + savedAge);


        int age=10 ;
        sharedPreferences.edit().putInt("userAge",age).apply(); //Hafızadaki veriyi değiştirmek

        sharedPreferences.edit().remove("userAge").apply(); //Hafızaya kaydettiğini silmek



    }
}
