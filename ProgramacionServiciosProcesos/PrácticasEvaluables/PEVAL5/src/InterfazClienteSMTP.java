/*
********Autor: Cristina Navarro
********Fecha: 15/12/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: PEVAL5:Implementar un sistema java que se comporte de la siguiente forma:
********El sistema deberá permitir al usuario elegir las acciones a realizar, siendo éstas:
********Transmisión de archivos a través de un servidor FTP
********Envío y recepción de correos electrónicos a través de servidores SMTP y POP3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazClienteSMTP extends JPanel implements ActionListener {

    private String[] arrayTexto = {"Correo del usuario", "Contraseña", "Destinatario", "Asunto", "Contenido", "Enviar", "Conectar"};
    private JButton btnEnviar = new JButton(arrayTexto[5]);
    private JButton btnConectar = new JButton(arrayTexto[6]);
    private JTextField tfUsuario = new JTextField(5);
    private JPasswordField tfContraseña = new JPasswordField(5);
    private JTextField tfDestino = new JTextField(5);
    private JTextField tfAsunto = new JTextField(5);
    private JTextArea taContenido = new JTextArea(10, 10);

    private ClienteSMTP clienteSMTP;

    InterfazClienteSMTP() {
        setLayout(new BorderLayout());

        tfDestino.setEnabled(false);
        tfAsunto.setEnabled(false);
        taContenido.setEnabled(false);

        Box hNorth = Box.createHorizontalBox();
        hNorth.add(new JLabel(arrayTexto[0]));
        hNorth.add(tfUsuario);
        hNorth.add(new JLabel(arrayTexto[1]));
        hNorth.add(tfContraseña);
        hNorth.add(btnConectar);
        hNorth.setBorder(BorderFactory.createLoweredBevelBorder());

        Box hCenterDestino = Box.createHorizontalBox();
        hCenterDestino.add(new JLabel(arrayTexto[2]));
        hCenterDestino.add(tfDestino);

        Box hCenterAsunto = Box.createHorizontalBox();
        hCenterAsunto.add(new JLabel(arrayTexto[3]));
        hCenterAsunto.add(tfAsunto);

        Box vCenter = Box.createVerticalBox();
        vCenter.add(hCenterDestino);
        vCenter.add(hCenterAsunto);
        vCenter.setBorder(BorderFactory.createLoweredBevelBorder());

        Box hSouth = Box.createHorizontalBox();
        hSouth.add(new JLabel(arrayTexto[4]));
        hSouth.add(taContenido);
        hSouth.add(btnEnviar);
        hSouth.setBorder(BorderFactory.createLoweredBevelBorder());

        add(hNorth, BorderLayout.NORTH);
        add(vCenter, BorderLayout.CENTER);
        add(hSouth, BorderLayout.SOUTH);

        btnEnviar.addActionListener(this);
        btnConectar.addActionListener(this);
    }


    /*
     *Permite conocer la contraseña escrita en un JPasswordField
     */
    String leerContraseña(JPasswordField jPasswordField) {
        String contraseña = "";
        for (char c : jPasswordField.getPassword()) {
            contraseña += c;
        }
        return contraseña;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnviar) {
            if (tfAsunto.getText().length() > 0 && tfDestino.getText().length() > 0 && taContenido.getText().length() > 0) {
                System.out.println("Se va a enviar...");
                System.out.println(tfDestino.getText() + tfAsunto.getText() + taContenido.getText());
                clienteSMTP.enviar(tfDestino.getText(), tfAsunto.getText(), taContenido.getText());
                System.out.println("Enviado");
                clienteSMTP.desconectar(); //desconecta y vuelve a conectar cada vez que envía para dar la sensación al usuario de que no se ha desconectado en ningún momento
                clienteSMTP.conectar();
                limpiarDatos();
                JOptionPane.showMessageDialog(null, "Mensaje enviado.");
            } else {
                JOptionPane.showMessageDialog(null,"Rellena todos los campos antes de enviar.");
            }
        } else if (e.getSource() == btnConectar) {
            switch (btnConectar.getText()) {
                case "Conectar":
                    conexion();
                    break;
                case "Desconectar":
                    desconexion();
                    break;
                default:
                    break;
            }
        }
    }

    void limpiarDatos() {
        tfDestino.setText("");
        tfAsunto.setText("");
        taContenido.setText("");
    }

    void conexion() {
        System.out.println("Conectando");
        clienteSMTP = new ClienteSMTP(tfUsuario.getText(), leerContraseña(tfContraseña));
        System.out.println(tfUsuario.getText() + " -- " + leerContraseña(tfContraseña));
        if (clienteSMTP.conectar()) {
            tfUsuario.setEnabled(false);
            tfContraseña.setEnabled(false);
            tfAsunto.setEnabled(true);
            tfDestino.setEnabled(true);
            taContenido.setEnabled(true);
            btnConectar.setText("Desconectar");
            JOptionPane.showMessageDialog(null,"Conexión correcta.");
        }
    }

    void desconexion() {
        clienteSMTP.desconectar();
        tfUsuario.setEnabled(true);
        tfContraseña.setEnabled(true);
        tfDestino.setEnabled(false);
        tfAsunto.setEnabled(false);
        taContenido.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Desconexión correcta.");
        btnConectar.setText("Conectar");
    }
}
