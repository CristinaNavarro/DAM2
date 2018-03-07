package RSA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class GeneradorDeClaves {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException {
        String clavePublica = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveRSA_PUB.txt";
        String clavePrivada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveRSA_PRI.txt";

        SecureRandom random = new SecureRandom();
        //Creo el keyFactory que me va a permitir crear el par de claves
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512,random);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //Con el par de claves ya generado, tengo que obtener ambas claves, primero genero la factoría de claves
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        //Genero asi la clave publica
        RSAPublicKeySpec rsaPublicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(),RSAPublicKeySpec.class);

        //La guardo en un fichero
        FileOutputStream fosPublica = new FileOutputStream(clavePublica);
        PrintWriter pwPublica = new PrintWriter(fosPublica);
        pwPublica.println(rsaPublicKeySpec.getModulus());
        pwPublica.println(rsaPublicKeySpec.getPublicExponent());
        pwPublica.close();

        //Genero la clave privada
        RSAPrivateKeySpec rsaPrivateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(),RSAPrivateKeySpec.class);

        //Guardo la clave privada en un fichero
        FileOutputStream fosPrivada = new FileOutputStream(clavePrivada);
        PrintWriter pwPrivada = new PrintWriter(fosPrivada);
        pwPrivada.println(rsaPrivateKeySpec.getModulus());
        pwPrivada.println(rsaPrivateKeySpec.getPrivateExponent());
        pwPrivada.close();

    }
}
