package com.kirra.hidestringpreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private GeneralPreference preference;
private Button btnSubmin;
private Button btnCek;
private EditText edtUsername;
private EditText edtPass;
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        preference = new GeneralPreference(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        preference.clear();
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
            preference.setPassword(edtPass.getText().toString());
            preference.setUsername(edtUsername.getText().toString());
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "form empty", Toast.LENGTH_SHORT).show();
        }
        
    }

    private void cekPress() {
        String user = preference.getUsername();
        String pass = preference.getPassword();
        Toast.makeText(this, "username: "+user +"\n"+" password: "+pass, Toast.LENGTH_SHORT).show();
    }
}
