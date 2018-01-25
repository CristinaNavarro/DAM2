import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DesencriptadoClaveAjena {
    public static void main(String[] args) {
        try {
            File cinf = new File("C:\\Users\\\\Cristi\\pruebaEncriptacion\\clave_DES2.txt");
            FileInputStream cis = new FileInputStream(cinf);
            byte[] clave = new byte[(int) cinf.length()];
            cis.read(clave);
            DESKeySpec keyspec = new DESKeySpec(clave);
            SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyfac.generateSecret(keyspec);
            Cipher desCipher = Cipher.getInstance("DES");
            desCipher.init(Cipher.DECRYPT_MODE, key);
            File inf = new File("C:\\Users\\Cristi\\pruebaEncriptacion\\pruebaCrisDes.txt");
            FileInputStream is = new FileInputStream(inf);
            FileOutputStream os = new FileOutputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\fichero_descifradoajenito_DES.txt");
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
