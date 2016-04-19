package mx.utng.edu.laeraningpatrones.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;
import mx.utng.edu.laeraningpatrones.desarrollador.DesarrolladorFragment;
import mx.utng.edu.laeraningpatrones.fragment.ListaFragment;
import mx.utng.edu.laeraningpatrones.fragmentdesarrolladores.ListaFragmentDesarrolladores;
import mx.utng.edu.laeraningpatrones.fragmentgrafico.ListaFragmentGrafico;
import mx.utng.edu.laeraningpatrones.fragmentmenu.ListaFragmentMenu;
import mx.utng.edu.laeraningpatrones.fragmentpractica.ListaFragmentPractica;
import mx.utng.edu.laeraningpatrones.fragmentquiz.ListaFragmentUno;
import mx.utng.edu.laeraningpatrones.fragmentsonido.ListaFragmentSonido;
import mx.utng.edu.laeraningpatrones.fragmentvideo.ListaFragmentVideo;
import mx.utng.edu.laeraningpatrones.juegosactivity.Manager;
import mx.utng.edu.laeraningpatrones.login.ReadComments;
import mx.utng.edu.laeraningpatrones.login.Register;
import mx.utng.edu.laeraningpatrones.preferencefragment.PreferenciaActivity;

/**
 * Created by a on 20/03/2016.
 */
public class Inicio extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout dl=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, dl, toolbar, R.string.open, R.string.close);
        dl.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView nv=(NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Integer i = item.getItemId();
        UserSessionManager session;
        session= new UserSessionManager(this);
        Intent it=null;
        boolean retorno=false;
        limpiar();
        if(i==R.id.m_inicio){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, DesarrolladorFragment.newInstance(), "Inicio").commit();
            Toast.makeText(this, R.string.de, Toast.LENGTH_SHORT).show();
            retorno=true;


        }
        if(i==R.id.m_contenido){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragment.newInstance(), "Quiz").commit();
            Toast.makeText(this, R.string.cont, Toast.LENGTH_SHORT).show();
            retorno=true;

        }
        if(i==R.id.m_galeria){


            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentVideo.newInstance(), "Video").commit();
            Toast.makeText(this, R.string.vid, Toast.LENGTH_SHORT).show();
            retorno=true;


        }
        if(i==R.id.m_sonido){


            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentSonido.newInstance(), "Sonido").commit();
            Toast.makeText(this, R.string.soni, Toast.LENGTH_SHORT).show();
            retorno=true;

        }
        if(i==R.id.m_quiz){


            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentUno.newInstance(), "Inicio").commit();
            Toast.makeText(this, R.string.test, Toast.LENGTH_SHORT).show();
            retorno=true;

        }

        if(i==R.id.m_configurar){

            Intent a = new Intent(getApplicationContext(), PreferenciaActivity.class);
            startActivity(a);
            Toast.makeText(this, R.string.login, Toast.LENGTH_SHORT).show();
            retorno = true;


        }
        if(i==R.id.m_login ) {

            Intent a = new Intent(getApplicationContext(), ReadComments.class);
            startActivity(a);
            Toast.makeText(this, R.string.login, Toast.LENGTH_SHORT).show();
            retorno = true;

        }
        if(i==R.id.m_registrar){
            Intent a = new Intent(getApplicationContext(), Register.class );
            startActivity(a);
            Toast.makeText(this, R.string.reg, Toast.LENGTH_SHORT).show();
            retorno=true;

        }
        if(i==R.id.m_resultado){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentGrafico.newInstance(), "Inicio").commit();
            Toast.makeText(this, R.string.res, Toast.LENGTH_SHORT).show();
            retorno=true;

        }

        if(i==R.id.m_codigo){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentPractica.newInstance(), "Practica").commit();
            Toast.makeText(this, R.string.prac, Toast.LENGTH_SHORT).show();
            retorno=true;

        }
        if(i==R.id.m_despliegue){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentMenu.newInstance(), "Practica").commit();
            Toast.makeText(this, R.string.ind, Toast.LENGTH_SHORT).show();
            retorno=true;

        }

        if(i==R.id.m_acerca){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, ListaFragmentDesarrolladores.newInstance(), "Desarrollador").commit();
            Toast.makeText(this, R.string.desa, Toast.LENGTH_SHORT).show();
            retorno=true;

        }
        if(i==R.id.m_juego){
            Intent a = new Intent(getApplicationContext(),Manager.class );
            startActivity(a); Toast.makeText(this, R.string.jueg, Toast.LENGTH_SHORT).show();
            retorno=true;

        }
        if(i==R.id.m_cerrar){
            Toast.makeText(this, R.string.cerr, Toast.LENGTH_SHORT).show();
            finish();
            retorno=true;

        }
        DrawerLayout dl=(DrawerLayout)findViewById(R.id.drawer_layout);
        dl.closeDrawer(GravityCompat.START);
        return retorno;
    }
    private Integer limpiar(){

        Fragment f1=getSupportFragmentManager().findFragmentByTag("Inicio");
        if(f1!=null)getSupportFragmentManager().beginTransaction().remove(f1).commit();


        Fragment f2=getSupportFragmentManager().findFragmentByTag("Contenido");
        if(f2!=null)getSupportFragmentManager().beginTransaction().remove(f2).commit();

        Fragment f3=getSupportFragmentManager().findFragmentByTag("Video");
        if(f3!=null)getSupportFragmentManager().beginTransaction().remove(f3).commit();

        Fragment f4=getSupportFragmentManager().findFragmentByTag("Login");
        if(f4!=null)getSupportFragmentManager().beginTransaction().remove(f4).commit();

        Fragment f5=getSupportFragmentManager().findFragmentByTag("Configurar");
        if(f5!=null)getSupportFragmentManager().beginTransaction().remove(f5).commit();

        Fragment f6=getSupportFragmentManager().findFragmentByTag("Quiz");
        if(f6!=null)getSupportFragmentManager().beginTransaction().remove(f6).commit();

        Fragment f7=getSupportFragmentManager().findFragmentByTag("Registrar");
        if(f7!=null)getSupportFragmentManager().beginTransaction().remove(f7).commit();

        android.app.Fragment f8=getFragmentManager().findFragmentByTag("Configurar");
        if(f8!=null)getFragmentManager().beginTransaction().remove(f8).commit();



        android.app.Fragment f9=getFragmentManager().findFragmentByTag("Sonido");
        if(f9!=null)getFragmentManager().beginTransaction().remove(f9).commit();

        android.app.Fragment f10=getFragmentManager().findFragmentByTag("Practica");
        if(f10!=null)getFragmentManager().beginTransaction().remove(f9).commit();

        android.app.Fragment f11=getFragmentManager().findFragmentByTag("Desarrollador");
        if(f11!=null)getFragmentManager().beginTransaction().remove(f11).commit();
        return 1;
    }
}
