package com.example.semihsaydam.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //static şekilde bitmap tanımlıyoruz. 2nci activity de mainactivity.selectedImage yazınca ulaşabileyim diye.
    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= findViewById(R.id.listView);                 //ListViewi layouttan çağırdık

        final ArrayList<String> landMarkNames= new ArrayList<String>();       //bir arraylist dizi oluşturduk ve ona elemanlar ekledik
        landMarkNames.add("Pisa");
        landMarkNames.add("Colloseo");
        landMarkNames.add("Eiffel");
        landMarkNames.add("londonbridge");

        //imageler yukarıdaki gibi .add ile tanımlanabilir ama öncesinde şu kodları yazman gerek =

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colleseo);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages= new ArrayList<>();

        //yukarıdaki bitmap tanımlamalarından sonra artık .add ile ekleyebiliriz. ama .add yaparken yukarıdaki sırayı bozma

        landmarkImages.add(pisa);
        landmarkImages.add(colleseo);
        landmarkImages.add(eiffel);
        landmarkImages.add(londonbridge);


        //Array ve listViewi birbirine bağlamak için arrayAdapter kullancaz

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,landMarkNames);
        listView.setAdapter(arrayAdapter);

        // şeklinde birbirine bağlandı

        // şimdi ikinci aktiviteye gitmek için hazır kod yapısını görcez listView için=

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ikinci activitye geçmek için intent oluşturucağız

                Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landMarkNames.get(position));  // burada diziden ismi aldık name anahtar kelimesiyle. position line de intini aldık(0=pisa)

                //selectedImage = landmarkImages.get(position); //burada selectedimage değişkenini listviewden position bilgisiyle image seçilmesine aktardık.
               //selectedImage kolay yöntemdi şimdi zor yöntemle yapıcaz.

                Bitmap bitmap = landmarkImages.get(position);        // seçili bitmapi bulma position ile
                Globals globals = Globals.getInstance();
                globals.setData(bitmap);                             // instance dayatı seçili bitmape set ettik.

                startActivity(intent);
            }
        });







    }
}
