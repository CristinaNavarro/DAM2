/*
********Autor: Cristina Navarro
********Fecha: 15/12/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: PEVAL5:Implementar un sistema java que se comporte de la siguiente forma:
********El sistema deberá permitir al usuario elegir las acciones a realizar, siendo éstas:
********Transmisión de archivos a través de un servidor FTP
********Envío y recepción de correos electrónicos a través de servidores SMTP y POP3
*/

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class InterfazClienteFTP extends JPanel implements ActionListener {

    private JButton btnConexion;
    private JButton btnBuscarArchivo;
    private JButton btnSubirArchivo;
    private JButton btnDescargarArchivo;
    private JButton btnActualizarListado;
    private JButton btnEliminar;
    private JButton btnVolverRaiz;

    private JLabel lblIp = new JLabel("Dirección ip");
    private JTextField tfIp = new JTextField(10);

    private JTextField jtfArchivoSubida;
    private JList listaArchivos = new JList();
    private JScrollPane scroll = new JScrollPane(listaArchivos, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    private FTPClient ftpClient;
    private String servFTP;
    private String usuario;
    private String pass;
    private String raiz = "/FTPSERVERDIR/";

    private JFileChooser jFileChooser;

    InterfazClienteFTP() {
        setLayout(new BorderLayout());

        btnConexion = new JButton("Conectar");
        btnBuscarArchivo = new JButton("Browse...");
        btnSubirArchivo = new JButton("Subir");
        btnDescargarArchivo = new JButton("Descargar");
        btnActualizarListado = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnVolverRaiz = new JButton("Volver a inicio");

        btnConexion.addActionListener(this);
        btnBuscarArchivo.addActionListener(this);
        btnSubirArchivo.addActionListener(this);
        btnDescargarArchivo.addActionListener(this);
        btnActualizarListado.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnVolverRaiz.addActionListener(this);

        jtfArchivoSubida = new JTextField(2);

        jFileChooser = new JFileChooser();

        JLabel lblSubida = new JLabel("Subida de archivo");
        JLabel lblDescarga = new JLabel("Descarga de archivo");

        Box hConexion = Box.createHorizontalBox();
        Box hSubida = Box.createHorizontalBox();
        Box hDescarga = Box.createHorizontalBox();
        Box vSubida = Box.createVerticalBox();
        Box vBotones = Box.createVerticalBox();
        vSubida.setBorder(BorderFactory.createLoweredBevelBorder());
        Box vDescarga = Box.createVerticalBox();
        vDescarga.setBorder(BorderFactory.createLoweredBevelBorder());
        hConexion.add(btnConexion);
        hConexion.add(lblIp);
        hConexion.add(tfIp);

        hSubida.add(jtfArchivoSubida);
        hSubida.add(btnBuscarArchivo);
        hSubida.add(btnSubirArchivo);
        vSubida.add(lblSubida);
        vSubida.add(hSubida);

        hDescarga.add(scroll);
        vBotones.add(btnVolverRaiz);
        vBotones.add(btnDescargarArchivo);
        vBotones.add(btnEliminar);
        vBotones.add(btnActualizarListado);
        hDescarga.add(vBotones);
        vDescarga.add(lblDescarga);
        vDescarga.add(hDescarga);


        add(hConexion, BorderLayout.NORTH);
        add(vSubida, BorderLayout.CENTER);
        add(vDescarga, BorderLayout.SOUTH);

        listaArchivos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(listaArchivos.getSelectedValue().toString().charAt(0) == '/'){
                    try {
                        ftpClient.changeWorkingDirectory(listaArchivos.getSelectedValue().toString().substring(1));

                        actualizarListado(ftpClient.listFiles());
                    } catch (IOException error) {
                        // System.out.println(error.getMessage());
                    }
                }
            }
        });

        servFTP = "192.168.1.36"; //casa
        usuario = "pepe";
        pass = "pepethefrog";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConexion) {
            if (btnConexion.getText().equals("Conectar")) {
                try {
                    servFTP = tfIp.getText();
                    ftpClient = new FTPClient();
                    ftpClient.connect(servFTP);
                    tfIp.setEnabled(false);
                    boolean login = ftpClient.login(usuario, pass);
                    if (login) {
                        System.out.println("Login correcto.");
                        btnConexion.setText("Desconectar");
                        actualizarListado(ftpClient.listFiles());
                        ftpClient.setConnectTimeout(10); //tengo que controlar el tiempo de conexión del cliente
                    } else {
                        System.out.println("Login incorrecto.");
                        ftpClient.disconnect();
                    }
                } catch (IOException error) {
                  //  System.out.println(error);
                    btnConexion.setText("Conectar");
                }
            } else if (btnConexion.getText().equals("Desconectar")) {
                try {
                    ftpClient.disconnect();
                    tfIp.setEnabled(true);
                    listaArchivos.setModel(new DefaultListModel());
                    btnConexion.setText("Conectar");
                    System.out.println("Conexión finalizada.");
                } catch (IOException error) {
                  //  System.out.println(error);
                    btnConexion.setText("Conectar");
                }
            }
        } else if (e.getSource() == btnDescargarArchivo) {
            System.out.println(ftpClient.getConnectTimeout());
            String direccion = servFTP + raiz + listaArchivos.getSelectedValue().toString();
            try {
                ftpClient.changeWorkingDirectory(direccion);
                File file = new File("C:/Users/Cristi/Desktop/ " + listaArchivos.getSelectedValue().toString());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                if (ftpClient.retrieveFile(listaArchivos.getSelectedValue().toString(), bos)) {
                    System.out.println("Archivo descargado");
                } else {
                    System.out.println("No se permite descargar ese directorio u archivo.");
                }
                bos.close();
            } catch (IOException error) {
              //  System.out.println(error.getMessage());
            }
        } else if (e.getSource() == btnSubirArchivo) {
            String direccion = servFTP + raiz;
            try {
                ftpClient.changeWorkingDirectory(direccion);
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(jtfArchivoSubida.getText()));
                ftpClient.storeFile(hallarNombreArchivo(jtfArchivoSubida.getText()), bis);
                bis.close();
            } catch (IOException error) {
              //  System.out.println(error.getMessage());
            }
            jtfArchivoSubida.setText("");
            try {
                actualizarListado(ftpClient.listFiles());
            } catch (IOException error) {
              //  System.out.println(error.getMessage());
            }
        } else if (e.getSource() == btnBuscarArchivo) {
            jtfArchivoSubida.setText("");
            jFileChooser.setVisible(true);
            int seleccion = jFileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                String path = file.getPath();
                jtfArchivoSubida.setText(path);
            } else if (seleccion == JFileChooser.CANCEL_OPTION) {
                jFileChooser.setVisible(false);
            }
        } else if (e.getSource() == btnActualizarListado) {
            try {
                actualizarListado(ftpClient.listFiles());
            } catch (IOException error) {
              //  System.out.println(error.getMessage());
            }
        }else if (e.getSource() == btnEliminar) {
            File file = new File(raiz + listaArchivos.getSelectedValue().toString());
            if(!file.isDirectory()) {
                if (file.delete()) {
                    System.out.println("Eliminado");
                    JOptionPane.showMessageDialog(null, "Archivo eliminado");
                }else{
                    JOptionPane.showMessageDialog(null,"Fallo al eliminar el archivo.");
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se pueden eliminar directorios.");
            }

            try {
                actualizarListado(ftpClient.listFiles());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else if(e.getSource() == btnVolverRaiz) {
            try {
                ftpClient.changeWorkingDirectory("/..");
                actualizarListado(ftpClient.listFiles());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    private String hallarNombreArchivo(String path) {
        short posicion = 0;
        for (short i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/' || path.charAt(i) == '\\') {
                posicion = i;
            }
        }
        return path.substring(posicion);
    }

    private void actualizarListado(FTPFile[] arrayArchivos) {
        DefaultListModel modelo = new DefaultListModel();
        for (FTPFile archivo : arrayArchivos) {
            if(archivo.isDirectory()) {
                modelo.addElement("/" + archivo.getName());
            }else{
                modelo.addElement(archivo.getName());
            }
        }
        listaArchivos.setModel(modelo);
    }

}
