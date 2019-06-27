package com.example.semihsaydam.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void save(View view){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);

        alert.setTitle("Save");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {          // Yani positive buton açtık. Yes ' e basarsa ne olsun new DialogInterface ile oldu.
            @Override
            public void onClick(DialogInterface dialog, int which) {                         // Yes e basarse ne olacağı

                Toast.makeText(getApplicationContext(),"Save",Toast.LENGTH_LONG).show();


            }
        });

        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "not save", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();     //DİKKAT !!!


    }


}
