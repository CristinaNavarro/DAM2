package RSA;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;

public class DesencriptarConClaveRSAPublica {
    public static void main(String[] args) {
        String clavePublica = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveRSA_PUB.txt";
        String ficheroClaveCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_RSA_PRI.txt";
        String ficheroDecodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_decodificado_RSA_PRI.txt";
        try {
            System.out.println("Leyendo clave pública.");
            BufferedReader br = new BufferedReader(new FileReader(clavePublica));
            BigInteger modulus = new BigInteger(br.readLine());
            BigInteger exponente = new BigInteger(br.readLine());
            RSAPublicKeySpec keyspec = new RSAPublicKeySpec(modulus, exponente);
            KeyFactory keyfac = KeyFactory.getInstance("RSA");
            Key public_key = keyfac.generatePublic(keyspec);
            Cipher desCipher = Cipher.getInstance("RSA");
            desCipher.init(Cipher.DECRYPT_MODE, public_key);
            System.out.println("Abriendo fichero cifrado...");
            File inf = new File(ficheroClaveCodificado);
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Creando fichero descifrado...");
            FileOutputStream os = new FileOutputStream(ficheroDecodificado);
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
