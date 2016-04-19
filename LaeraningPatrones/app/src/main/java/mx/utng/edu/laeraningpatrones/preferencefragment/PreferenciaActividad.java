package mx.utng.edu.laeraningpatrones.preferencefragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.graphics.Color;

import mx.utng.edu.laeraningpatrones.R;


/**
 * Created by a on 04/04/2016.
 */
public class PreferenciaActividad extends Activity {


    private TextView answerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_practica);
answerView=(TextView)findViewById(R.id.QuestionTextView);


    }

    @Override
    protected void onResume() {
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);


        int color, textSize;
        String text;

        boolean usingPreferences= pref.getBoolean("cbxPreferenceOn", false);

        if(usingPreferences){
            text=pref.getString("etpTexto", "Texto por defecto");

            String prefColor= pref.getString("lpFondo", "transparent");
            if(prefColor.equals("red"))
                color= Color.RED;
            else if (prefColor.equals("gray"))
                color=Color.GRAY;
            else if (prefColor.equals("blue"))
                color=Color.BLUE;
            else
                color=Color.TRANSPARENT;

            String prefTextSize= pref.getString("lpTexto", "normal");
            if(prefTextSize.equals("medium"))
                textSize=18;
            else if (prefTextSize.equals("big"))
                textSize=22;
            else
                textSize=14;
        }else {
            text="Texto por defecto";
            color=Color.TRANSPARENT;
            textSize=18;
        }
        answerView.setText(text);
        answerView.setText(color);
        answerView.setTextSize(textSize);
        super.onResume();
    }
}
