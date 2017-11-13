public class Persona {

    private String nombre;
    private String ciudad;

    Persona(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    Persona(){
        this.nombre = null;
        this.ciudad = null;
    }

    String getNombre(){
        return this.nombre;
    }

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    String getCiudad(){
        return this.ciudad;
    }

    void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }


}
