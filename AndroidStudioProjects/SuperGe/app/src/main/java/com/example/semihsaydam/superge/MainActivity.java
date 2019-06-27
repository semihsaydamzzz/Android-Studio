package com.example.semihsaydam.superge;

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

    BluetoothAdapter myBluetooth;
    private Set<BluetoothDevice> pairedDevices;
    Button toggle_button,pair_button;
    ListView  pairedlist;
    public static String EXTRA_ADRESS = "device_address";
    ArrayAdapter<String> adapter;
    TextView textVieww;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        toggle_button = (Button) findViewById(R.id.button_toggle);
        pair_button = (Button) findViewById(R.id.button_pair);
        pairedlist = (ListView)findViewById(R.id.device_list);
        textVieww =(TextView) findViewById(R.id.textView);
        textVieww.setText("SuperGE");



        toggle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleBluetooth();
            }


        });

        pair_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listDevice();
            }


        });
    }

    private void toggleBluetooth() {

        if(myBluetooth==null)
        {
            Toast.makeText(getApplicationContext(),"Bluetooth Cihazı Yok", Toast.LENGTH_SHORT).show();
        }
        if (!myBluetooth.isEnabled())
        {
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);
        }
        if (myBluetooth.isEnabled())
        {
            myBluetooth.disable();
        }

    }

    private void listDevice() {

        pairedDevices = myBluetooth.getBondedDevices();

        ArrayList list = new ArrayList();
        if (pairedDevices.size() > 0 )
        {
            for(BluetoothDevice bt: pairedDevices)
            {
                list.add(bt.getName()+"\n"+bt.getAddress());
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Eşleşmiş cihaz yok",Toast.LENGTH_SHORT).show();
        }
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        pairedlist.setAdapter(adapter);
        pairedlist.setOnItemClickListener(selectDevice);

    }

    public AdapterView.OnItemClickListener selectDevice = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String info = ((TextView) view).getText().toString();
            String address= info.substring(info.length()-17);

            Intent comintent = new Intent(MainActivity.this, Comunication.class);
            comintent.putExtra(EXTRA_ADRESS, address);
            startActivity(comintent);

        }
    };
}
