package mx.utng.edu.laeraningpatrones.fragmentpractica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.quizpractica.QuizPracticaActivity;
import mx.utng.edu.laeraningpatrones.quizpractica.QuizPracticaActivityCuatro;
import mx.utng.edu.laeraningpatrones.quizpractica.QuizPracticaActivityDos;
import mx.utng.edu.laeraningpatrones.quizpractica.QuizPracticaActivityTres;
import mx.utng.edu.laeraningpatrones.quizpractica.QuizPracticaCinco;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentListPractica extends ListFragment {




    String[] practica;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        practica=getResources().getStringArray(R.array.Practica);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, practica));

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {


            case 1:
                Intent a = new Intent(getActivity().getApplicationContext(),QuizPracticaActivity.class );
                startActivity(a);
                break;
            case 2:
                Intent b = new Intent(getActivity().getApplicationContext(),QuizPracticaActivityDos.class );
                startActivity(b);
                break;
            case 3:
                Intent c = new Intent(getActivity().getApplicationContext(),QuizPracticaActivityTres.class );
                startActivity(c);
                break;
            case 4:
                Intent d = new Intent(getActivity().getApplicationContext(),QuizPracticaActivityCuatro.class );
                startActivity(d);
                break;
            case 5:

                Intent e = new Intent(getActivity().getApplicationContext(),QuizPracticaCinco.class );
                startActivity(e);
                break;
            default:
                break;

        } }
}
