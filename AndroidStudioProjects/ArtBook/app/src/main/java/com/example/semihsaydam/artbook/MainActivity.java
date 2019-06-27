package com.example.semihsaydam.artbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();   //Böylece mainactivitye hangi menüyü çıkaracağını söylemiş olduk.
        menuInflater.inflate(R.menu.add_art, menu);      //return superin altına yazınca hata verdi. dikkat ona üstüne yazcan.

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //ben menüyü seçince ne olacak onu yazacağız içine
                                                            //intent ile başka activitye gidicez.
        if(item.getItemId()==R.id.add_art){

            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

            Intent info = intent.putExtra("info", "new"); // save butonu sadece yeni açılanlarda gelsin diye

            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
    }
}
