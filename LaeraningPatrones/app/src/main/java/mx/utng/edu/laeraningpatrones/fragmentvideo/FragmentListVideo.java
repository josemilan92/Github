package mx.utng.edu.laeraningpatrones.fragmentvideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.videoyoutube.VideoCincoActivity;
import mx.utng.edu.laeraningpatrones.videoyoutube.VideoCuatroActivity;
import mx.utng.edu.laeraningpatrones.videoyoutube.VideoDosActivity;
import mx.utng.edu.laeraningpatrones.videoyoutube.VideoTresActivity;
import mx.utng.edu.laeraningpatrones.videoyoutube.VideoUnoActivity;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentListVideo extends ListFragment {

    String[] videos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videos=getResources().getStringArray(R.array.Video);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, videos));

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position) {

            case 1:
                Intent a = new Intent(getActivity().getApplicationContext(),VideoUnoActivity.class );
                startActivity(a);

                break;
            case 2:
                Intent b = new Intent(getActivity().getApplicationContext(),VideoDosActivity.class );
                startActivity(b);

                break;
            case 3:

                    Intent c = new Intent(getActivity().getApplicationContext(),VideoTresActivity.class );
                    startActivity(c);


                break;
            case 4:

                    Intent d = new Intent(getActivity().getApplicationContext(),VideoCuatroActivity.class );
                    startActivity(d);

                break;
            case 5:
                Intent e = new Intent(getActivity().getApplicationContext(),VideoCincoActivity.class );
                startActivity(e);

                break;
            default:
                break;

        }
    }
}
