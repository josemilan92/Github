package mx.utng.edu.laeraningpatrones.atributos;
public class Question {
	private int ID;
	private String PREGUNTA;
	private String OpcionA;
	private String OpcionB;
	private String OpcionC;
	private String RESPUESTA;

	public Question()
	{
		ID=0;
		PREGUNTA="";
		OpcionA="";
		OpcionB="";
		OpcionC="";
		RESPUESTA="";
	}

	public Question(String qUESTION, String oPTA, String oPTB, String oPTC,
					String aNSWER) {

		PREGUNTA = qUESTION;
		OpcionA = oPTA;
		OpcionB = oPTB;
		OpcionC = oPTC;
		RESPUESTA = aNSWER;
	}

	public String getPREGUNTA() {
		return PREGUNTA;
	}

	public void setPREGUNTA(String PREGUNTA) {
		this.PREGUNTA = PREGUNTA;
	}

	public String getOpcionA() {
		return OpcionA;
	}

	public void setOpcionA(String opcionA) {
		OpcionA = opcionA;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getOpcionB() {
		return OpcionB;
	}

	public void setOpcionB(String opcionB) {
		OpcionB = opcionB;
	}

	public String getOpcionC() {
		return OpcionC;
	}

	public void setOpcionC(String opcionC) {
		OpcionC = opcionC;
	}

	public String getRESPUESTA() {
		return RESPUESTA;
	}

	public void setRESPUESTA(String RESPUESTA) {
		this.RESPUESTA = RESPUESTA;
	}

}
