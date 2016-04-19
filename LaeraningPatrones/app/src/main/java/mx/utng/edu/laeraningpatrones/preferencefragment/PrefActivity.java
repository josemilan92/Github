package mx.utng.edu.laeraningpatrones.preferencefragment;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by a on 04/04/2016.
 */
public class PrefActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferenceFragmentConfig()).commit();
    }
}
