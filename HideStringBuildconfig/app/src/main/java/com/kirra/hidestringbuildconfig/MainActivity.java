package com.kirra.hidestringbuildconfig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String keydata;
    private String keydata2;
    private String keydata3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keydata = BuildConfig.pass;
        keydata2 = BuildConfig.ENC_KEY_1;
        keydata3 = BuildConfig.ENC_KEY_IV;
    }
}
