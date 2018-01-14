package com.kirra.hidestringprogurd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final static String data = "Passw0rdRahasi4_3";
    private static final byte[] databyte = new byte[]{
            'P','a','s','s','w','0','r','d','R','a','h','a','s','i','4','_','5'};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
