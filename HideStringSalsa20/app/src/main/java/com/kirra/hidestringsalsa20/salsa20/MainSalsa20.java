package com.kirra.hidestringsalsa20.salsa20;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kirra on 14/01/18.
 */

public class MainSalsa20 {
    private String KEY1 = "asdfifmsnfkrjsnf";
    private String KEY1V = "qwertykd";

    public Salsa20OutputStream seEncodedFile(OutputStream outputStream){
        return new Salsa20OutputStream(outputStream, KEY1.getBytes(), KEY1V.getBytes());
    }

    public InputStream getDecodedFile(InputStream inputStream){
        return new Salsa20InputStream(inputStream, KEY1.getBytes(), KEY1V.getBytes());
    }
}
