package mx.utng.edu.laeraningpatrones.activitytab;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 27/03/2016.
 */
public class JSONParser extends AppCompatActivity {

    private ListView listView;

    ArrayList lecciones= new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_layout);
        listView=(ListView)findViewById(R.id.lst_materias);
        descargar();

    }

    private void descargar(){
        lecciones.clear();
    final ProgressDialog progressDialog= new ProgressDialog(JSONParser.this);
        progressDialog.setMessage("Cargando datos....");
        progressDialog.show();

        AsyncHttpClient client= new AsyncHttpClient();
        client.get("http://josemilan.esy.es/jose/conexion.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    progressDialog.dismiss();
                    try {

                        JSONArray jsonArray = new JSONArray(new String(responseBody));
                        for (int i = 0; i < jsonArray.length(); i++) {

                            lecciones.add(jsonArray.getJSONObject(i).getString("leccion"));

                        }
                        listView.setAdapter(new ImagenAdapter(getApplicationContext()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    public void CargaLista(ArrayList<String> datos){

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

    }
    private class ImagenAdapter extends BaseAdapter{
Context ctx;
        LayoutInflater layoutInflater;
        TextView txvLeccion;

        public ImagenAdapter(Context aplicationContext){
            this.ctx=aplicationContext;
            layoutInflater=(LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return lecciones.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewGroup viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.activity_main_item, null);
            txvLeccion=(TextView)viewGroup.findViewById(R.id.txvTitulo);

            return null;
        }
    }
}
