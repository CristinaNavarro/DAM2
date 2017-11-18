/*
********Autor: Cristina Navarro
********Fecha: 18/11/2017
********Asignatura: Programación de Servicios y Procesos.
********Ejercicio: Calculo de IMC con protocolo TCP
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //direccion del servidor y puerto de entrada
        String host = "localhost";
        int puerto = 6000;

        //inicio del cliente
        System.out.println("Cliente iniciado.");
        Socket socket = new Socket(host, puerto);

        //creación canal salida de datos
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        //envío de información al servidor
        System.out.println("Nombre: ");
        dos.writeUTF(sc.nextLine());
        System.out.println("Apellidos: ");
        dos.writeUTF(sc.nextLine());
        System.out.println("Edad: ");
        dos.writeInt(sc.nextInt());
        System.out.println("Peso: ");
        dos.writeDouble(sc.nextDouble());
        System.out.println("Altura: ");
        dos.writeDouble(sc.nextDouble());

        //canal de recepción de información
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //recepción de la informacion
        System.out.println("IMC: " + dis.readDouble());

        //cierre
        dis.close();
        dos.close();
        socket.close();

    }
}
