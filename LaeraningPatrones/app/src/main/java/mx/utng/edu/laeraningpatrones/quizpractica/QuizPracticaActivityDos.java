package mx.utng.edu.laeraningpatrones.quizpractica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.BloqueQuiz;

public class QuizPracticaActivityDos extends Activity {
	
	private int currentQuestion; 
	private String [] questions; 
	private String [] answers;
	private Button answerButton; 
	private Button questionButton; 
	private TextView questionView; 
	private TextView answerView; 
	private EditText answerText;

	BloqueQuiz session;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_practica);
		session= new BloqueQuiz(getApplicationContext());
		if(session.checkQuiz())
			finish();
        init();
    }
    
    public void init() {
    	questions = new String[]{"¿Instancia de siongleton?", "¿Instancias estatica?", "Define una clase statica Singleton"};
    	answers = new String[]{"Singleton::Instancia","static,MiSingleton,elSingleton", "static Singleton"};
    	currentQuestion = -1;
    	answerButton = (Button)findViewById(R.id.AnswerButton); questionButton = (Button)findViewById(R.id.QuestionButton); questionView = (TextView)
    	findViewById(R.id.QuestionTextView);
    	answerView = (TextView) findViewById(R.id.AnswerTextView); 
    	answerText = (EditText) findViewById(R.id.AnswerText); 
    	
    	answerButton.setOnClickListener(new OnClickListener(){
    	@Override
    	public void onClick(View v) { checkAnswer();
    	}});
    	questionButton.setOnClickListener(new OnClickListener(){ 
    		@Override
    	public void onClick(View v) { showQuestion();
    	}});
    	
    
    }
	/*Este Metodo hace:
    *
    * 1: Incrementa el currentQuestion
    * 2: Rebisa si la longitud es la misma
    * 3: Muestra la pregunta en el currentQuestion index in question view
    * 4: Vacia answer view
    */
    	public void showQuestion() {
    	currentQuestion++;
    	if(currentQuestion == questions.length)
    	currentQuestion =0;
    	questionView.setText(questions[currentQuestion]); answerView.setText("");
    	answerText.setText("");
    	}
	/*
    * Este metodo regresa si el array es el mismo
    * (Ignoring case)
    */
    	public boolean isCorrect(String answer) {
    	return (answer.equalsIgnoreCase(answers[currentQuestion])); }
	/* Este metodo :
    * 1: Lee el texto ( answer) del  TextEdit * 2: Llama al metodo isCorrect
    * 2: Muestra el mensaje correcto
    */
    	public void checkAnswer() {
    	String answer = answerText.getText().toString(); if(isCorrect(answer))
    	answerView.setText("Estas en lo correcto!"); else
    	answerView.setText("Lo siento la respuesta correcta es: "+answers[currentQuestion]);
    	}
    
    
    
}