package com.example.semihsaydam.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //image ve textview tanımlamaları
        ImageView imageView = findViewById(R.id.imageView2);
        TextView textView = findViewById(R.id.textView);
        //

        //ilk activityden gönderilen name anahtar kelimeli isimlerin bu activity de karşılanması
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        textView.setText(name);   //BURAYA DİKKAT ET. "NAME" DİYİP YAZI YAZDIRMADIK. ilk activityden çektiğin name kodlu intent aktarımındaki name bu

        //ilk aktivitede static tanımladığı selectedImageyi burada kullancaz. KOLAY YÖNTEMDİ BU.
        //imageView.setImageBitmap(MainActivity.selectedImage); ///Mainactivity yazmaya dikkat orası önemli

        //imageView.setImageBitmap  kolay yöntemdi onu yorum yaptık şimdi zor yöntem setter getter için veri çekicez get ile

        Globals globals = Globals.getInstance();
        Bitmap bitmap = globals.getData();

        imageView.setImageBitmap(bitmap);

    }
}
