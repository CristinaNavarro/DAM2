/*
********Autor: Cristina Navarro
********Fecha: 18/11/2017
********Asignatura: Programación de Servicios y Procesos.
********Ejercicio: Cliente adivina número almacenado en el servidor con protocolo TCP
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServidorHilo extends Thread{
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    ServidorHilo(Socket socket) throws IOException {
        this.socket = socket;
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        boolean acierto = false;
        int numeroCorrecto = (int) (Math.random()*10 +1);
        try {
            while(!acierto) {
                int numero = dis.readInt();
                if (numeroCorrecto == numero) {
                    acierto = true;
                    dos.writeUTF("Has acertado");
                } else {
                    dos.writeUTF("No has acertado");
                }
            }
        } catch (IOException e) {

        }
    }
}
