import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazClientePOP3 extends JPanel implements ActionListener {

    private static String[] arrayTexto = {"Usuario", "Contraseña", "Actualizar correos", "Conectar"};
    private JTextField tfUsuario = new JTextField(10);
    private JPasswordField pfContraseña = new JPasswordField(10);
    private static JButton btnActualizar = new JButton(arrayTexto[2]);
    private JButton btnConectar = new JButton(arrayTexto[3]);
    private JList listaMensajes = new JList();
    private JScrollPane scrollPane = new JScrollPane(listaMensajes, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


    private ClientePOP3 clientePOP3;
    private HiloActualizacion consHilo;

    InterfazClientePOP3() {
        setLayout(new BorderLayout());
        Box hNorth = Box.createHorizontalBox();
        hNorth.add(new JLabel(arrayTexto[0]));
        hNorth.add(tfUsuario);
        hNorth.add(new JLabel(arrayTexto[1]));
        hNorth.add(pfContraseña);
        hNorth.add(btnConectar);
        hNorth.add(btnActualizar);
        add(hNorth, BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        btnActualizar.addActionListener(this);
        btnConectar.addActionListener(this);
    }

    /*
     * Permite conocer la contraseña escrita en un JPasswordField
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
        if (e.getSource() == btnActualizar) {
            clientePOP3.setUserPass(tfUsuario.getText(), leerContraseña(pfContraseña));
            try {
                clientePOP3.desconectar();
                clientePOP3.conectar();
                clientePOP3.openFolder("INBOX");
                DefaultListModel modelo = new DefaultListModel();
                clientePOP3.imprimirMensajes(modelo);
                listaMensajes.setModel(modelo);
                listaMensajes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clientePOP3.imprimirContenidoMensaje(listaMensajes.getSelectedIndex());
                    }
                });
            } catch (Exception ex) {
                System.out.println("--" +ex.getMessage());
            }
        }else if(e.getSource() == btnConectar) {
            switch (btnConectar.getText()) {
                case "Conectar":
                    try {
                        if(tfUsuario.getText().length() > 0 && pfContraseña.getPassword().length > 0) {
                            clientePOP3 = new ClientePOP3();
                            clientePOP3.setUserPass(tfUsuario.getText(), leerContraseña(pfContraseña));
                            clientePOP3.conectar();
                            clientePOP3.openFolder("INBOX");
                            System.out.println("usuario: " + tfUsuario.getText() + "contraseña " + leerContraseña(pfContraseña));
                            System.out.println("Número de mensajes = " + clientePOP3.getNumeroMensajes());
                            btnConectar.setText("Desconectar");
                            tfUsuario.setEnabled(false);
                            pfContraseña.setEnabled(false);
                            JOptionPane.showMessageDialog(null,"Conexión correcta.");
                            consHilo = new HiloActualizacion();
                            consHilo.start();
                            btnActualizar.doClick();
                        }else{
                            System.out.println("Introduce los datos antes de conectar");
                            JOptionPane.showMessageDialog(null,"Introduce los datos antes de conectar");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Desconectar":
                    try {
                        clientePOP3.desconectar();
                        btnConectar.setText("Conectar");
                        listaMensajes.setModel(new DefaultListModel());
                        tfUsuario.setEnabled(true);
                        pfContraseña.setEnabled(true);
                        consHilo.cambiarModo();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            }
        }
    }


    /*
     * Permite al hilo actualizar la información del JList
     */
    static void pulsarBoton() {
        btnActualizar.doClick();
    }

}
