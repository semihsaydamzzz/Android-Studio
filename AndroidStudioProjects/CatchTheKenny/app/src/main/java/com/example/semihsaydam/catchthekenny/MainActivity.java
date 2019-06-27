package com.example.semihsaydam.catchthekenny;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    int score;

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    ImageView[] imageArray;                                                  //Dizi oluşturmak için tanımlama. [] dikkat
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score=0;
       timeText= findViewById(R.id.timeText);                              //initialize işlemi denir. Başına TextView yazmadın çünkü yukarıda class başında tanımlıyorsun.
       scoreText= findViewById(R.id.scoreText);                            //initialize ( yani burada başlatmış olduk. Yani ekranda gözük dedik gibi oldu))
        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);

        imageArray= new ImageView[]{imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        hideImages();                                                       //Hideimages methodunu çağırdık !!!!!



        new CountDownTimer(10000, 1000) {        //Geri sayım (kaç ms sayıcam?, kaçar ms düşücem?)


            @Override
            public void onTick(long millisUntilFinished) {                  //Her ms aralığı düştüğünde ne yapayım?

                timeText.setText("Time: "+ millisUntilFinished/1000);            // Kaç saniye kaldığını timeText TextViewına yaz. BURADAKİ MİLLİS DEDİĞİ KAÇ SN KALDIĞI)

            }

            @Override
            public void onFinish() {                                       //Sayaç bittiğinde ne yapayım?

                timeText.setText("Time off");
                handler.removeCallbacks(runnable);

                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);         //mainactivity classı için uygula.

                alert.setTitle("Restart?");
                alert.setMessage("Are u sure to restart game?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // restart

                        Intent intent= getIntent();
                        finish();                                             //önceki yapılanları destroy ettik.
                        startActivity(intent);                                //kendi activityni tekrar çağırarak restart atmış olduk
                    }
                });

                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();



            }
        }.start();
    }

    public void increaseScore(View view){                                  //Bu bir onClick methodu. Yani TIKLADIĞIMDA NAPILSIN? der. Layoutta 9 imageView'a da aynı methodu verdik. yani
                                                                           //herhangi birine tıkladığında bu methottaki işlemleri yapacaktır.

        score++;
        scoreText.setText("Score: "+ score);

    }

    public void hideImages(){

        handler = new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {                                       //Devamlı yaptırmak istediğimiz, saniyede on saniyede bir yapılmasını istediğimiz şeyleri yaptırırız. Countdowntimer gibi kullanılıabilir.

                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random= new Random();                       //amacımız runnable ile tüm diziyi saniyede bir(mesela) görünmez yapmak. sonra rastgele bir imageyi görünür yapmak.
                int i= random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);         //rastgele seçilen sayıyı görünür yapacak.
                handler.postDelayed(this,500);

            }
        };
        handler.post(runnable);                                      //start runnable
    }
}
