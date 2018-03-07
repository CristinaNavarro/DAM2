package DES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CifradoDESSinGenerador {
    public static void main(String[] args) {
        String ficheroOriginal = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String ficheroCodificado = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_codificado_DES.txt";
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
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            File inf = new File(ficheroOriginal);
            FileInputStream is = new FileInputStream(inf);
            FileOutputStream os = new FileOutputStream(ficheroCodificado);
            byte[] buffer = new byte[8];
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
