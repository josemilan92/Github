package mx.utng.edu.laeraningpatrones.dbhelperquiz;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.utng.edu.laeraningpatrones.atributos.Question;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "triviaQuiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		String sqld = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTD + " ( "
				+ KEY_IDD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESD
				+ " TEXT, " + KEY_ANSWERD+ " TEXT, "+KEY_OPTAD +" TEXT, "
				+KEY_OPTBD +" TEXT, "+KEY_OPTCD+" TEXT)";
		String sqlt = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTT + " ( "
				+ KEY_IDT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUEST
				+ " TEXT, " + KEY_ANSWERT+ " TEXT, "+KEY_OPTAT +" TEXT, "
				+KEY_OPTBT +" TEXT, "+KEY_OPTCT+" TEXT)";
		String sqlc = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTC + " ( "
				+ KEY_IDC+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESC
				+ " TEXT, " + KEY_ANSWERC+ " TEXT, "+KEY_OPTAC +" TEXT, "
				+KEY_OPTBC +" TEXT, "+KEY_OPTCC+" TEXT)";
		String sqls = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTSS + " ( "
				+ KEY_IDS + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESS
				+ " TEXT, " + KEY_ANSWERSS+ " TEXT, "+KEY_OPTAS +" TEXT, "
				+KEY_OPTBS +" TEXT, "+KEY_OPTCS+" TEXT)";

		db.execSQL(sql);
		db.execSQL(sqld);
		db.execSQL(sqlt);
		db.execSQL(sqlc);
		db.execSQL(sqls);
		//Rellenar Base de datos
		addQuestions();
		addQuestionsDos();
		addQuestionsTres();
		addQuestionsCuatro();
		addQuestionsSinco();
		//db.close();
	}

	private void addQuestions()
	{
		Question q1=new Question("¿Que son los patrones de diseño?","Reutilizacion de codigo", "Es una forma de trabajar", "Forma de redactar un trabajo", "Reutilizaciòn de codigo");
		this.addQuestion(q1);
		Question q2=new Question("¿En que situacion de puede aplicar los patrones de diseño?", "Cuando hay inestabilidad en los diseños", "Trabajos identicos a otros", "Desarroladores inexpertos", "Cuando hay inestabilidad en los diseños");
		this.addQuestion(q2);
		Question q3=new Question("¿Cual es el problema concreto de diseño que se resuelve?","MVC", "Builder","Ninguno  de los anteriores", "MVC" );
		this.addQuestion(q3);
		Question q4=new Question("¿Quien dijo: que los patrones de diseño on problemas que ocurren una infinidad de veces?", "Alan sturlling", "Christopher Alexander", "Jacob Fray","Christopher Alexander");
		this.addQuestion(q4);
		Question q5=new Question("¿Para que se utiliza la MVC?","Crear interfaces de usuario en el Smaltalk","Reutilizar codigo","Mostrar una interfaz mas clara","Crear interfaces de usuario en el Smaltalk");
		this.addQuestion(q5);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getPREGUNTA());
		values.put(KEY_ANSWER, quest.getRESPUESTA());
		values.put(KEY_OPTA, quest.getOpcionA());
		values.put(KEY_OPTB, quest.getOpcionB());
		values.put(KEY_OPTC, quest.getOpcionC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setPREGUNTA(cursor.getString(1));
				quest.setRESPUESTA(cursor.getString(2));
				quest.setOpcionA(cursor.getString(3));
				quest.setOpcionB(cursor.getString(4));
				quest.setOpcionC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}

	//Tabla dos
	private static final String TABLE_QUESTD = "questdos";
	// tasks Table Columns names
	private static final String KEY_IDD = "id";
	private static final String KEY_QUESD = "question";
	private static final String KEY_ANSWERD = "answer"; //correct option
	private static final String KEY_OPTAD= "opta"; //option a
	private static final String KEY_OPTBD= "optb"; //option b
	private static final String KEY_OPTCD= "optc"; //option c

	private void addQuestionsDos()
	{
		Question d1=new Question("¿Que es un problema de diseño?","Errores comunes en la creación de un diseño", "Problemas en las funcionalidades", "Uso inadecuado de codigo", "Errores comunes en la creación de un diseño");
		this.addQuestiondos(d1);
		Question d2=new Question("¿Cuantos problemas son los mas comunes?", "3", "9", "7", "7");
		this.addQuestiondos(d2);
		Question d3=new Question("¿Que es un documento?","Diccionario de graficos base por parte de la computadora", "Libro que muestra cada paso que realizo el desarrollador","Disposicion de elementos graficos", "Disposicion de elementos graficos" );
		this.addQuestiondos(d3);
		Question d4=new Question("¿Cúal es la manera de representar jerarquicamente información estructurada?", "Documento", "Composición recursiva", "Ninguna de las anteriores","Composición recursiva");
		this.addQuestiondos(d4);
		Question d5=new Question("Responsabilidades de los glifos","Saber cómo dibujarse a sí mismos ,qué espacio ocupan y cuáles son sus hijos y su padre","Saber que forman tienen, donde estan, y mostrar su jerarquia","Manupilar los datos, demostrarlos y buscar toda la información","Saber cómo dibujarse a sí mismos ,qué espacio ocupan y cuáles son sus hijos y su padre");
		this.addQuestiondos(d5);
	}

	// Adding new question
	public void addQuestiondos(Question questtio) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUESD, questtio.getPREGUNTA());
		values.put(KEY_ANSWERD, questtio.getRESPUESTA());
		values.put(KEY_OPTAD, questtio.getOpcionA());
		values.put(KEY_OPTBD, questtio.getOpcionB());
		values.put(KEY_OPTCD, questtio.getOpcionC());
		// Inserting Row
		dbase.insert(TABLE_QUESTD, null, values);
	}
	public List<Question> getAllQuestionsdos() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTD;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setPREGUNTA(cursor.getString(1));
				quest.setRESPUESTA(cursor.getString(2));
				quest.setOpcionA(cursor.getString(3));
				quest.setOpcionB(cursor.getString(4));
				quest.setOpcionC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}

//Tabla tres
private static final String TABLE_QUESTT = "questt";
	// tasks Table Columns names
	private static final String KEY_IDT = "id";
	private static final String KEY_QUEST = "question";
	private static final String KEY_ANSWERT = "answer"; //correct option
	private static final String KEY_OPTAT= "opta"; //option a
	private static final String KEY_OPTBT= "optb"; //option b
	private static final String KEY_OPTCT= "optc"; //option c
	private void addQuestionsTres()
	{
		Question q1=new Question("¿Que són patrones de diseño  de creación?","Recopilación de lineas de código", "Abstración de proceso de instancias", "Clasificación de código", "Abstración de proceso de instancias");
		this.addQuestionT(q1);
		Question q2=new Question("¿Próposito de la fábrica abstracta?", "Proporciona una interfaz para crear familias de objetos relacionados", "La interfaz de usuario, como las barras de desplazamiento, ventanas y botones", "Una clase abstracta", "Proporciona una interfaz para crear familias de objetos relacionados");
		this.addQuestionT(q2);
		Question q3=new Question("¿Próposito del builder?","Separa la construcción de un objeto complejo de su representación", "La clase de cada tipo","Las subclases de ConvertidorDeTextoestán especializadas en diferentes conversiones", "Separa la construcción de un objeto complejo de su representación" );
		this.addQuestionT(q3);
		Question q4=new Question("¿Prósito del factory method?", "Los frameworks", "Define una interfaz para crear un objeto", "Ofrece una solución al dilema","Define una interfaz para crear un objeto");
		this.addQuestionT(q4);
		Question q5=new Question("¿Usos conocidos?","Los toolkits y frameworks","Las usuarios","La aplicación","Los toolkits y frameworks");
		this.addQuestionT(q5);
	}

	// Adding new question
	public void addQuestionT(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUEST, quest.getPREGUNTA());
		values.put(KEY_ANSWERT, quest.getRESPUESTA());
		values.put(KEY_OPTAT, quest.getOpcionA());
		values.put(KEY_OPTBT, quest.getOpcionB());
		values.put(KEY_OPTCT, quest.getOpcionC());
		// Inserting Row
		dbase.insert(TABLE_QUESTT, null, values);
	}
	public List<Question> getAllQuestionsTres() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTT;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setPREGUNTA(cursor.getString(1));
				quest.setRESPUESTA(cursor.getString(2));
				quest.setOpcionA(cursor.getString(3));
				quest.setOpcionB(cursor.getString(4));
				quest.setOpcionC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}

//Creacion de tabla 4
	private static final String TABLE_QUESTC = "questc";
	// tasks Table Columns names
	private static final String KEY_IDC = "id";
	private static final String KEY_QUESC = "question";
	private static final String KEY_ANSWERC = "answer"; //correct option
	private static final String KEY_OPTAC= "opta"; //option a
	private static final String KEY_OPTBC= "optb"; //option b
	private static final String KEY_OPTCC= "optc"; //option c


	private void addQuestionsCuatro() {
		Question q1 = new Question("¿Que son los patrones estructurales?", "Preparacion de clases", "Combinan clases y objetos", "Juntas bibliotecas", "Combinan clases y objetos");
		this.addQuestionC(q1);
		Question q2 = new Question("¿Comó son llamadas los adapter?", "Wrapper", "Box", "Rectangle", "Wrapper");
		this.addQuestionC(q2);
		Question q3 = new Question("¿Proposito del Bridge?", "Desacoplaciónn de abstracción", "Acoplacion de programa", "Variacion", "Desacoplaciónn de abstracción");
		this.addQuestionC(q3);
		Question q4 = new Question("¿Qué es el composite?", "Compone objetos en estructuras", "Muestra jerarquias", "Permite a los clientes una uniformidad", "Compone objetos en estructuras");
		this.addQuestionC(q4);
		Question q5 = new Question("Funcion del decorator", "Reutilización de codigó", "Asignacion de responsabilidades", "Proporción de alternativas", "Asignacion de responsabilidades");
		this.addQuestionC(q5);
	}
	// Adding new question
	public void addQuestionC(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUESC, quest.getPREGUNTA());
		values.put(KEY_ANSWERC, quest.getRESPUESTA());
		values.put(KEY_OPTAC, quest.getOpcionA());
		values.put(KEY_OPTBC, quest.getOpcionB());
		values.put(KEY_OPTCC, quest.getOpcionC());
		// Inserting Row
		dbase.insert(TABLE_QUESTC, null, values);
	}
	public List<Question> getAllQuestionsC() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTC;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setPREGUNTA(cursor.getString(1));
				quest.setRESPUESTA(cursor.getString(2));
				quest.setOpcionA(cursor.getString(3));
				quest.setOpcionB(cursor.getString(4));
				quest.setOpcionC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}

	//Tabla cinco

	private static final String TABLE_QUESTSS = "quests";
	// tasks Table Columns names
	private static final String KEY_IDS = "id";
	private static final String KEY_QUESS = "question";
	private static final String KEY_ANSWERSS = "answer"; //correct option
	private static final String KEY_OPTAS= "opta"; //option a
	private static final String KEY_OPTBS= "optb"; //option b
	private static final String KEY_OPTCS= "optc"; //option c
	private void addQuestionsSinco()
	{
		Question q1=new Question("¿Qué es la cadena de responsabilidad?","Evita acoplar el emisor de una petición", "Responder una aplicación", "Encadena cosas", "Evita acoplar el emisor de una petición");
		this.addQuestionS(q1);
		Question q2=new Question("¿Cúales son sus implementaciones?", "Definir enlaces, usar los enlaces existentes", "Definir las variables, Definir las clases", "Definir los grados, Definir la eficiencia", "Definir enlaces, usar los enlaces existentes");
		this.addQuestionS(q2);
		Question q3=new Question("Definicion del Command","Petición de encapusulacion de objetos", "Tratado de forma de los objetos","Trasnsfondo del uso de objetos", "Petición de encapusulacion de objetos" );
		this.addQuestionS(q3);
		Question q4=new Question("¿Qué es Interpreter?", "Representacion de la gramatica junto a un interprete", "Formación de diccionarios", "Trasnformación de clases a diccionarios","Representacion de la gramatica junto a un interprete");
		this.addQuestionS(q4);
		Question q5=new Question("¿Que es un Iterator?","Modo de acceder a los elementos de un objeto","Son repercusiones de cursos","Interpretacion grafica","Modo de acceder a los elementos de un objeto");
		this.addQuestionS(q5);
	}

	// Adding new question
	public void addQuestionS(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUESS, quest.getPREGUNTA());
		values.put(KEY_ANSWERSS, quest.getRESPUESTA());
		values.put(KEY_OPTAS, quest.getOpcionA());
		values.put(KEY_OPTBS, quest.getOpcionB());
		values.put(KEY_OPTCS, quest.getOpcionC());
		// Inserting Row
		dbase.insert(TABLE_QUESTSS, null, values);
	}
	public List<Question> getAllQuestionsS() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUESTSS;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setPREGUNTA(cursor.getString(1));
				quest.setRESPUESTA(cursor.getString(2));
				quest.setOpcionA(cursor.getString(3));
				quest.setOpcionB(cursor.getString(4));
				quest.setOpcionC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}


}
