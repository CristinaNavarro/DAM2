import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;

public class VentanaMensaje extends JFrame {
    VentanaMensaje(String mensaje) {
        JFXPanel jfxPanel = new JFXPanel();
        add(jfxPanel);
        setTitle("Contenido del mensaje");
        setSize(400,400);

        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));
            System.out.println(mensaje);
            webView.getEngine().loadContent(mensaje);
        });

        setVisible(true);
    }
}
