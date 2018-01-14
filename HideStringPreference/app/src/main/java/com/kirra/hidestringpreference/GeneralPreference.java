package com.kirra.hidestringpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by kirra on 14/01/18.
 */

public class GeneralPreference {
    private final String KEY_USERNAME = "username";
    private final String KEY_PASSWORD = "password";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public GeneralPreference(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = sharedPreferences.edit();
    }

    public String getUsername(){
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public String getPassword(){
        return sharedPreferences.getString(KEY_PASSWORD,"");
    }

    public void setUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }

    public void setPassword(String password) {
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public void clear(){
        editor.clear().commit();
    }
}
