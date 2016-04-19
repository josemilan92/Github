package mx.utng.edu.laeraningpatrones.pdfactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 28/03/2016.
 */
public class PdfArchivoTres extends Activity implements View.OnClickListener {
    private Button b1,b2,b3,b4;
    private final static String NOMBRE_DIRECTORIO = "Cardboard";
    private final static String NOMBRE_DOCUMENTO = "prueba.pdf";
    private final static String ETIQUETA_ERROR = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        // Generaremos el documento al hacer click sobre el botón.
        findViewById(R.id.btn_final).setOnClickListener(this);

    }

        public void sendPdfByEmail(String fileName, String emailTo, String emailCC, Context context){

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Movalink PDF Tutorial email");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Working with PDF files in Android");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTo});
            emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{emailCC});

            String sdCardRoot = Environment.getExternalStorageDirectory().getPath();
            String fullFileName = sdCardRoot + File.separator + NOMBRE_DIRECTORIO + File.separator + fileName;

            Uri uri = Uri.fromFile(new File(fullFileName));
            emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
            emailIntent.setType("application/pdf");

            context.startActivity(Intent.createChooser(emailIntent, "Send email using:"));
        }

    @Override
    public void onClick(View v) {

    }
}
