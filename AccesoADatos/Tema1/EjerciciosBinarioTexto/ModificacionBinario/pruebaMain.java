import java.io.*;
import java.util.Scanner;

public class pruebaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat");
        File modificado = new File("C:\\\\Users\\\\Cristi\\\\Desktop\\\\A\\\\Modificado.dat");
        boolean cambio = false;
        try{
            DataInputStream dIn = new DataInputStream(new FileInputStream(f));
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(modificado));
            DataInputStream dInMod = new DataInputStream(new FileInputStream(modificado));
            System.out.println("Introduce el numero del departamento a modificar: ");
            int n = sc.nextInt();
            int actual;
            while(true){
                actual=dIn.readInt();
                if(n!=actual) { //
                    dOut.writeInt(actual);
                    dOut.writeUTF(dIn.readUTF()); //
                    dOut.writeUTF(dIn.readUTF()); //
                    System.out.println("Linea escrita en el nuevo documento: " +dInMod.readInt() +dInMod.readUTF() +dInMod.readUTF());
                }else{
                    cambio=true;
                    System.out.println("Se sustituiran los siguientes datos( " +" " +dIn.readUTF() +", " +dIn.readUTF() +") del departamento " +actual);
                    dOut.writeInt(actual);
                    System.out.println("Nombre");
                    dOut.writeUTF(sc.next());
                    System.out.println("Lugar");
                    dOut.writeUTF(sc.next());
                    System.out.println("Linea escrita en el nuevo documento: " +dInMod.readInt() +dInMod.readUTF() +dInMod.readUTF());
                }
            }
        }catch (EOFException e){
            if(!cambio){
                System.out.println("No se han encontrado modificaciones");
            }else{
                System.out.println("Cambios efectuados");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
