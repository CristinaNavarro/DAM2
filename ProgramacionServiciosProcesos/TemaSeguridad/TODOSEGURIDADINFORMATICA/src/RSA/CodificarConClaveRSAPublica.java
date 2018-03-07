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
import java.security.spec.RSAPublicKeySpec;

public class CodificarConClaveRSAPublica {
    public static void main(String[] args) throws Exception{
        String clavePublica = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveRSA_PUB.txt";
        String clave = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String ficheroClaveCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_RSA_PUB.txt";
        BufferedReader br = new BufferedReader(new FileReader(clavePublica));
        BigInteger modulus = new BigInteger(br.readLine());
        BigInteger exponente = new BigInteger(br.readLine());
        RSAPublicKeySpec keyspec = new RSAPublicKeySpec(modulus, exponente);
        KeyFactory keyfac = KeyFactory.getInstance("RSA");
        Key publicKey = keyfac.generatePublic(keyspec);
        System.out.println("Obteniendo objeto Cipher con cifrado RSA");
        Cipher desCipher = Cipher.getInstance("RSA");
        System.out.println("Configurando Cipher para encriptar");
        desCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        System.out.println("Abriendo el fichero");
        File inf = new File(clave);
        FileInputStream is = new FileInputStream(inf);
        System.out.println("Abriendo el fichero cifrado");
        FileOutputStream os = new FileOutputStream(ficheroClaveCodificado);
        System.out.println("Cifrando el fichero...");
        byte[] buffer = new byte[16];
        int bytes_leidos = is.read(buffer);
        while (bytes_leidos != -1) {
            byte[] cbuf = desCipher.doFinal(buffer, 0, bytes_leidos);
            os.write(cbuf);
            bytes_leidos = is.read(buffer);
        }
        os.close();
        System.out.println("Fichero cifrado.");
    }
}
