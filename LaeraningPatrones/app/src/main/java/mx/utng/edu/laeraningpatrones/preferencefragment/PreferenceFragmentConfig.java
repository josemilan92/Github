package mx.utng.edu.laeraningpatrones.preferencefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 20/03/2016.
 */
public class PreferenceFragmentConfig extends PreferenceFragment {

    public static PreferenceFragmentConfig newInstance() {
        
        Bundle args = new Bundle();
        
        PreferenceFragmentConfig fragment = new PreferenceFragmentConfig();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.configurar);
    }
}
