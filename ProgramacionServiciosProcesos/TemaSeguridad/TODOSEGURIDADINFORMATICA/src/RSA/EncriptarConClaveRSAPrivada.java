package RSA;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;

public class EncriptarConClaveRSAPrivada {
    public static void main(String[] args) throws Exception {
        String clavePrivada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveRSA_PRI.txt";
        String ficheroOrginal = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String ficheroCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_RSA_PRI.txt";
        //Leo la clave
        BufferedReader br = new BufferedReader(new FileReader(clavePrivada));
        BigInteger modulus = new BigInteger(br.readLine());
        BigInteger exponente = new BigInteger(br.readLine());
        RSAPrivateKeySpec keyspec = new RSAPrivateKeySpec(modulus, exponente);
        KeyFactory keyfac = KeyFactory.getInstance("RSA");
        Key private_key = keyfac.generatePrivate(keyspec);
        System.out.println("Obteniendo objeto Cipher con cifrado RSA");
        Cipher desCipher = Cipher.getInstance("RSA");
        System.out.println("Configurando Cipher para encriptar");
        desCipher.init(Cipher.ENCRYPT_MODE, private_key);
        System.out.println("Abriendo el fichero");
        File inf = new File(ficheroOrginal);
        FileInputStream is = new FileInputStream(inf);
        System.out.println("Abriendo el fichero cifrado");
        FileOutputStream os = new FileOutputStream(ficheroCodificado);
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