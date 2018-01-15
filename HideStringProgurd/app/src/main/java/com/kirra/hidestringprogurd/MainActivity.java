package com.kirra.hidestringprogurd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final static String data = "Passw0rdRahasi4_code_string";
    private static final byte[] databyte = new byte[]{
            'P','a','s','s','w','0','r','d','R','a','h','a','s','i','4','_','c','o','d','e','_','b','y','t','e'};
    private String dataBuildConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBuildConfig = BuildConfig.pass;
    }
}
