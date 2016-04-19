package mx.utng.edu.laeraningpatrones.desarrollador;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 29/03/2016.
 */
public class DesarrolladorFragment extends android.support.v4.app.Fragment {
    public static DesarrolladorFragment newInstance() {

        Bundle args = new Bundle();

        DesarrolladorFragment fragment = new DesarrolladorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.desarrolladores_layout, container, false);
        return v;
    }
}
