/*
********Autor: Cristina Navarro*********************
********Fecha: 24/09/2017***************************
********Asignatura:ProgramacionServiciosYProcesos***
********Ejercicio: Simular mediante cinco hilos,****
********  el sorteo de la lotería nacional en el****
********  cual, cada hilo sea un niño que saque un**
******** número entre 0 y 9 (ambos inclusive). Los**
********  números se corresponderán a las unidades,*
********  decenas, centenas, unidades de millar y **
******** decenas de millar del número. ¿Por qué no**
******** salen los números en orden? ¿Podrías ******
******** solucionarlo? *****************************
*/


public class Main {
    public static void main(String[] args) throws Exception {
        String[] nombres = {"Unidades", "Decenas", "Centenas", "Unidades de millar", "Decenas de millar"};

        for(String n:nombres){
            HiloThread h = new HiloThread(n);
            h.start();
            h.join();

        }
    }

}
