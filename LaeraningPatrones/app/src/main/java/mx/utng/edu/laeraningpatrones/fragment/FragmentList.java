package mx.utng.edu.laeraningpatrones.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.activitytab.LeccionCincoJson;
import mx.utng.edu.laeraningpatrones.activitytab.LeccionCuatroJson;
import mx.utng.edu.laeraningpatrones.activitytab.LeccionDosJson;
import mx.utng.edu.laeraningpatrones.activitytab.LeccionSeisJson;
import mx.utng.edu.laeraningpatrones.activitytab.LeccionTresJson;
import mx.utng.edu.laeraningpatrones.activitytab.LeccionUnoJson;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueQuizTres;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentList extends ListFragment {

    BloqueQuizTres session;

    public String[] sistemas={
            "","Introducción", "Un caso de estudio: diseñando un editor de documentos", "Patrones de creación", "Patrones estructurales","Patrones de comportamiento"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sistemas));

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        switch (position) {
            case 1:
                Intent a = new Intent(getActivity().getApplicationContext(),LeccionUnoJson.class );
                startActivity(a);
                break;
            case 2:
                Intent b = new Intent(getActivity().getApplicationContext(),LeccionDosJson.class );
                startActivity(b);
                break;
            case 3:

                Intent c = new Intent(getActivity().getApplicationContext(),LeccionTresJson.class );
                startActivity(c);

            case 4:
                Intent d = new Intent(getActivity().getApplicationContext(),LeccionCuatroJson.class );
                startActivity(d);
                break;
            case 5:
                Intent e = new Intent(getActivity().getApplicationContext(),LeccionCincoJson.class );
                startActivity(e);
                break;
            case 6:
                Intent f = new Intent(getActivity().getApplicationContext(),LeccionSeisJson.class );
                startActivity(f);
                break;

            default:
                break;

        }

         }
}
