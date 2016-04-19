package mx.utng.edu.laeraningpatrones.resultados;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.Grafica;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueQuizCinco;
import mx.utng.edu.laeraningpatrones.dbhelperquiz.GraficaHelperDos;
import mx.utng.edu.laeraningpatrones.graficosactivity.GraficoActivityDos;

public class ResultActivityCinco extends Activity {


	GraficaHelperDos db= new GraficaHelperDos(this);
	Grafica g= new Grafica();

	BloqueQuizCinco session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		session= new BloqueQuizCinco(getApplicationContext());
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.rb1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.txvResult);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score
		bar.setRating(score);

		switch (score)
		{
		case 1:

		case 2: t.setText(R.string.caliuno);

		break;
		case 3:

			case 4:t.setText(R.string.califdos);

			case 5:t.setText(R.string.califtres);
				g.setNombre(getString(R.string.lecccinco));
				g.setSigla(getString(R.string.cinco));
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
