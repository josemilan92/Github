package mx.utng.edu.laeraningpatrones.correoactivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;


public class CorreoActivity extends AppCompatActivity implements OnClickListener {

    EditText editTextEmail, editTextSubject, editTextMessage;
    Button btnSend, btnAttachment;
    String email, subject, message, attachmentFile;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    int columnIndex;
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correoactivity);
        editTextEmail = (EditText) findViewById(R.id.editTextTo);
        btnAttachment = (Button) findViewById(R.id.buttonAttachment);
        btnSend = (Button) findViewById(R.id.buttonSend);
        session= new UserSessionManager(getApplicationContext());
        btnSend.setOnClickListener(this);
        btnAttachment.setOnClickListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            /**
             * Get Path
             */
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            attachmentFile = cursor.getString(columnIndex);
            Log.e("Attachment Path:", attachmentFile);
            URI = Uri.parse("file://" + attachmentFile);
            cursor.close();
        }
    }

    @Override
    public void onClick(View v) {

        if (v == btnAttachment) {
            openGallery();

        }
        if (v == btnSend) {
            try {

                HashMap<String, String> user=session.getUserDetail();

                email = editTextEmail.getText().toString();
                subject = user.get(UserSessionManager.KEY_NAME);
                message = "A concluido con exito las lecciones"+ user.get(UserSessionManager.KEY_NAME);


                final Intent emailIntent = new Intent(
                        android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[] { email });
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        subject);
                if (URI != null) {
                    emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
                }
                emailIntent
                        .putExtra(android.content.Intent.EXTRA_TEXT, message);
                this.startActivity(Intent.createChooser(emailIntent,
                        "Sending email..."));

            } catch (Throwable t) {
                Toast.makeText(this,
                        "Request failed try again: " + t.toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(
                Intent.createChooser(intent, "Complete action using"),
                PICK_FROM_GALLERY);

    }

}