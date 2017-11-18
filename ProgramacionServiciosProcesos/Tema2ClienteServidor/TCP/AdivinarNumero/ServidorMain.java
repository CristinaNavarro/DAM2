/*
********Autor: Cristina Navarro
********Fecha: 18/11/2017
********Asignatura: Programación de Servicios y Procesos.
********Ejercicio: Cliente adivina número almacenado en el servidor con protocolo TCP
*/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            while (true) {
                Socket socket = serverSocket.accept();
                ServidorHilo servidorHilo = new ServidorHilo(socket);
                servidorHilo.start();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
