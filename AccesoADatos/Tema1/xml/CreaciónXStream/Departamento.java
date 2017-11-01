import java.io.Serializable;

public class Departamento implements Serializable {
    private int codigo;
    private String nombre;
    private String lugar;
    Departamento(){
    }
    Departamento(int c, String n, String l){
        this.codigo = c;
        this.nombre = n;
        this.lugar = l;
    }

    public void setCodigo(int c){
        this.codigo = c;
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public void setLugar(String l){
        this.lugar = l;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getLugar(){
        return this.lugar;
    }
}