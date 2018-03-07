package FirmaDSA; /**
 * Asignatura: Programación de Servicios y Procesos
 * Autor: Cristina Navarro
 * Práctica: Seguridad informática
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.DSAPublicKeySpec;

public class ValidarFirma {
    public static void main(String[] args) {
        String firmaDigitalPublica = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\claveDSA_PUB.txt";
        String notaObtenida = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original.txt";
        String notaFirmada = "C:\\Users\\Cristi\\pruebaEncriptacion\\prueba\\fichero_original_firmado.txt";
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(firmaDigitalPublica));
            BigInteger Y = new BigInteger(br.readLine());
            BigInteger P = new BigInteger(br.readLine());
            BigInteger Q = new BigInteger(br.readLine());
            BigInteger G = new BigInteger(br.readLine());
            DSAPublicKeySpec keyspec = new DSAPublicKeySpec(Y, P, Q, G);
            KeyFactory keyfac = KeyFactory.getInstance("DSA");
            PublicKey public_key = keyfac.generatePublic(keyspec);
            Signature signature = Signature.getInstance("DSA");
            signature.initVerify(public_key);
            File inf = new File(notaObtenida);
            FileInputStream is = new FileInputStream(inf);
            byte[] buffer = new byte[64];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                signature.update(buffer, 0, bytes_leidos);
                bytes_leidos = is.read(buffer);
            }
            File insf = new File(notaFirmada);
            FileInputStream isf = new FileInputStream(insf);
            byte[] firma = new byte[(int) insf.length()];
            isf.read(firma);
            if (signature.verify(firma)) System.out.println("Firma válida");
            else System.out.println("Firma no válida.");
        } catch (Exception e) {
            System.out.println("Firma no válida.");
        }
    }
}
