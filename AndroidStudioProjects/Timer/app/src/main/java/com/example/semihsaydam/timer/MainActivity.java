package com.example.semihsaydam.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {                     // Her saniyede ne yapayım? Saniye çünkü countDownInterval=1000 vredim.

                TextView textView= findViewById(R.id.textView);                // textview tanımalamsı

                textView.setText("Left=" + millisUntilFinished/1000);          // HER SANİYEDE(ms/1000 den dolayı saniye) bunu yaz textView'a)


            }

            @Override
            public void onFinish() {                                           // Bittiğinde ne yapayım?

                Toast.makeText(getApplicationContext(),"süren doldu aslanım",Toast.LENGTH_LONG).show(); //Sürenin bittiğini toast şeklinde söyleyecek


                TextView textView= findViewById(R.id.textView);               //textview tanımlaması ( oncreatede direkt tanımlasak sürekli tanımlamaya gerek kalmazdı)

                textView.setText("süreniz doldu");                            // Sayaç bittiğinde süreniz doldu yazdır. TextViewe yazdıracak.

            }
        }.start();

    }
}
