package com.example.semihsaydam.rckontrol;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class Comunication extends AppCompatActivity {

    String address=null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth=null;

    BluetoothSocket btSocket=null;
    BluetoothDevice remoteDevice;
    BluetoothServerSocket mmServer;

    private boolean isBtConnected=false;
    static final UUID myUUID= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    Button F_Button, B_Button, R_Button, L_Button,HF_Button,YF_Button,Sol_Button,Sag_Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunication);

        Intent newint= getIntent();
        address=newint.getStringExtra(MainActivity.EXTRA_ADRESS);

        F_Button = (Button) findViewById(R.id.forward_button);
        B_Button = (Button)  findViewById(R.id.backward_button);
        R_Button =(Button) findViewById(R.id.right_button);
        L_Button = (Button) findViewById(R.id.left_button);
        HF_Button=(Button) findViewById(R.id.hforward_button) ;
        YF_Button=(Button) findViewById(R.id.yforward_button);
        Sol_Button = (Button) findViewById(R.id.sol_button);
        Sag_Button = (Button) findViewById(R.id.sag_button);

        F_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

               if(btSocket != null)
               {
                   switch (event.getAction()) {
                       case MotionEvent.ACTION_DOWN:
                           try
                           {
                               btSocket.getOutputStream().write("1".toString().getBytes());
                           }
                           catch (IOException e)
                           {
                           }
                           break;

                       case MotionEvent.ACTION_UP:
                           try
                           {
                               btSocket.getOutputStream().write("0".toString().getBytes());
                           }
                           catch (IOException e)
                           {
                           }
                           break;
                   }
               }

                return false;
            }
        });

        HF_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("5".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });

        YF_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("6".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });



        R_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("2".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });

        L_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("3".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });

        B_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("4".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });

        Sol_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("7".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });

        Sag_Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(btSocket != null)
                {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            try
                            {
                                btSocket.getOutputStream().write("8".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;

                        case MotionEvent.ACTION_UP:
                            try
                            {
                                btSocket.getOutputStream().write("0".toString().getBytes());
                            }
                            catch (IOException e)
                            {
                            }
                            break;
                    }
                }

                return false;
            }
        });



        new BTbaglan().execute();

    }




    private void Disconnect(){

        if (btSocket !=null) {
            try{
                btSocket.close();
            }catch (IOException e){
                //msg("error");
            }
        }
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Disconnect();
    }


    private class BTbaglan extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true;

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(Comunication.this, "Baglanıyor...", "Lütfen Bekleyin");
        }

        // https://gelecegiyazanlar.turkcell.com.tr/konu/android/egitim/android-301/asynctask
        @Override
        protected Void doInBackground(Void... devices) {
            try {
                if (btSocket == null || !isBtConnected) {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice cihaz = myBluetooth.getRemoteDevice(address);
                    btSocket = cihaz.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();


                }
            } catch (IOException e) {
                ConnectSuccess = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (!ConnectSuccess) {
                // msg("Baglantı Hatası, Lütfen Tekrar Deneyin");
                Toast.makeText(getApplicationContext(), "Bağlantı Hatası Tekrar Deneyin", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                //   msg("Baglantı Basarılı");
                Toast.makeText(getApplicationContext(), "Bağlantı Başarılı", Toast.LENGTH_SHORT).show();

                isBtConnected = true;
            }
            progress.dismiss();
        }

    }
}
