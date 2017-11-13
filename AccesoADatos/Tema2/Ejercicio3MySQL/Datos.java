import java.util.ArrayList;

class Datos {
    String[] listaDatosCliente1 = {"1","Cris","direccion","poblacion","123456789","12345678z"};
    String[] listaDatosCliente2 = {"2","Cris","direccion","poblacion","123456789","12345678z"};
    String[] listaDatosProducto1 = {"1", "descripcion","1", "10", "12"};
    String[] listaDatosProducto2 = {"2", "descripcion","1", "10", "12"};
    String[] listaDatosProducto3 = {"3", "descripcion","1", "10", "12"};
    ArrayList<String[]> listaDatos = new ArrayList<>();
    void crearDatos() {
        listaDatos.add(listaDatosCliente1);
        listaDatos.add(listaDatosCliente2);
        listaDatos.add(listaDatosProducto1);
        listaDatos.add(listaDatosProducto2);
        listaDatos.add(listaDatosProducto3);
    }

    ArrayList<String[]> getListaDatos() {
        return listaDatos;
    }
}
