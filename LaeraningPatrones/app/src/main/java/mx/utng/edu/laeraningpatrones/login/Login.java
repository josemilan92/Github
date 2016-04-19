package mx.utng.edu.laeraningpatrones.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;

public class Login extends AppCompatActivity implements OnClickListener {

    private EditText user, pass;
    private Button mSubmit, mRegister;

    private ProgressDialog pDialog;


    UserSessionManager session;

    public static final String MyPREFRENCES="MyPrefs";
    public static final String Name="nameKey";
    public static final String Password="passKey";
    SharedPreferences sharedPreferences;

    // Clase JSONParser
    JSONParser jsonParser = new JSONParser();


    // si trabajan de manera local "localhost" :
    // En windows tienen que ir, run CMD > ipconfig
    // buscar su IP
    // y poner de la siguiente manera
    // "http://xxx.xxx.x.x:1234/cas/login.php";

    private static final String LOGIN_URL = "http://josemilan.esy.es/jos/login.php";

    // La respuesta del JSON es
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // setup input fields
        user = (EditText) findViewById(R.id.edt_name);
        pass = (EditText) findViewById(R.id.edt_pass);

        // setup buttons
        mSubmit = (Button) findViewById(R.id.btn_login);
        mRegister = (Button) findViewById(R.id.btn_registrar);

        // register listeners
        mSubmit.setOnClickListener(this);
        mRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn_login:
                new AttemptLogin().execute();
                break;
            case R.id.btn_registrar:
                Intent i = new Intent(this, Register.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }

    class AttemptLogin extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Attempting login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            session= new UserSessionManager(getApplicationContext());
            int success;
            String username = user.getText().toString();
            String password = pass.getText().toString();

            try {
                // Building Parameters
                List params = new ArrayList();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));

                Log.d("request!", "starting");
                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST",
                        params);

                // check your log for json response
                Log.d("Login attempt...", json.toString());

                session.createUserLoginSession(username, password);


                sharedPreferences =getSharedPreferences(MyPREFRENCES, Context.MODE_PRIVATE);
                // json success tag
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {

                    Log.d("Login Successful!", json.toString());

                    SharedPreferences.Editor editor= sharedPreferences.edit();

                    editor.putString(Name, username);
                    editor.putString(Password, password);
                    editor.commit();
                    // save user data
                   /* SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(Login.this);
                    Editor edit = sp.edit();
                    edit.putString("username", username);
                    edit.commit();*/

                    Intent i = new Intent(getApplicationContext(), ReadComments.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    finish();
                    startActivity(i);
                    return json.getString(TAG_MESSAGE);
                } else {
                    Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(Login.this, file_url, Toast.LENGTH_LONG).show();
            }
        }
    }
}