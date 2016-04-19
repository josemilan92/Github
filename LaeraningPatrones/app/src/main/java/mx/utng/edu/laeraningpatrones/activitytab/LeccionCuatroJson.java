package mx.utng.edu.laeraningpatrones.activitytab;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueCuatro;

/**
 * Created by a on 27/03/2016.
 */
public class LeccionCuatroJson extends AppCompatActivity {

    ListView listado;
    BloqueCuatro session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_layout);
        listado=(ListView)findViewById(R.id.lst_materias);
        ObtenerDatos();
    }

    public void ObtenerDatos(){
        session= new BloqueCuatro(getApplicationContext());

        AsyncHttpClient client= new AsyncHttpClient();
        String url="http://josemilan.esy.es/jose/conexioncuatro.php";

        RequestParams parametros= new RequestParams();
        parametros.put("Salir", 7);
        final ProgressDialog progressDialog= new ProgressDialog(LeccionCuatroJson.this);
        progressDialog.setMessage("Cargando datos....");
        progressDialog.show();


        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(session.checkQuiz())
                    finish();
                if (statusCode==200) {
                    progressDialog.dismiss();
                    //Llamar a la funcion
                    CargaLista(obtDatosJson(new String(responseBody)));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Log.e("HTTP CLIENT", "Error Code" + statusCode + "content: " + new String(responseBody));
                if(error.getCause()instanceof ConnectTimeoutException){
                    Log.e("HTTP CLIENT", "Connection timeout!");
            }
            }
        });


    }

    public void CargaLista(ArrayList<String> datos){

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listado.setAdapter(adapter);

    }


    public ArrayList<String>obtDatosJson(String response){
        ArrayList<String> listado= new ArrayList<String>();
        try {

            JSONArray jsonArray= new JSONArray(response);
            String texto;
            for(int i=0;i<jsonArray.length();i++){
                texto=jsonArray.getJSONObject(i).getString("leccion")+" ";
                listado.add(texto);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return listado;
    }


}
