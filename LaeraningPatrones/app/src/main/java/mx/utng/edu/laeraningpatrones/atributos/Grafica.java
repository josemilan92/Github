package mx.utng.edu.laeraningpatrones.atributos;

/**
 * Created by a on 30/03/2016.
 */
public class Grafica {
    private int id;
    private String sigla;
    private String nombre;
    private int votos;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVotos() {
        return votos;
    }
    public void setVotos(int votos) {
        this.votos = votos;
    }
}
