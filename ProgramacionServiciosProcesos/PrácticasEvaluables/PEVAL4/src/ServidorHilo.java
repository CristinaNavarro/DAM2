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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServidorHilo extends JFrame implements Runnable, ActionListener {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private JTextArea textArea;
    private JTextField textField;
    private JButton button;
    private JButton buttonSalir;

    private Cronometro cronometro;


    ServidorHilo(Socket socket) {

        this.socket = socket;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Problemas en el hilo servidor al conectar canales de comunicación");
        }
        try {
            dos.writeUTF("Bienvenido, tienes 30 minutos (1 minuto) de conexión.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        textField = new JTextField(40);
        button = new JButton("Enviar");
        buttonSalir = new JButton("Cerrar la conexión");
        Box h = Box.createHorizontalBox();

        add(scroll, BorderLayout.CENTER);
        h.add(textField);
        h.add(button);
        h.add(buttonSalir);
        add(h, BorderLayout.SOUTH);

        setTitle("Conversación del Psicólogo con el cliente " + socket.getPort());
        setVisible(true);
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        button.addActionListener(this);
        buttonSalir.addActionListener(this);

        cronometro = new Cronometro(textArea);
        cronometro.start();

        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && !textField.getText().equals("") && !cronometro.finTiempo()) {
            try {
                dos.writeUTF("\n\tPsicólogo: " + textField.getText());
                guardarTexto("\n\tPsicólogo: " + textField.getText());
                System.out.println("Enviado al cliente "+socket.getPort()+": "+ textField.getText());
                textField.setText("");
            } catch (IOException error) {
                System.out.println("Error del servidor al enviar el mensaje");
            }
        }else if(e.getSource() == buttonSalir) {
            cerrarConexion();
            if(buttonSalir.getText().equals("SALIR")) {
                setVisible(false);
            }
            buttonSalir.setText("SALIR");
        }
    }

    @Override
    public void run() {
        String mensaje;

        while (!socket.isClosed()) {
            try {
                if (!cronometro.finTiempo()) {
                    mensaje = dis.readUTF();
                    guardarTexto(mensaje);
                    System.out.println("He recibido " + mensaje);
                }else{
                    cerrarConexion();
                }
            } catch (IOException e) {
                if (socket.isClosed()) {
                    System.out.println("Error del servidor al recibir el mensaje");
                }
                cronometro.finalizarCuenta();

            }
        }
        cerrarConexion();
    }

    //Cierra los canales y el socket
    private void cerrarConexion() {
        System.out.println("Cerrando la conexión del servidor");
        try {
            button.setEnabled(false);
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Guarda el texto en el textArea
    private void guardarTexto(String mensaje) {
        textArea.setText(textArea.getText() + mensaje);
    }


}
