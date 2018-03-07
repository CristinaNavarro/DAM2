package HASH;

import java.security.MessageDigest;
import java.util.Scanner;

public class ComprobarHASHFicheros {
    public static void main(String[] args) throws Exception {
        String ficheroOriginal = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String ficheroConHash = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_hash.txt";
        System.out.println("Obteniendo instancia");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] c1 = ficheroOriginal.getBytes();
        byte[] c2 = ficheroConHash.getBytes();
        md.update(c1);
        md.update(c2); // concatenamos las dos cadenas
        System.out.println("calculando resumen");
        byte[] resumen = md.digest();
        System.out.println("Resumen (c1+c2): " + new String(resumen));
        md.reset(); // limpiamos la cadena
        md.update(c1);
        System.out.println("calculando resumen");
        resumen = md.digest();
        System.out.println("Resumen (c1): " + new String(resumen));
        md.reset(); // limpiamos la cadena
        md.update(c2);
        System.out.println("calculando resumen");
        resumen = md.digest();
        System.out.println("Resumen (c2): " + new String(resumen));
        md.reset(); // limpiamos la cadena
        System.out.println("Introduzca una cadena de texto");
        Scanner sc=new Scanner(System.in);
        md.update(sc.nextLine().getBytes());
        System.out.println("calculando resumen");
        resumen = md.digest();
        System.out.println("Resumen (cadena por teclado): " + new String(resumen));
        // Anotaci�n para el usuario
        System.out.println("PODEMOS COMPROBAR COMO SIEMPRE SALE EL MISMO RESULTADO TANTAS VECES LO EJECUTE");
    }
}
