import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        System.out.println("Introduce el código del empleado al que subir el sueldo");
        int registro = sc.nextInt();
        System.out.println("Introduce el aumento");
        int aumento = sc.nextInt();
        int posicion = (registro - 1) * 32;
        if (posicion > raf.length()) {
            System.out.println("Ese departamento no existe");
        } else {
            raf.seek(posicion + 24);
            aumento += raf.readInt();
            raf.seek(posicion + 24);
            raf.writeInt(aumento);
            raf.close();
        }
    }
}
