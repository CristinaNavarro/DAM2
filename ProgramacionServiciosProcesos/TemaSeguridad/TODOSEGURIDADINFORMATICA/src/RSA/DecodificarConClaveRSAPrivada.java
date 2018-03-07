package RSA; /**
 * Asignatura: Programación de Servicios y Procesos
 * Autor: Cristina Navarro
 * Práctica: Seguridad informática
 */

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;

public class DecodificarConClaveRSAPrivada {
    public static void main(String[] args) {
        String clavePrivada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveRSA_PRI.txt";
        String ficheroClaveCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_RSA_PUB.txt";
        String claveDecodificada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_decodificado_RSA_PUB.txt";
        try {
            System.out.println("Leo clave privada");
            BufferedReader br = new BufferedReader(new FileReader(clavePrivada)); //nombre valido?
            BigInteger modulus = new BigInteger(br.readLine());
            BigInteger exponente = new BigInteger(br.readLine());
            RSAPrivateKeySpec keyspec = new RSAPrivateKeySpec(modulus, exponente);
            KeyFactory keyfac = KeyFactory.getInstance("RSA");
            Key privateKey = keyfac.generatePrivate(keyspec);
            Cipher desCipher = Cipher.getInstance("RSA");
            desCipher.init(Cipher.DECRYPT_MODE, privateKey);
            System.out.println("Abro la clave cifrada de ");
            File inf = new File(ficheroClaveCodificado);
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Creo el fichero con la clave decodificada");
            FileOutputStream os = new FileOutputStream(claveDecodificada); //nombre valido?
            byte[] buffer = new byte[64];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
            System.out.println("Fichero descifrado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
