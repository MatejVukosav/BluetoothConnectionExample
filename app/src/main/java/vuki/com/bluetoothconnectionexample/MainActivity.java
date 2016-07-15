package vuki.com.bluetoothconnectionexample;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Set;

import vuki.com.bluetoothconnectionexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    private static final int REQUEST_ENABLE_BT = 1122;
    ActivityMainBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if( bluetoothAdapter == null ) {
            ErrorHandler.reportError( this, ErrorCode.BLUETOOTH_IS_NOT_SUPPORTED );
        } else {
            setBluetooth();
            binding.discovery.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick( View view ) {
                    startDiscovery();
                }
            } );
        }
    }

    private void setBluetooth() {
        enableBluetooth();
        setDeviceBluetoothVisible( 300 );
        establishConnection();
    }

    private void enableBluetooth() {
        Intent enableIntent = new Intent( BluetoothAdapter.ACTION_REQUEST_ENABLE );
        startActivityForResult( enableIntent, REQUEST_ENABLE_BT );
    }

    private void setDeviceBluetoothVisible( int visibilitySeconds ) {
        Intent discoverableIntent = new Intent( BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE );
        discoverableIntent.putExtra( BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, visibilitySeconds );
        startActivity( discoverableIntent );
    }

    private void establishConnection() {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
    }

    private void startDiscovery() {
        bluetoothAdapter.startDiscovery();
    }

}
