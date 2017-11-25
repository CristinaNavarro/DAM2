/*
********Autor: Cristina Navarro
********Fecha: 08/11/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio: PEVAL3: Existen 4 tipos de combatiente (podrá elegir el usuario qué tipo/s de
* combatientes pueden pelear, pudiendo existir dos guerreros por ejemplo en el mismo campo
* de batalla) (los distintos combatientes serán hilos): guerrero (más vida, más defensa, menos ataque),
* chamán (vida normal, se cura, ataque normal), cazador (menos vida, defensa normal, mucho ataque) y
* sacerdote (vida alta, se cura, menos ataque). Se enfrentarán entre 2 y 4 de ellos (elegido por el usuario),
* requiriendo un tiempo de ataque (Thread.sleep).
* En primer lugar, los combatientes intentarán entrar al campo de batalla, pero solo entrarán los que lleguen
* hasta completar el aforo, el resto se irán (finalizarán los hilos). Se le dará un identificador a cada
* combatiente que entre al campo de batalla, que permitirá que sean seleccionados por los atacantes. Los
* combatientes accederán a la “taquilla” del campo de batalla en orden, haciendo cola (sincronización).
* Los combatientes se “pelearán” por tomar el turno, pudiendo tomarlo solo uno y durmiendo el resto
* (sincronización, bloqueos de los hilos), se tendrá en cuenta que el último que ha atacado no puede volver a
* atacar en el siguiente turno. Al entrar al método atacar, elegirá el objetivo de su ataque, restándole vida
* a este (comunicación de datos). El último que quede con vida, o con más vida si la energía se agota, ganará.
* Las clases que posean curación, si su vida no está al máximo, se curarán al atacar. Las clases que poseen
* resistencia, recibirán menos daño al ser atacadas. Todos necesitarán absorber energía del planeta para poder
* atacar. Solo uno podrá acceder a esta energía (sincronización de objetos), en el momento en el que atacan
* (resta energía) o se curan (suma energía). La energía se recupera al finalizar el turno de ataque, por lo que
* un combatiente no puede recuperar energía para atacar después. Si la energía es 0 al finalizar un turno, nadie
* podrá atacar y el combate se dará por finalizado.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final int intMINIMOJUGADORES = 2; //mínima cantidad de jugadores en el campo de batalla
    private static final int intMAXIMOJUGADORES = 4; //máxima cantidad de jugadores en el campo de batalla
    private static final int intMINIMOCOMBATIENTES = 1; //mínima cantidad de clases en el campo de batalla
    private static final int intNUMEROCOMBATIENTESPAQUETES = 4; //número de "paquetes" (cada paquete incluye un combatiente de cada tipo)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listaClasesPermitidas = new ArrayList<>();
        DatosCombatientes datosCombatientes = new DatosCombatientes();
        String strCombatiente;
        String strAforo;
        int intAforo = -1;
        String patron = "[2-4]";

        //Establecer aforo del campo de batalla
        do {
            System.out.println("Elige el número de combatientes de esta batalla.");
            strAforo = sc.next();
            if (Pattern.matches(patron, strAforo)) {
                intAforo = Integer.parseInt(strAforo);
            } else {
                System.out.println("ERROR: Introduce un número entre 2 y 4");
            }
        } while (intAforo > intMAXIMOJUGADORES || intAforo < intMINIMOJUGADORES);

        //Introducir tipos de combatientes que podrán participar en la batalla
        System.out.println("Elige la/s clases que podrán combatir (máximo 4, mínimo 1), introduce 0 para finalizar.\nLas clases a elegir son:");
        for (int i = 0; i < datosCombatientes.getListadoTipos().length; i++) {
            System.out.println("\n" + datosCombatientes.getListadoTipos()[i]);
            for (int j = 0; j < datosCombatientes.getListadoEstadisticas().length; j++) {
                switch (datosCombatientes.getListadoTipos()[i]) {
                    case "Guerrero":
                        System.out.println("\n\t" + datosCombatientes.getListadoEstadisticas()[j] + " " + datosCombatientes.getDatosGuerrero()[j]);
                        break;
                    case "Chaman":
                        System.out.println("\n\t" + datosCombatientes.getListadoEstadisticas()[j] + " " + datosCombatientes.getDatosChaman()[j]);
                        break;
                    case "Cazador":
                        System.out.println("\n\t" + datosCombatientes.getListadoEstadisticas()[j] + " " + datosCombatientes.getDatosCazador()[j]);
                        break;
                    default:
                        System.out.println("\n\t" + datosCombatientes.getListadoEstadisticas()[j] + " " + datosCombatientes.getDatosSacerdote()[j]);
                        break;
                }
            }
        }
        do {
            boolean boValido = false;
            System.out.println("Listado actual de clases que podrán combatir:" + listaClasesPermitidas);
            System.out.print("->");
            strCombatiente = sc.next();
            for (int i = 0; i < datosCombatientes.getListadoTipos().length; i++) {
                if (strCombatiente.equalsIgnoreCase(datosCombatientes.getListadoTipos()[i])) {
                    boValido = true;
                    strCombatiente = strCombatiente.substring(0, 1).toUpperCase() + strCombatiente.substring(1);
                }
            }
            if (!listaClasesPermitidas.contains(strCombatiente) && !strCombatiente.equals("0") && boValido) {
                listaClasesPermitidas.add(strCombatiente);
            } else if (listaClasesPermitidas.contains(strCombatiente)) {
                System.out.println("ERROR: No se permite introducir dos veces la misma clase");
            } else if (!strCombatiente.equals("0")) {
                System.out.println("ERROR: Solo se puede introducir el nombre de las clases existentes.");
            }
        }
        while (listaClasesPermitidas.size() < intMAXIMOJUGADORES && !strCombatiente.equals("0") || listaClasesPermitidas.size() < intMINIMOCOMBATIENTES);

        //Creación de objetos
        CampoBatalla campoBatalla = new CampoBatalla(intAforo, listaClasesPermitidas);
        Energia energia = new Energia();
        for (int i = 0; i < intNUMEROCOMBATIENTESPAQUETES; i++) {
            new Combatiente("Guerrero", campoBatalla, energia, datosCombatientes.getDatosGuerrero());
            new Combatiente("Chaman", campoBatalla, energia, datosCombatientes.getDatosChaman());
            new Combatiente("Cazador", campoBatalla, energia, datosCombatientes.getDatosCazador());
            new Combatiente("Sacerdote", campoBatalla, energia, datosCombatientes.getDatosSacerdote());
        }
    }
}
