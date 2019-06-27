package com.example.semihsaydam.artbook;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Objects;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = (ImageView) findViewById(R.id.imageView); //imageView tanıtılması
        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);


    }

    public void save (View view)
    {


    }

    public void select (View view)  //image tıklayınca ne yapacağı methodu. Yeni bir intente atacak bizi0
    {
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)   //Permission_granted=izin verilmişsse. != ile izin verilmediysenin if'ini açtık
        {
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 2);         //Bu if'e girdiysek iznimiz yoktur. O yüzden izin istiyoruZ
        }else {                                                                                     //eğer varsa iznin zaten kullanıcın albümüne girip aranmaya başlayabilirsin.

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI); //Uri bize bir path verir. URL gibi o görsele nereden ulaşabiliriz gösterir.
            startActivityForResult(intent,1);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { //izin yokken izin aldığında ne yapılacağını yazdık. o yüzden requestcode=='
                                                                                                                            // onreque yazınca bu methodu açmış olduk.

        if(requestCode==2)
        {
            if(grantResults.length > 0  && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);
            }
        }



        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
        {

            Uri image = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), image);
                imageView.setImageBitmap(bitmap);                                                        //BÖYLECE, SEÇİLEN RESMİ AL BURAYA İMAGEVİEW DE GÖSTER DEDİK.

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}


