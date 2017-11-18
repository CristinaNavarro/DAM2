/*
********Autor: Cristina Navarro
********Fecha: 18/11/2017
********Asignatura: Programación de Servicios y Procesos.
********Ejercicio: Calculo de IMC con protocolo TCP
*/
import java.io.*;
import java.net.Socket;

public class ServidorHilo extends Thread {
    //Creación de canales de comunicación
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;

    //Constructor
    ServidorHilo(Socket s) throws IOException {
        socket = s;
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
    }

    //Comienzo del hilo
    @Override
    public void run() {
        try {
            double peso;
            double estatura;
            // recibo desde el cliente
            System.out.println("Datos del cliente: \nNombre:" + dis.readUTF() + "Apellidos: " + dis.readUTF() + "\nEdad: " + dis.readInt());
            peso = dis.readDouble();
            estatura = dis.readDouble();
            System.out.println("Peso: " + peso + "\nEstatura: " + estatura);

            //envío a cliente
            dos.writeDouble(peso / Math.pow(estatura, 2));
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
