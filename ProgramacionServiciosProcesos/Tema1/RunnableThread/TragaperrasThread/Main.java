/*
********Autor: Cristina Navarro*********************
********Fecha: 24/09/2017***************************
********Asignatura:ProgramacionServiciosYProcesos***
********Ejercicio: Simular unas tragaperras con*****
********  cuatro ruedas, en el que cada hilo puede**
********  mostrar cuatro símbolos: plátanos,********
********  cerezas,  sandías y el dólar. ************
*/

public class Main {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            HiloThread h = new HiloThread();
            h.start();
        }
    }
}
