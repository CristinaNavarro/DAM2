/*
********Autor: Cristina Navarro
********Fecha: 03/12/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: PEVAL 4: chat de un Psicólogo y 5 clientes
********como máximo. El servidor se mantendrá abierto siempre.
********Los psicólogos pueden elegir si liberar el socket o
********mantenerlo abierto, para que no puedan entrar otros clientes.
********Igualmente, pueden mantener la ventana abierta aunque el socjet
********esté cerrado. Un cliente puede ser conectado una vez que el
********socket quede libre, pero su conexión contará a partir del comienzo
********de su ejecución.
*/
import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        final int PUERTO = 4000;
        int conexiones = 0;
        final int MAXIMO = 5;
        ArrayList<Socket> listadoSocket = new ArrayList<>();
        serverSocket = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado");
        while (true) {
            try {
                if (listadoSocket.size() < MAXIMO) {
                    Socket socket = serverSocket.accept();
                    listadoSocket.add(socket);
                    System.out.println("Nuevo cliente");
                    new ServidorHilo(socket);
                }
                for (int i = 0; i < listadoSocket.size(); i++) {
                    if (listadoSocket.get(i).isClosed()) {
                        listadoSocket.remove(i);
                        System.out.println("conexiones actuales: " + conexiones);
                    }
                }
            } catch (ConnectException e) {
                System.out.println("No quedan sockets libres");
            }
        }
    }
}
