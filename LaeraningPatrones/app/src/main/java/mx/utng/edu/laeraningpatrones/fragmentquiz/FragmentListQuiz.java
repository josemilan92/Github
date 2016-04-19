package mx.utng.edu.laeraningpatrones.fragmentquiz;

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
import mx.utng.edu.laeraningpatrones.quizactivity.QuizActivityCinco;
import mx.utng.edu.laeraningpatrones.quizactivity.QuizActivityCuatro;
import mx.utng.edu.laeraningpatrones.quizactivity.QuizActivityDos;
import mx.utng.edu.laeraningpatrones.quizactivity.QuizActivityTres;

/**
 * Created by a on 21/03/2016.
 */
public class FragmentListQuiz extends ListFragment {




    String[] quiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quiz=getResources().getStringArray(R.array.Practica);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, quiz));

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
            case 3:
                Intent c = new Intent(getActivity().getApplicationContext(), QuizActivityTres.class);
                startActivity(c);
                break;
            case 4:
                Intent d = new Intent(getActivity().getApplicationContext(), QuizActivityCuatro.class);
                startActivity(d);
                break;
            case 5:
                Intent e= new Intent(getActivity().getApplicationContext(), QuizActivityCinco.class);
                startActivity(e);
                break;

            default:
                break;

        } }
}
