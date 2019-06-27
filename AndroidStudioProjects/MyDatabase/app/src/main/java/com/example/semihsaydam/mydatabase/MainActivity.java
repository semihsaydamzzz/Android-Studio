package com.example.semihsaydam.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {                                                                                                    // dene ve yakala komutları. hata ayıklama methodudur. Android SQL hatasını söylemez bize.
                                                                                                                 //bu yüzden try catch kullanarak hata varsa bu kod parçasında olduğunu tespit ederiz.
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);      //Burada excel dosyası açtık gibi düşün
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR , age INT(2))");                     //Burada excelde bir sayfa açtık gibi düşün
            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES('James',50)");                               //Artık sayfanın içine ilk kod satırını yazmış olduk.INSERT INTO: içine yaz

            //myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('Semih',24)");

           // myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('Kirk', 60)");                               //filtreleme işlemi için 2 adet daha müzisyen ekledik.
            //myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('Rob', 65)");

            Cursor cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%a%'", null);       //veriyi çekmek için CURSOR kullancaz SELECT*FROM seçicez musiciansı
                                                                                                                        //where ile filtre yaptı. AND ile ikinci filtreyi de aktif etti.

            //myDatabase.execSQL("DELETE FROM musicians WHERE name LIKE 'J%'");          //Jamesi databaseden silecek. J ile başlayan her şeyi silecek
            myDatabase.execSQL("UPDATE musicians SET age=56 WHERE name = 'Semih'");
            
            int nameIx = cursor.getColumnIndex("name");                                         //excel gibi düşünürsen sutün başlıkları bunlar.1.sütun name 2.age
            int ageIx = cursor.getColumnIndex("age");                       //şimdi bu kodlarla name ve age'in kaçıncı columda olduğunu bulcaz ki cursora "git şu indexten
                                                                                        //şu sütundan şu değeri oku" diyebilelim.

            cursor.moveToFirst();                                                 //cursor işaretçisini sayfa başına aldık.

            while(cursor != null) {                                               //cursor boş değilken bunu yap

                System.out.println("Name: "+ cursor.getString(nameIx));
                System.out.println("Age: "+ cursor.getInt(ageIx));

                cursor.moveToNext();                                            //en üste götürdük moveToFirst ile bunda ise hala data varsa bir sonraki satıra geçirmek için yaptı

            }

        } catch (Exception e){
            e.printStackTrace();                                                                                   //bir hata yakalarsan bunu monitörde göster
        }

    }
}
