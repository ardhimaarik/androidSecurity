package com.kirra.hidestringkeystore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/******************************************************************************
 * Author  : Ardhi Maarik
 * Email   : ardhimaarik2@gmail.com
 * Project : Android security
 *
 * Copyright (c) 2017 "Kirra" - semangatkecil.blogspot.com
 * All Rights Reserved.
 ******************************************************************************/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSubmin;
    private Button btnCek;
    private EditText edtUsername;
    private EditText edtPass;
    private String pass = "";
    private String username = "";
    private Crypt crypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCek = (Button) findViewById(R.id.cek);
        btnSubmin = (Button) findViewById(R.id.submit);

        btnCek.setOnClickListener(this);
        btnSubmin.setOnClickListener(this);

        edtUsername = (EditText) findViewById(R.id.username);
        edtPass = (EditText) findViewById(R.id.pass);

        crypt = new Crypt(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cek:
                cekPress();
                break;
            case R.id.submit:
                submitPress();
                break;
        }
    }

    private void submitPress() {
        if (!edtUsername.getText().toString().isEmpty() && !edtPass.getText().toString().isEmpty()){
            try {
                username = crypt.encryptData(edtUsername.getText().toString());
                pass = crypt.encryptData(edtPass.getText().toString());
                edtUsername.setText("");
                edtPass.setText("");
                Toast.makeText(this, "saved\n Username: "+username+"\n"+"Password: "+pass, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "form empty", Toast.LENGTH_SHORT).show();
        }

    }

    private void cekPress() {
        if (!username.isEmpty() && !pass.isEmpty()){
            try {
                String uusername = crypt.decryptData(username);
                String ppass = crypt.decryptData(pass);
                Toast.makeText(this, " Username: "+uusername+"\n"+"Password: "+ppass, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "data empty, you should enter the data first", Toast.LENGTH_SHORT).show();
        }
    }
}
