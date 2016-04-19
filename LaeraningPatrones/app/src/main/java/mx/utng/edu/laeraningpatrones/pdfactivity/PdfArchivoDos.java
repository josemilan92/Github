package mx.utng.edu.laeraningpatrones.pdfactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;

import java.io.File;

import mx.utng.edu.laeraningpatrones.R;

/**
 * Created by a on 31/03/2016.
 */
public class PdfArchivoDos extends Activity {
    private String INVOICES_FOLDER = "Cardboard";
    private String FILENAME = "prueba.pdf";
    //Declaramos la clase PdfManager
    private PdfManager pdfManager = null;

    private final static String NOMBRE_DIRECTORIO = "Cardboard";
    private final static String NOMBRE_DOCUMENTO = "prueba.pdf";
    private final static String ETIQUETA_ERROR = "ERROR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_layout);
    }


    public static File getRuta() {

        // El fichero será almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            ruta = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    NOMBRE_DIRECTORIO);

            if (ruta != null) {
                if (!ruta.mkdirs()) {
                    if (!ruta.exists()) {
                        return null;
                    }
                }
            }
        } else {
        }

        return ruta;
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
    //Código generado por Android Studio
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navegar, menu);
        return true;
    }


}