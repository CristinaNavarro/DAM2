/*
********Autor: Cristina Navarro
********Fecha: 18/11/2017
********Asignatura: Programación de Servicios y Procesos.
********Ejercicio: Calculo de IMC con protocolo TCP
*/


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(6000);
            System.out.println("Servidor iniciado");
            while (true) {
                Socket cliente = servidor.accept();
                ServidorHilo hilo = new ServidorHilo(cliente);
                hilo.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
