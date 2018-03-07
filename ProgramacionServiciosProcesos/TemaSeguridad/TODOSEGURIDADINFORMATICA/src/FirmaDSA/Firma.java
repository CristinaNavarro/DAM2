package FirmaDSA; /**
 * Asignatura: Programación de Servicios y Procesos
 * Autor: Cristina Navarro
 * Práctica: Seguridad informática
 */

import java.io.*;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.DSAPrivateKeySpec;

public class Firma {
    public static void main(String[] args) {
        String firmaDigitalPrivada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveDSA_PRI.txt";
        String notaObtenida = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String notaFirmada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original_firmado.txt";
        try {
            System.out.println("Leyendo firma digital privada...");
            BufferedReader br = new BufferedReader(new FileReader(firmaDigitalPrivada));
            BigInteger X = new BigInteger(br.readLine());
            BigInteger P = new BigInteger(br.readLine());
            BigInteger Q = new BigInteger(br.readLine());
            BigInteger G = new BigInteger(br.readLine());
            System.out.println("Firma leída.");
            DSAPrivateKeySpec keyspec = new DSAPrivateKeySpec(X, P, Q, G);
            KeyFactory keyfac = KeyFactory.getInstance("DSA");
            PrivateKey private_key = keyfac.generatePrivate(keyspec);
            Signature signature = Signature.getInstance("DSA");
            System.out.println("Firmando fichero...");
            signature.initSign(private_key);
            System.out.println("Abriendo el fichero...");
            File inf = new File(notaObtenida);
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Escribiendo en el fichero...");
            byte[] buffer = new byte[64];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                signature.update(buffer, 0, bytes_leidos);
                bytes_leidos = is.read(buffer);
            }
            byte[] firma = signature.sign();
            System.out.println("Almacenando el fichero firmado...");
            FileOutputStream fosFlujo = new FileOutputStream(notaFirmada);
            fosFlujo.write(firma);
            fosFlujo.close();
            System.out.println("Fichero firmado y almacenado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
