package com.kirra.hidestringdecoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

//https://rammic.github.io/2015/07/28/hiding-secrets-in-android-apps/
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String[] KEY = new String[]{
            "gtcbnuhrrwlapZHjXsVBLEUSmHh=","iogrngwhffBIHWLETtuykxPIXIV","oNQavjbaNNSgEqoCkT9Em4imeQQ"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                useXorStringHiding("maumenyembunyikanstring");

                //decode text >> maumenyembunyikanstring
                useXorStringShowing("bWF1bWVueWVtYnVueWlrYW5zdHJpbmc=");
    }

    public void useXorStringHiding(String myHiddenMessage) {
        byte[] xorParts0 = Base64.decode(KEY[0],0);
        byte[] xorParts1 = Base64.decode(KEY[1], 0);

        byte[] xorKey = new byte[xorParts0.length];
        for(int i = 0; i < xorParts1.length; i++){
            xorKey[i] = (byte) (xorParts0[i] ^ xorParts1[i]);
        }
        doHiding(myHiddenMessage.getBytes(), xorKey, false);
    }

    public static void doHiding(byte[] msg, byte[] pwd, boolean isHidden){
        xorValues(msg, pwd);

        if(!isHidden){
            String hiddenMessage = Base64.encodeToString(msg, 0);
            Log.i(TAG, String.format("Hidden Message: %s", hiddenMessage));
            doHiding(msg, pwd, true);
        }else{
            Log.i(TAG, String.format("Unhidden Message: %s", new String(msg)));
        }
    }

    public static int xorValues(byte[] msg, byte[] pwd){
        int i;
        for(i = 0; i < msg.length; i++){
            int keyOffset = i % pwd.length;
            msg[i] = (byte) (msg[i] ^ pwd[keyOffset]);
        }
        return i;
    }

    public void useXorStringShowing(String myHiddenMessage) {
        byte[] xorParts0 = Base64.decode(KEY[0],0);
        byte[] xorParts1 = Base64.decode(KEY[1], 0);

        byte[] xorKey = new byte[xorParts0.length];
        for(int i = 0; i < xorParts1.length; i++){
            xorKey[i] = (byte) (xorParts0[i] ^ xorParts1[i]);
        }
        doShow(myHiddenMessage, xorKey);
    }

    public static void doShow(String message, byte[] pwd){
        xorValues(message.getBytes(), pwd);
        Log.i(TAG, String.format("Unhidden Message: %s", new String(Base64.decode(message,0))));
    }
}
