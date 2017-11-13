import java.io.Serializable;

public class Empleados implements Serializable {

    int codigo;
    String apellido;
    int sueldo;
    int departamento;

    Empleados() {

    }

    Empleados(int cod, String apellido, int sueldo, int departamento) {
        this.codigo = cod;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.departamento = departamento;
    }

    int getCodigo() {
        return this.codigo;
    }

    String getApellido() {
        return this.apellido;
    }

    int getSueldo() {
        return this.sueldo;
    }

    int getDepartamento() {
        return this.departamento;
    }

    void setCodigo(int cod) {
        this.codigo = cod;
    }

    void setApellido(String apellido) {
        this.apellido = apellido;
    }

    void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
}
