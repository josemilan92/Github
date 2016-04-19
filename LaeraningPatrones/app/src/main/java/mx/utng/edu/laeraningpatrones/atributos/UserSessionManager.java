package mx.utng.edu.laeraningpatrones.atributos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import mx.utng.edu.laeraningpatrones.login.Login;

/**
 * Created by a on 01/04/2016.
 */
public class UserSessionManager {

    SharedPreferences pref;


    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE=0;

    private static final String PREFER_NAME="AndroidExamplePref";

    private static final String IS_USER_LOGIN="IsUserLogin";

    public static final String KEY_NAME=" name";

    public static final String KEY_PASSWORD="pass";

    public UserSessionManager(Context context){
        this._context=context;
        pref=context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor=pref.edit();

    }

    public void createUserLoginSession(String name, String pass){
        editor.putBoolean(IS_USER_LOGIN, true);

        editor.putString(KEY_NAME, name);

        editor.putString(KEY_PASSWORD, pass);

        editor.commit();

    }


    public boolean checkLogin(){
        if(!this.isUserLoggedIn()){
            Intent i=new Intent(_context, Login.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);

            return true;
        }return false;
    }

    public boolean isUserLoggedIn(){
        return pref.getBoolean(IS_USER_LOGIN, false);
    }

public HashMap<String, String> getUserDetail(){

    HashMap<String, String> user= new HashMap<String, String>();

    user.put(KEY_NAME, pref.getString(KEY_NAME, null));

    user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

    return user;
}


    public void logoutUser(){

        editor.clear();
        editor.commit();

    }


}