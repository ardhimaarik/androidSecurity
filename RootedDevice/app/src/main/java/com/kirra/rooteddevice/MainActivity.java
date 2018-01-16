package com.kirra.rooteddevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.chrisplus.rootmanager.RootManager;
import com.scottyab.rootbeer.RootBeer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RootBeer rootBeer = new RootBeer(this);
        if (rootBeer.isRooted()) {
            Toast.makeText(this, "RootBeer: Root", Toast.LENGTH_SHORT).show();
            //we found indication of root
        } else {
            Toast.makeText(this, "RootBeer: not root", Toast.LENGTH_SHORT).show();
            //we didn't find indication of root
        }

        if (RootManager.getInstance().hasRooted()){
            Toast.makeText(this, "RootManager: Root", Toast.LENGTH_SHORT).show();
            //we found indication of root
        } else {
            Toast.makeText(this, "RootManager: not root", Toast.LENGTH_SHORT).show();
            //we didn't find indication of root
        }
    }
}
