package FirmaDSA;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class GeneradorClavesDSA {
    public static void main(String[] args) {
        String clavePub = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveDSA_PUB.txt";
        String clavePri = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveDSA_PRI.txt";
        try {
            SecureRandom random = new SecureRandom();
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
            keygen.initialize(512, random);
            System.out.println("Generando par de claves");
            KeyPair keypair = keygen.generateKeyPair();

            System.out.println("Obteniendo factoría de claves con cifrado DSA");
            KeyFactory keyfac = KeyFactory.getInstance("DSA");

            System.out.println("Generando keyspec público.");
            DSAPublicKeySpec publicKeySpec = keyfac.getKeySpec(keypair.getPublic(), DSAPublicKeySpec.class);
            System.out.println("Guardando la firma digital pública en un fichero...");
            FileOutputStream fosFlujoPub = new FileOutputStream(clavePub);
            PrintWriter pwPub = new PrintWriter(fosFlujoPub);
            pwPub.println(publicKeySpec.getY());
            pwPub.println(publicKeySpec.getP());
            pwPub.println(publicKeySpec.getQ());
            pwPub.println(publicKeySpec.getG());
            pwPub.close();
            System.out.println("Firma digital pública guardada.");

            System.out.println("Generando keyspec privado.");
            DSAPrivateKeySpec privateKeySpec = keyfac.getKeySpec(keypair.getPrivate(), DSAPrivateKeySpec.class);
            System.out.println("Guardando la firma digital privada en un fichero...");
            FileOutputStream fosFlujoPriv = new FileOutputStream(clavePri);
            PrintWriter pwPriv = new PrintWriter(fosFlujoPriv);
            pwPriv.println(privateKeySpec.getX());
            pwPriv.println(privateKeySpec.getP());
            pwPriv.println(privateKeySpec.getQ());
            pwPriv.println(privateKeySpec.getG());
            pwPriv.close();
            System.out.println("Firma digital privada guardada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
