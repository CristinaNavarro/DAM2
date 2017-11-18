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
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String host = "localhost";
        int puerto = 6000;
        String respuesta = "";
        DataOutputStream dos;
        DataInputStream dis;

        System.out.println("Cliente iniciado.");

        Socket socket = new Socket(host,puerto);
        dos = new DataOutputStream(socket.getOutputStream());
        while (!respuesta.equals("Has acertado")) {
            System.out.println("Introduce el número (1-10):");
            dos.writeInt(sc.nextInt());
            dis = new DataInputStream(socket.getInputStream());
            respuesta = dis.readUTF();
            System.out.println(respuesta);
        }
    }
}
