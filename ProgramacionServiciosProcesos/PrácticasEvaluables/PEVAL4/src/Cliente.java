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

public class Cliente extends JFrame implements ActionListener {

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private JTextArea textArea;
    private JTextField textField;
    private JButton button;
    private JButton buttonSalir;

    private boolean cerrado;

    private Cronometro cronometro;

    //Genera una ventana que indica un error al conectar con el servidor
    private Cliente() {
        JLabel texto = new JLabel("El servidor no puede atender su petición en este momento.");
        add(texto);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Error al conectar con el servidor");
    }

    //Ventana del cliente
    private Cliente(Socket socket) {
        this.socket = socket;
        cerrado = false;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Problemas en el cliente al conectar canales de comunicación");
        }

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        textField = new JTextField(40);
        button = new JButton("Enviar");
        buttonSalir = new JButton("Salir");
        Box h = Box.createHorizontalBox();

        setTitle(String.valueOf(socket.getLocalPort()));

        add(scroll, BorderLayout.CENTER);
        h.add(textField);
        h.add(button);
        h.add(buttonSalir);
        add(h, BorderLayout.SOUTH);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setVisible(true);
        pack();

        cronometro = new Cronometro(textArea);
        cronometro.start();

        button.addActionListener(this);
        buttonSalir.addActionListener(this);
    }

    public static void main(String[] args) {
        int PUERTO = 4000;
        try {
            Socket socket = new Socket("localhost", PUERTO);
            Cliente cliente = new Cliente(socket);
            cliente.chatAbierto();
        } catch (IOException e) {
            new Cliente();
            System.out.println("El servidor no puede atender su petición en este momento.");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && !textField.getText().equals("") && !cronometro.finTiempo() && !cerrado) {
            try {
                dos.writeUTF("\n\tCliente " + String.valueOf(socket.getLocalPort()) + ": " + textField.getText());
                System.out.println("Enviado " + textField.getText());
                guardarTexto("\n\tCliente " + String.valueOf(socket.getLocalPort()) + ": " + textField.getText());
                guardarTexto(cronometro.anuncioTiempo());
                textField.setText("");
            } catch (IOException error) {
                System.out.println("Error del cliente al enviar el mensaje");
            }
        } else if (e.getSource() == buttonSalir) {
            cerrarConexion();
            System.exit(0);
        }
    }

    //Funcionamiento del chat desde que se inicia hasta que el cliente se marcha o finaliza el tiempo
    private void chatAbierto() {
        String mensaje;
        while (!socket.isClosed()) {
            try {
                mensaje = dis.readUTF();

                if (!cronometro.finTiempo() && !cerrado) {
                    guardarTexto(mensaje);
                    guardarTexto(cronometro.anuncioTiempo());
                }else{
                    cerrarConexion();
                }
            } catch (IOException e) {
                guardarTexto("\n\n\t-------Desconexión del servidor, pulse salir para finalizar-------\n\n");
                cerrarConexion();
            }
        }
        cerrarConexion();
    }

    //Cerrado de la conexión
    private void cerrarConexion() {
        System.out.println("Cerrando la conexión del cliente");
        try {
            cerrado = true;
            button.setEnabled(false);
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Añade el texto al textArea
    void guardarTexto(String mensaje) {
        if(!cerrado) textArea.setText(textArea.getText() + mensaje);
    }
}
