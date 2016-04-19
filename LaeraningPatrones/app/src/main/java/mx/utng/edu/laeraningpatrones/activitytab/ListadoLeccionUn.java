package mx.utng.edu.laeraningpatrones.activitytab;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 27/03/2016.
 */
public class ListadoLeccionUn extends Activity {

    private ProgressDialog pDialog;

    JSONParser jParser= new JSONParser();

    ArrayList<HashMap<String, String>>listado;

    private static String url_listado="http://josemilan.esy.es/jose/conexiondos.php";

    private static final String TAG_ID="id";
    private static final String TAG_LECCIONES="leccion";

    JSONArray lecciones=null;
    ListView lista;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_layout);


        listado=new ArrayList<HashMap<String, String>>();


        new LoadAllLecciones().execute();

        lista=(ListView)findViewById(R.id.lst_materias);



    }

    class  LoadAllLecciones extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog= new ProgressDialog(ListadoLeccionUn.this);
            pDialog.setMessage("Cargando Lecciones....");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            List params= new ArrayList();


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
