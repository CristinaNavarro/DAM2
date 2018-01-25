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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGeneral extends JFrame implements ActionListener {
    JTabbedPane tabs;
    InterfazGeneral() {
        setTitle("PEVAL5_CristinaNavarro");
        tabs = new JTabbedPane();
        tabs.add(new InterfazClienteFTP());
        tabs.setTitleAt(0,"Gestión de servidor (Cliente FTP)");
        tabs.add(new InterfazClienteSMTP());
        tabs.setTitleAt(1,"Enviar mensaje (Cliente SMTP)");
        tabs.add(new InterfazClientePOP3());
        tabs.setTitleAt(2,"Visualizar mensaje (Cliente POP3)");

        add(tabs);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tabs) {
            pack();
        }
    }
}
