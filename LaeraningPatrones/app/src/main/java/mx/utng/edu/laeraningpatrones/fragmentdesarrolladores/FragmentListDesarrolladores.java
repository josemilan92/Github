package mx.utng.edu.laeraningpatrones.fragmentdesarrolladores;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentListDesarrolladores extends ListFragment {

    String[] desa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        desa=getResources().getStringArray(R.array.Desarro);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, desa));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {


            case 1:
                String url="http://www.sgoliver.net/blog/ficheros-en-android-ii-memoria-externa-tarjeta-sd/";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
//
                break;
            case 2:
                String urla="http://www.sgoliver.net/blog/ficheros-en-android-i-memoria-interna/";
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(urla));
                startActivity(b);
                break;
            case 3:
                String urlc="http://www.jc-mouse.net/android/graficos-estadisticos-con-base-de-datos-sqlite";
                Intent c= new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse(urlc));
                startActivity(c);
                  break;
            case 4:

                String urld="http://www.jc-mouse.net/android/graficos-estadisticos-con-base-de-datos-sqlite";
                Intent d= new Intent(Intent.ACTION_VIEW);
                d.setData(Uri.parse(urld));
                startActivity(d);

                break;
            case 5:
                String urle="http://www.lawebdelprogramador.com/foros/Android/1490181-guardar-textos-escritos-en-una-web-android-studio.html";
                Intent e= new Intent(Intent.ACTION_VIEW);
                e.setData(Uri.parse(urle));
                startActivity(e);
            default:
                break;

        }
    }
}
