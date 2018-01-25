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

public class Cronometro extends Thread {
    private int TIEMPOMAXIMO = 60;
    private int segundos;
    private JTextArea textArea;

    Cronometro(JTextArea textArea) {
        segundos = 0;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        while (segundos < TIEMPOMAXIMO) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            segundos++;
            textArea.setText(textArea.getText() + anuncioTiempo());
        }
        System.out.println("fin cronometro");
    }

    //Indica distintos mensajes según el tiempo restante
    String anuncioTiempo() {
        switch (TIEMPOMAXIMO - segundos) {
            case 30:
                return "\n\n\t-------Ha consumido la mitad de su tiempo.-------\n\n";
            case 10:
                return  "\n\n\t-------Le quedan 10 segundos.-------\n\n";
            case 0:
                return  "\n\n\t-------Fin de la conexión.-------\n\n";
            default:
                return "";
        }
    }

    //Indica la finalización del tiempo
     synchronized boolean finTiempo() {
        if (segundos < TIEMPOMAXIMO) {
            return false;
        } else {
            return true;
        }
    }

    //Finaliza instantáneamente el tiempo restante
    void finalizarCuenta() {
        segundos = TIEMPOMAXIMO;
    }
}
