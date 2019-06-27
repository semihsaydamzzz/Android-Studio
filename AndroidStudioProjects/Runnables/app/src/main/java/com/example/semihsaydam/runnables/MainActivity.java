package com.example.semihsaydam.runnables;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Handler handler;
    Runnable run;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {                     //start butonuna method açıp. o butona bastığımızda ne olsun kodlarını yazıcaz altına

        textView=findViewById(R.id.textView);

        number =0;                                     // başta textVievda 0 yazdırırız.


        handler= new Handler();
        run= new Runnable() {                                   //bunu yazınca kendiliğinden aşağıdaki methodu açar.
            @Override
            public void run() {                                //sayacı durdurma için kendiliğinden açılan method.

                textView.setText("Time="+number);
                number++;
                textView.setText("Time="+number);             // textviewı time=1 şekline getirmiş oluruz. Yani bir artırırız numberı

                handler.postDelayed(this, 1000);   //1 saniye ile saymayı başlatır. This yerine run da yazarsın. Üstteki methodu alır zaten this.

            }
        };                                                     // DİKKAT burada run methodunu kapattı.

        handler.post(run);                                    //start butonu altında bu yani dikkat et.

    }


    public void stop(View view) {    // stop butonuna method açıp. o butona bastığımızda ne olsun kodlarını yazıcaz altına

        handler.removeCallbacks(run);   //sayacı durdurma

        number=0;                       //sayacı sıfırla
        textView=findViewById(R.id.textView);
        textView.setText("Time="+number);     //sıfırı ekrana yaz


    }

}
