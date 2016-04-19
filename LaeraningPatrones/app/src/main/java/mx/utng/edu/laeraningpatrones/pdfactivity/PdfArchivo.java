package mx.utng.edu.laeraningpatrones.pdfactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import harmony.java.awt.Color;
import mx.utng.edu.laeraningpatrones.R;
import mx.utng.edu.laeraningpatrones.atributos.UserSessionManager;
import mx.utng.edu.laeraningpatrones.bloqueos.BloqueCuatro;

/**
 * Created by a on 28/03/2016.
 */
public class PdfArchivo extends Activity implements View.OnClickListener {

    private final static String NOMBRE_DIRECTORIO = "Cardboard";
    private final static String NOMBRE_DOCUMENTO = "prueba.pdf";
    private final static String ETIQUETA_ERROR = "ERROR";

    UserSessionManager session;
    BloqueCuatro sessioncuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        sessioncuatro= new BloqueCuatro(getApplicationContext());
        if(sessioncuatro.checkQuiz())
            finish();
        session= new UserSessionManager(getApplicationContext());
        if(session.checkLogin())
            finish();
        // Generaremos el documento al hacer click sobre el botón.
        findViewById(R.id.btn_final).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Creamos el documento.
        Document documento = new Document();

        try {

            // Creamos el fichero con el nombre que deseemos.
            File f = crearFichero(NOMBRE_DOCUMENTO);

            // Creamos el flujo de datos de salida para el fichero donde
            // guardaremos el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream(
                    f.getAbsolutePath());

            // Asociamos el flujo que acabamos de crear al documento.
            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);

            // Incluimos el píe de página y una cabecera
            HeaderFooter cabecera = new HeaderFooter(new Phrase(
                    "Learning Patrones"), false);
            HeaderFooter pie = new HeaderFooter(new Phrase(
                    "Creador Josè Alfredo Nùñez Contreras"), false);

            documento.setHeader(cabecera);
            documento.setFooter(pie);

            // Abrimos el documento.
            documento.open();

            // Añadimos un título con la fuente por defecto.
            documento.add(new Paragraph("Acreditación de Learning patrones"));

            // Añadimos un título con una fuente personalizada.
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 28, Font.BOLD, Color.RED);
            documento.add(new Paragraph("Acreditacion de Learning patrones", font));

            // Insertamos una imagen que se encuentra en los recursos de la
            // aplicación.
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    R.drawable.ic_logodos);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            Image imagen = Image.getInstance(stream.toByteArray());
            documento.add(imagen);

            // Agregar marca de agua
            font = FontFactory.getFont(FontFactory.HELVETICA, 42, Font.BOLD, Color.GRAY);
            ColumnText.showTextAligned(writer.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Paragraph(
                            "Aprenda con aplicaciones", font), 297.5f, 421,
                    writer.getPageNumber() % 2 == 1 ? 45 : -45);

        } catch (DocumentException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

        } catch (IOException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

        } finally {

            // Cerramos el documento.
            documento.close();
        }
    }

    /**
     * Crea un fichero con el nombre que se le pasa a la función y en la ruta
     * especificada.
     *
     * @param nombreFichero
     * @return
     * @throws IOException
     */
    public static File crearFichero(String nombreFichero) throws IOException {
        File ruta = getRuta();
        File fichero = null;
        if (ruta != null)
            fichero = new File(ruta, nombreFichero);
        return fichero;
    }

    /**
     * Obtenemos la ruta donde vamos a almacenar el fichero.
     *
     * @return
     */
    public static File getRuta() {

        // El fichero será almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            ruta = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), NOMBRE_DIRECTORIO);

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

}
