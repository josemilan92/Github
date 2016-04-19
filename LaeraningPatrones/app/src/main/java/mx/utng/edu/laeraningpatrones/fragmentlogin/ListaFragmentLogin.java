package mx.utng.edu.laeraningpatrones.fragmentlogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 21/03/2016.
 */

public class ListaFragmentLogin extends Fragment {

    public static ListaFragmentLogin newInstance() {

        Bundle args = new Bundle();

        ListaFragmentLogin fragment = new ListaFragmentLogin();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.list_fragment_login, container, false);
        return v;
    }
}
