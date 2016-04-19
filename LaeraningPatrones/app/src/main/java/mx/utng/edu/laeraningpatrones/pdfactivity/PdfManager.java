package mx.utng.edu.laeraningpatrones.pdfactivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import java.io.File;

/**
 * Created by a on 31/03/2016.
 */
public class PdfManager  {
    private static Context mContext;
    private static final String APP_FOLDER_NAME = "Download";
    private static final String INVOICES = "CardBoard";
    private static Font catFont;
    private static Font subFont ;
    private static Font smallBold ;
    private static Font smallFont ;
    private static Font italicFont ;
    private static Font italicFontBold ;

    //Declaramos nuestra fuente base que se encuentra en la carpeta "assets/fonts" folder
    //Usaremos arialuni.ttf que permite imprimir en nuestro PDF caracteres Unicode Cirílicos (Ruso, etc)
    private static BaseFont unicode;

    //!!!Importante: La carpeta "assets/fonts/arialuni.ttf" debe estar creada en nuestro projecto en
    //la subcarpeta "PdfCreator/build/exploded-bundles/ComAndroidSupportAppcompactV71900.aar"
    //En el caso de que Android Studio la eliminara la copiamos manualmente
    //PdfCreator/build/exploded-bundles/ComAndroidSupportAppcompactV71900.aarassets/fonts/arialuni.ttf
    private static File fontFile = new File("assets/fonts/arialuni.ttf");

    private String createDirectoryAndFileName(){

        String FILENAME = "InvoiceSample.pdf";
        String fullFileName ="";
        //Obtenemos el directorio raiz "/sdcard"
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File pdfDir = new File(extStorageDirectory + File.separator + APP_FOLDER_NAME);

        //Creamos la carpeta "com.movalink.pdf" y la subcarpeta "Invoice"
        try {
            if (!pdfDir.exists()) {
                pdfDir.mkdir();
            }
            File pdfSubDir = new File(pdfDir.getPath() + File.separator + INVOICES);

            if (!pdfSubDir.exists()) {
                pdfSubDir.mkdir();
            }

            fullFileName = Environment.getExternalStorageDirectory() + File.separator + APP_FOLDER_NAME + File.separator + INVOICES + File.separator + FILENAME;

            File outputFile = new File(fullFileName);

            if (outputFile.exists()) {
                outputFile.delete();
            }
        } catch (ActivityNotFoundException e) {
            Toast.makeText(mContext,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return fullFileName;
    }

    //Procedimiento para enviar por email el documento PDF generado
    public void sendPdfByEmail(String fileName, String emailTo, String emailCC, Context context){

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Movalink PDF Tutorial email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Working with PDF files in Android");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTo});
        emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{emailCC});

        String sdCardRoot = Environment.getExternalStorageDirectory().getPath();
        String fullFileName = sdCardRoot + File.separator + APP_FOLDER_NAME + File.separator + fileName;

        Uri uri = Uri.fromFile(new File(fullFileName));
        emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
        emailIntent.setType("application/pdf");

        context.startActivity(Intent.createChooser(emailIntent, "Send email using:"));
    }

}
