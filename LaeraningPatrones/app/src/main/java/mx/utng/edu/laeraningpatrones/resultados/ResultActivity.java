package mx.utng.edu.laeraningpatrones.resultados;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.BloqueQuiz;
import mx.utng.edu.laeraningpatrones.atributos.Grafica;
import mx.utng.edu.laeraningpatrones.dbhelperquiz.GraficaHelperDos;
import mx.utng.edu.laeraningpatrones.graficosactivity.GraficoActivityDos;

public class ResultActivity extends Activity {


	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();

	BloqueQuiz session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		session= new BloqueQuiz(getApplicationContext());
		//Recibiendo la cantidad para llenar las estrellas
		RatingBar bar=(RatingBar)findViewById(R.id.rb1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//Recibiendo el texto
		TextView t=(TextView)findViewById(R.id.txvResult);
		//Recibiendo el contenido
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//Mostrando resultado
		bar.setRating(score);

		switch (score)
		{
		case 1:

		case 2: t.setText(R.string.caliuno);

		break;
		case 3:

		case 4:t.setText(R.string.califdos);

		;
			case 5:t.setText(R.string.califtres);
				g.setNombre(getString(R.string.lecuno));
				g.setSigla(getString(R.string.leccunoin));
				g.setVotos(20);
				db.insertResult(g);
				session.createUserQuiz("pass", "pass");
				Intent i=new Intent(getApplicationContext(), GraficoActivityDos.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
		break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_navegar, menu);
		return true;
	}
}
