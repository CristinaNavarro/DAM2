package DES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Desencriptado {
    public static void main(String[] args) {
        String ficheroCifrado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_DES.txt";
        String ficheroDescifrado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_descodificado_DES.txt";
        String pathclave = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveDES.txt";
        try {
            File cinf = new File(pathclave);
            FileInputStream cis = new FileInputStream(cinf);
            byte[] clave = new byte[(int) cinf.length()];
            cis.read(clave);
            DESKeySpec keyspec = new DESKeySpec(clave);
            SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyfac.generateSecret(keyspec);
            Cipher desCipher = Cipher.getInstance("DES");
            desCipher.init(Cipher.DECRYPT_MODE, key);
            File inf = new File(ficheroCifrado);
            FileInputStream is = new FileInputStream(inf);
            FileOutputStream os = new FileOutputStream(ficheroDescifrado);
            byte[] buffer = new byte[16];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
