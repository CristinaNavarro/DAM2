import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Empleados e;
        File fOld = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.dat");
        File fNew = new File("C:\\Users\\Cristi\\Desktop\\A\\CopiaEmpleadosObjetos.dat");
        FileInputStream fInOld = new FileInputStream(fOld);
        FileOutputStream fOutNew = new FileOutputStream(fNew);
        ObjectInputStream objectIn = new ObjectInputStream(fInOld);
        ObjectOutputStream objectOut = new ObjectOutputStream(fOutNew);

        try {
            while (true) {
                e = (Empleados) objectIn.readObject();
                objectOut.writeObject(e);
            }
        } catch (ClassNotFoundException error) {
            System.out.println(error.getMessage());
        } catch (EOFException error) {
            fInOld.close();
            fOutNew.close();
        }
    }
}
