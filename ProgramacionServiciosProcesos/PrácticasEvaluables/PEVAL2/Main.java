/*
********Autor: Cristina Navarro
********Fecha: 28/10/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: Programa sobre sincronización de hilos los
********cuales actuarán como coches que aparcan en un párking,
********en el que serán lavados y encerados, y tras esto,
********abandonarán el párking. El orden de lavado está
********impuesto por el orden en el que se ha aparcado.
********Si el párking está completo, no podrán entrar
********más coches.
*/

public class Main {

    private static final int intNUMEROCOCHES = 20; //Número de coches que intentarán entrar al párking

    public static void main(String[] args) {
        Parking parking = new Parking();
        for(int i = 0; i < intNUMEROCOCHES; i++){
            new Coche(parking,"Coche" + i);
        }
    }
}
