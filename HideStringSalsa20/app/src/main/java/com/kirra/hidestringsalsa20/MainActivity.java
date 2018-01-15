package com.kirra.hidestringsalsa20;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.kirra.hidestringsalsa20.salsa20.MainSalsa20;
import com.kirra.hidestringsalsa20.salsa20.Salsa20OutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private static final String txt = "see on file explorer in folder Reader";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        writeFileEncode("coba.txt");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private void writeFileEncode(String s) {
        String file = s;
        try {
            File outputFile = new File(Environment.getExternalStorageDirectory() , "Reader");
            if (!outputFile.exists()){
                outputFile.mkdirs();
            }
            OutputStream out = new FileOutputStream(new File(outputFile , s+".s"));
            MainSalsa20 mainSalsa20 = new MainSalsa20();
            Salsa20OutputStream salsa20 = mainSalsa20.seEncodedFile(out);
            InputStream inputStream = getApplicationContext().getAssets().open(file);
            try {
                byte[] buffer = new byte[4 * 1024]; // or other buffer size
                int read;

                while ((read = inputStream.read(buffer)) != -1) {
                    salsa20.write(buffer, 0, read);
                }

                salsa20.flush();
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            } finally {
                salsa20.close();
                writeFileDecode(file);
            }
            inputStream.close();
            tv.setText(txt);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void writeFileDecode(String file){
        String outputName = file;
        InputStream input = null;
        try {
            InputStream encodedFile = new FileInputStream(new File(Environment.getExternalStorageDirectory(),"Reader/"+file+".s"));
            MainSalsa20 mainSalsa20 = new MainSalsa20();
            input = mainSalsa20.getDecodedFile(encodedFile);
            try {
                File outputFile = new File(Environment.getExternalStorageDirectory() , "Reader");
                if (!outputFile.exists())
                    outputFile.mkdirs();
                FileOutputStream output = new FileOutputStream(new File(outputFile, outputName));
                try {
                    byte[] buffer = new byte[4 * 1024]; // or other buffer size
                    int read;

                    while ((read = input.read(buffer)) != -1) {
                        output.write(buffer, 0, read);
                    }

                    output.flush();
                } catch (IOException e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    output.close();
                }
            } catch (FileNotFoundException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            } finally {
                input.close();
            }
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
