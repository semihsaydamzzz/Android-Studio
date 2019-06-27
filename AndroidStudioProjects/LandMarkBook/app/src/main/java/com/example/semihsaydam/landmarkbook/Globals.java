package com.example.semihsaydam.landmarkbook;

import android.graphics.Bitmap;

public class Globals {

    private static Globals instance;            //instance değişkeni tanımladık

    private Bitmap chosenImage;

    private Globals(){


    }

    public void setData(Bitmap chosenImage){

        this.chosenImage = chosenImage;       //this bu global classını ifade eder. chosenImage değişkeni bu methodda ne veriyorsa onla eşitlenir.
    }

    public Bitmap getData(){

        return  this.chosenImage;           //eğer eşitleneni görmek istersen getdata ile görürsün
    }

    //şimdi oluşturacağımız methodda chosenImage'yi her yerde tek değişken olarak yönetebilmemiz için

    public static Globals getInstance(){

        if (instance== null){
            instance=new Globals();        //instance boş ise bunu yap
        }
        return instance;                   //boş değilse bana getir.
    }

}
