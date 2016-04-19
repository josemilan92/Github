package mx.utng.edu.laeraningpatrones.fragmentmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.quizactivity.QuizActivity;
import mx.utng.edu.laeraningpatrones.quizactivity.QuizActivityDos;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentListMenu extends ListFragment {

    String[]menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu=getResources().getStringArray(R.array.Lista);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, menu));

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 1:
                Intent a = new Intent(getActivity().getApplicationContext(),QuizActivity.class );
                startActivity(a);
                break;
            case 2:
                Intent b = new Intent(getActivity().getApplicationContext(), QuizActivityDos.class);
                startActivity(b);
                break;

            default:
                break;

        } }
}
