import java.io.*;

/*
********Autor: Cristina Navarro*********************
********Fecha: 02/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Lector de informacion de un*****
********  .dat con objetos**************************
*/
public class Main {
    public static void main(String[] args) throws IOException {
        Departamento d;
        FileInputStream fIn = new FileInputStream("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.dat");
        ObjectInputStream objectIn = new ObjectInputStream(fIn);
        try {
            while (true) {
                d = (Departamento) objectIn.readObject();
                System.out.println("Codigo: " + d.getCodigo() + " Nombre: " + d.getNombre() + " Lugar: " + d.getLugar());
            }
        }catch (EOFException e){
            objectIn.close();
            fIn.close();
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (OptionalDataException e){
            System.out.println(e.getMessage());
        }
    }
}
