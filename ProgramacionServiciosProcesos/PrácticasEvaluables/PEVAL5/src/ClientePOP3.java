/*
********Autor: Cristina Navarro
********Fecha: 15/12/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: PEVAL5:Implementar un sistema java que se comporte de la siguiente forma:
********El sistema deberá permitir al usuario elegir las acciones a realizar, siendo éstas:
********Transmisión de archivos a través de un servidor FTP
********Envío y recepción de correos electrónicos a través de servidores SMTP y POP3
*/

import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;
import javax.swing.*;

import java.io.IOException;

import java.util.Date;
import java.util.Properties;


class ClientePOP3 {

    private Store store;
    private String usuario;
    private String pass;
    private Folder carpetaMensajes;

    ClientePOP3() {

    }


    /*
     * Establece el usuario y la contraseña del cliente.
     */
    void setUserPass(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }

    /*
     * Establece las propiedades e inicia la sesión
     */
    void conectar() throws Exception {
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        propiedades.setProperty("mail.pop3.socketFactory.fallback", "false");
        propiedades.setProperty("mail.pop3.port", "995");
        String host = "pop.gmail.com";
        URLName url = new URLName("pop3", host, 995, "", usuario, pass);
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("auth: " + usuario + " -- " + pass);
                return new PasswordAuthentication(usuario, pass);
            }
        };
        Session session = Session.getInstance(propiedades, authenticator);
        store = new POP3SSLStore(session, url);
        try {
            store.connect();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos");
        }
    }

    /*
     * Accede a la carpeta de mensajes para extraerlos
     */
    void openFolder(String nombreCarpeta) throws Exception {
        carpetaMensajes = store.getDefaultFolder();
        carpetaMensajes = carpetaMensajes.getFolder(nombreCarpeta);
        if (carpetaMensajes == null) {
            throw new Exception("Invalid carpetaMensajes");
        }
        try {
            carpetaMensajes.open(Folder.READ_WRITE);
        } catch (MessagingException e) {
            carpetaMensajes.open(Folder.READ_ONLY);
        }
    }

    /*
     * Devuelve el número de mensajes que contiene la carpeta
     */
    int getNumeroMensajes() throws Exception {
        return carpetaMensajes.getMessageCount();
    }

    /*
     * Desconecta la sesión
     */
    void desconectar() throws Exception {
        store.close();
    }

    /*
     * Recorre todos los mensajes y llama al método datosMensaje para cada uno de ellos
     */
    void imprimirMensajes(DefaultListModel modelo) throws Exception {
        Message[] msgs = carpetaMensajes.getMessages();
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);
        carpetaMensajes.fetch(msgs, fp);
        System.out.println("Cargando mensajes");
        for (int i = 0; i < msgs.length; i++) {
            datosMensaje(msgs[i], modelo);
        }
    }

    /*
     * Obtiene el contenido del mensaje que se ha seleccionado en el JList y lo muestra en una ventana
     */
    void imprimirContenidoMensaje(int posicion) {
        try {
            Message msg = carpetaMensajes.getMessage(posicion + 1);
            String contenido = getContenidoMensaje(msg);
            new VentanaMensaje(contenido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Obtiene el contenido del mensaje
     */
    private static String getContenidoMensaje(Part p) throws MessagingException, IOException {
        if (p.isMimeType("text/*")) {
            String s = (String) p.getContent();
            return String.valueOf(s);
        }

        if (p.isMimeType("multipart/alternative")) {
            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getContenidoMensaje(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getContenidoMensaje(bp);
                    if (s != null)
                        return s;
                } else {
                    return getContenidoMensaje(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getContenidoMensaje(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }

    /*
     * Obtiene los datos (asunto, origen y fecha) de un mensaje y los añade al modelo para incluirlo en el JList
     */
    private static void datosMensaje(Message m, DefaultListModel modelo) throws Exception {
        String cadena = "";
        Address[] a;
        // Origen
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++) {
                cadena = "\nFROM: " + a[j].toString();
            }
        }
        // Asunto
        cadena += "\nSUBJECT: " + m.getSubject();
        // Fecha
        Date d = m.getSentDate();
        cadena += "\nSendDate: " +
                (d != null ? d.toString() : "UNKNOWN");
        modelo.addElement(cadena);

    }
}
