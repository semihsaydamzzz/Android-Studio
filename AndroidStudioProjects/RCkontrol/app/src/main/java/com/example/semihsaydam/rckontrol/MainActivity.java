package com.example.semihsaydam.rckontrol;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter myBluetooth;                                           //cihazımızda bluetooth kontrolü yapıcak. Var/yok
    private Set<BluetoothDevice> pairedDevices;
    Button toggle_button,pair_button;
    ListView pairedList;
    public static String EXTRA_ADRESS ="device_address";
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBluetooth=BluetoothAdapter.getDefaultAdapter();             //bu cihazın bluetooth özelliği olup olmadığını göstericek bize
        toggle_button=(Button) findViewById(R.id.button_toggle);
        pair_button=(Button) findViewById(R.id.button_pair);
        pairedList=(ListView)findViewById(R.id.device_list);

        toggle_button.setOnClickListener(new View.OnClickListener() {               //bluetooth toggle'a basınca yapılacaklar
            @Override
            public void onClick(View view) {
                 toggleBluetooth();
            }

        });

        pair_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listdevice();
            }


        });
    }

    private void toggleBluetooth() {                                   // oncreate dışında bi method oluşturduktuk. mainactivitye
        if(myBluetooth==null) {
            Toast.makeText(getApplicationContext(), "Bluetooth cihazı yok", Toast.LENGTH_SHORT).show();
        }
        if(!myBluetooth.isEnabled()) {                                //enable değilse. ünlem var başta
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE );
            startActivity(enableBTIntent);                                //enable activitysinin talebini geçmiş olduk.
        }
        if(myBluetooth.isEnabled()) {
            myBluetooth.disable();

        }
        }
    private void listdevice() {
        pairedDevices= myBluetooth.getBondedDevices();          //eşleşmiş cihazları pairedDevicesın içine attık
        ArrayList list = new ArrayList();

        if (pairedDevices.size() > 0){                         //eşleşmiş cihazların boyutu(sayısı) sıfırdan büyükse aşağıdakileri yap.

            for (BluetoothDevice bt: pairedDevices)
            {
                list.add(bt.getName()+"\n"+bt.getAddress());
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Eşleşmiş cihaz yok",Toast.LENGTH_SHORT).show();
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        pairedList.setAdapter(adapter);
        pairedList.setOnItemClickListener(selectDevice);


    }

    public AdapterView.OnItemClickListener selectDevice = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String info = ((TextView) view).getText().toString();
            String address= info.substring(info.length()-17);

            Intent comintent = new Intent(MainActivity.this,Comunication.class);
            comintent.putExtra(EXTRA_ADRESS,address);
            startActivity(comintent);
        }
    };
}

