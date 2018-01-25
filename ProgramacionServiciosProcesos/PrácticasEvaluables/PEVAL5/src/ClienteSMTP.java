/*
********Autor: Cristina Navarro
********Fecha: 15/12/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: PEVAL5:Implementar un sistema java que se comporte de la siguiente forma:
********El sistema deberá permitir al usuario elegir las acciones a realizar, siendo éstas:
********Transmisión de archivos a través de un servidor FTP
********Envío y recepción de correos electrónicos a través de servidores SMTP y POP3
*/

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.swing.*;
import java.io.IOException;
import java.io.Writer;

public class ClienteSMTP {

    private AuthenticatingSMTPClient clientSMTP = new AuthenticatingSMTPClient();

    private String servidorSMTP;
    private String usuario;
    private String pass;
    /*
     *Información que funciona:
    String usuario = "dejamehacermiprogramadejava@gmail.com";
    String pass = "1234Vaga";
    String destino = "cris.ns.dev@gmail.com";
    String asunto = "prueba";
    String mensaje = "hola";*/
    int puerto = 25;

    ClienteSMTP(String usuario, String pass) {
        this.servidorSMTP = "smtp.gmail.com"; //para modificar en un futuro los posibles servidores de correo
        this.usuario = usuario;
        this.pass = pass;
    }

    /*
     * Conecta el cliente SMTP
     */
    boolean conectar() {
        try {
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];
            clientSMTP.connect(servidorSMTP, puerto);
            System.out.println("1 - " + clientSMTP.getReplyString());
            clientSMTP.setKeyManager(km);
            if (comprobarCoincidencia()) {
                clientSMTP.connect(servidorSMTP, puerto);
                System.out.println("1 - " + clientSMTP.getReplyString());
                clientSMTP.setKeyManager(km);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /*
     * Envía el mensaje
     */
    void enviar(String destino, String asunto, String mensaje) {
        try {
            clientSMTP.ehlo(servidorSMTP);
            System.out.println("2 - " + clientSMTP.getReplyString());
            if (clientSMTP.execTLS()) {
                System.out.println("3 - " + clientSMTP.getReplyString());
                if (clientSMTP.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, usuario, pass)) {
                    System.out.println("4 - " + clientSMTP.getReplyString());
                    SimpleSMTPHeader header = new SimpleSMTPHeader(usuario, destino, asunto);
                    clientSMTP.setSender(usuario);
                    clientSMTP.addRecipient(destino);
                    System.out.println("5 - " + clientSMTP.getReplyString());
                    Writer writer = clientSMTP.sendMessageData();
                    if (writer == null) {
                        System.out.println("Fallo al enviar data");
                    }
                    writer.write(header.toString());
                    writer.write(mensaje);
                    writer.close();
                    System.out.println("6 - " + clientSMTP.getReplyString());

                    boolean exito = clientSMTP.completePendingCommand();
                    System.out.println("7 - " + clientSMTP.getReplyString());
                    if (!exito) {
                        System.out.println("Fallo al finalizar transacción");
                    }
                } else {
                    System.out.println("Usuario no autentificado");
                }
            } else {
                System.out.println("Fallo al ejecutar tls");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fin del envío");
    }

    /*
     * Desconecta el cliente SMTP
     */
    void desconectar() {
        try {
            clientSMTP.disconnect();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Desconectado");
    }


    /*
     * Verifica las credenciales introducidas
     */
    private boolean comprobarCoincidencia() {
        try {
            clientSMTP.ehlo(servidorSMTP);
            System.out.println(usuario + " --- --- --- " + pass);
            if (clientSMTP.execTLS()) {
                if (clientSMTP.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, usuario, pass)) {
                    clientSMTP.disconnect();

                    return true;
                }
            }
        }catch (Exception e) {
        }
        return false;
    }
}
