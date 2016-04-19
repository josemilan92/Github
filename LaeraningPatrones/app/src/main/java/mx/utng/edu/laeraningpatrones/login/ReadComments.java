package mx.utng.edu.laeraningpatrones.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.activity.Inicio;
import mx.utng.edu.laeraningpatrones.atributos.BloqueQuiz;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueCuatro;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueQuizCinco;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueQuizDos;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueQuizTres;


public class ReadComments extends ActionBarActivity {


    UserSessionManager session;
    BloqueQuiz sessionuno;
    BloqueQuizDos sessiondos;
    BloqueQuizTres sessiontres;
    BloqueCuatro sessioncuatro;
    BloqueQuizCinco sessioncinco;
    Button btnlogout;
    Button btnmenu;
    Button btnborrado;
    private final static String NOMBRE_DIRECTORIO = "Cardboard";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // note that use read_comments.xml instead of our single_post.xml
        setContentView(R.layout.read_comments);
        btnlogout=(Button)findViewById(R.id.btn_logut);
        btnmenu=(Button)findViewById(R.id.btn_menu);
        btnborrado=(Button)findViewById(R.id.btn_borrado);


        session= new UserSessionManager(getApplicationContext());
        sessionuno= new BloqueQuiz(getApplicationContext());
        sessiondos= new BloqueQuizDos(getApplicationContext());
        sessiontres= new BloqueQuizTres(getApplicationContext());
        sessioncuatro= new BloqueCuatro(getApplicationContext());
        sessioncinco= new BloqueQuizCinco(getApplicationContext());

        TextView lblName=(TextView)findViewById(R.id.txv_nombre);
        TextView lblPass=(TextView)findViewById(R.id.txv_password);

         if(session.checkLogin())
            finish();

        HashMap<String, String>user=session.getUserDetail();

        String name = user.get(UserSessionManager.KEY_NAME);

        String pass= user.get(UserSessionManager.KEY_PASSWORD);

        lblName.setText(Html.fromHtml("Name: <b>"+name+"</b>"));



        btnborrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionuno.logoutUser();
                sessiondos.logoutUser();
                sessiontres.logoutUser();
                sessioncuatro.logoutUser();
                sessioncinco.logoutUser();
            }
        });

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), Inicio.class);
                startActivity(a);

            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();


            }

        });


    }

}
