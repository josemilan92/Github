package mx.utng.edu.laeraningpatrones.correoactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;

public class SendEmailActivity extends Activity {

	UserSessionManager session;
	Button buttonSend;
	EditText textTo;
	EditText textSubject;
	EditText textMessage;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		session= new UserSessionManager(getApplicationContext());
		buttonSend = (Button) findViewById(R.id.buttonSend);
		textSubject = (EditText) findViewById(R.id.editTextSubject);


		buttonSend.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				HashMap<String, String> user=session.getUserDetail();

				String name = user.get(UserSessionManager.KEY_NAME);

				String pass= user.get(UserSessionManager.KEY_PASSWORD);

			  String to = textTo.getText().toString();
			  String subject =  user.get(UserSessionManager.KEY_NAME);
			  String message = "A concluido con exito las lecciones"+ user.get(UserSessionManager.KEY_NAME);
 
			  Intent email = new Intent(Intent.ACTION_SEND);
			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
			  //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
			  //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
			  email.putExtra(Intent.EXTRA_SUBJECT, subject);
			  email.putExtra(Intent.EXTRA_TEXT, message);


				TextView lblName=(TextView)findViewById(R.id.txv_nombre);

				lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
			  //need this to prompts email client only
			  email.setType("message/rfc822");
			  
			  startActivity(Intent.createChooser(email, "Choose an Email client :"));

			}
		});
	}



}