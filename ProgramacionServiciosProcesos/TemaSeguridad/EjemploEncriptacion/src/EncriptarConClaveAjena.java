import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EncriptarConClaveAjena {
    public static void main(String[] args) {
        try {
            File cinf = new File("C:\\Users\\\\Cristi\\pruebaEncriptacion\\pruebaJKeyDes.txt");
            FileInputStream cis = new FileInputStream(cinf);
            byte[] clave = new byte[(int) cinf.length()];
            cis.read(clave);
            DESKeySpec keyspec = new DESKeySpec(clave);
            SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyfac.generateSecret(keyspec);
            System.out.println("Obteniendo objeto Cipher con cifrado DES");
            Cipher desCipher = Cipher.getInstance("DES");
            System.out.println("Configurando Cipher para encriptar");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            System.out.println("Abriendo el fichero");
            File inf = new File("C:\\Users\\Cristi\\pruebaEncriptacion\\fichero_prueba_clave_ajena.txt");
            FileInputStream is = new FileInputStream(inf);
            System.out.println("Abriendo el fichero cifrado");
            FileOutputStream os = new FileOutputStream("C:\\Users\\Cristi\\pruebaEncriptacion\\fichero_cifrado_DES2_clave_ajena.txt");
            System.out.println("Cifrando el fichero...");
            byte[] buffer = new byte[8];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                bytes_leidos = is.read(buffer);
            }
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
