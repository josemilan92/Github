package mx.utng.edu.laeraningpatrones.quizactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.activity.Inicio;
import mx.utng.edu.laeraningpatrones.atributos.Question;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueCuatro;
import mx.utng.edu.laeraningpatrones.dbhelperquiz.DbHelper;
import mx.utng.edu.laeraningpatrones.resultados.ResultActivityCinco;

public class QuizActivityCinco extends AppCompatActivity {
	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion, text;
	RadioButton rda, rdb, rdc;
	Button butNext;
	UserSessionManager session;
	BloqueCuatro sessioncuatro;
	CountDownTimer countDownTimer;
	boolean timerHasStarted=false;
	final long starTime=30*1000;
	final long interval=1*1000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		text=(TextView)findViewById(R.id.timer);
		countDownTimer=new QuizActivityCinco.MyCountDownTimer(starTime, interval);
		text.setText(text.getText() + String.valueOf(starTime / 1000));
		sessioncuatro= new BloqueCuatro(getApplicationContext());
		if(sessioncuatro.checkQuiz())
			finish();
		session= new UserSessionManager(getApplicationContext());
		if(session.checkLogin())
			finish();
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestionsS();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.txvQuiz);
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		butNext=(Button)findViewById(R.id.btnsig);
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				if(!timerHasStarted){
					countDownTimer.start();
					timerHasStarted=true;
					butNext.setText("Siguiente");
				}else {
					countDownTimer.cancel();
					timerHasStarted=false;
					butNext.setText("Empezar");
				}
				RadioGroup grp=(RadioGroup)findViewById(R.id.rdg1);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getRESPUESTA()+" "+answer.getText());
				if(currentQ.getRESPUESTA().equals(answer.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
				}
				if(qid<5){					
					currentQ=quesList.get(qid);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivityCinco.this, ResultActivityCinco.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
				}
			}
		}

		);

	}
	public class MyCountDownTimer extends CountDownTimer{
		public MyCountDownTimer(long starTime , long interval){
			super(starTime, interval);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			text.setText(""+millisUntilFinished/1000);
		}

		@Override
		public void onFinish() {
			text.setText("Times up");
			Intent a = new Intent(getApplicationContext(), Inicio.class);
			startActivity(a);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_navegar, menu);
		return true;
	}
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getPREGUNTA());
		rda.setText(currentQ.getOpcionA());
		rdb.setText(currentQ.getOpcionB());
		rdc.setText(currentQ.getOpcionC());
		qid++;
	}
}
