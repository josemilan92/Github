package mx.utng.edu.laeraningpatrones.fragmentgrafico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.correoactivity.CorreoActivity;
import mx.utng.edu.laeraningpatrones.graficosactivity.GraficoActivityDos;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentListGrafico extends ListFragment {

    String[] grafico;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        grafico=getResources().getStringArray(R.array.Grafico);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, grafico));

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position) {


            case 1:
                Intent b = new Intent(getActivity().getApplicationContext(),GraficoActivityDos.class );
                startActivity(b);

                break;
            case 2:
                Intent c = new Intent(getActivity().getApplicationContext(),CorreoActivity.class );
                startActivity(c);
                break;
            default:
                break;

        }
    }
}
