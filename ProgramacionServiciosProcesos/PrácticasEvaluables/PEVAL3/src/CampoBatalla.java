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
import java.util.List;

class CampoBatalla {

    //Atributos
    private int intAforo;
    private int intCombatientesDentro;
    private List<String> listClasesPermitidas;
    private Combatiente[] arrayCombatientes;
    private int intCombatienteAnterior = -1;
    private boolean boFinBatalla = false;

    //Constructor
    CampoBatalla(int intAforo, ArrayList<String> listClasesPermitidas) {
        this.intAforo = intAforo;
        this.listClasesPermitidas = listClasesPermitidas;
        arrayCombatientes = new Combatiente[intAforo];
        this.intCombatientesDentro = 0;
    }

    //Métodos
    //comprueba si pueden entrar o no más combatientes
    boolean campoLleno() {
        return intAforo <= intCombatientesDentro;
    }

    //da a conocer si se ha finalizado la batalla
    boolean finBatalla() {
        return this.boFinBatalla;
    }

    //permite o no la entrada de los combatientes al campo de batalla
    synchronized void comprobarEntrada(Combatiente combatiente) {
        if (listClasesPermitidas.contains(combatiente.getStrTipo()) && intCombatientesDentro < intAforo) {
            arrayCombatientes[this.intCombatientesDentro] = combatiente;
            combatiente.setIntIdentificador(this.intCombatientesDentro);
            System.out.println("Un " + combatiente.getStrTipo() + " ha entrado al campo de batalla, se le ha asignado el identificador " + intCombatientesDentro);
            this.intCombatientesDentro++;
        }
    }

    //gestiona el turno de ataque, evitando que el mismo combatiente ataque dos turnos seguidos
    synchronized void turnoAtaque(int intIdentificador, String strTipo, Energia energia, int intAtaque) {
        if (!boFinBatalla) {
            try {
                while (intCombatienteAnterior == intIdentificador) {
                    /*try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("\n\n\n\n\n\n----->Ha intentado atacar el " + strTipo + " con identificador " + intIdentificador + ", pero tiene que descansar.\n\n\n\n\n\n");
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!boFinBatalla && intIdentificador != -1) {
                intCombatienteAnterior = intIdentificador;
                System.out.println("\n\n----->El " + strTipo + " con el identificador " + intIdentificador + " va a atacar");
                atacar(intIdentificador, intAtaque);
                gastarEnergia(energia);
                comprobarGanador(energia);
            }
        }
        notifyAll();
    }

    //determina el objetivo y resta la salud correspondiente al ataque del combatiente que posee el turno
    private void atacar(int intIdentificador, int intAtaque) {
        int intObjetivo;
        do {
            intObjetivo = (int) (Math.random() * intAforo);
        }
        while (intObjetivo == intIdentificador || arrayCombatientes[intObjetivo].getIntIdentificador() == -1);
        System.out.println("ATAQUE: Ha atacado a un " + arrayCombatientes[intObjetivo].getStrTipo() + " con el identificador " + arrayCombatientes[intObjetivo].getIntIdentificador());
        arrayCombatientes[intObjetivo].setIntSalud(intAtaque);
    }

    //comprueba si se ha finalizado la batalla y quién es el ganador según la vida restante
    private void comprobarGanador(Energia energia) {
        int intIdentificadorGanador = -1;
        System.out.println("---------Marcador---------");
        int intContadorSupervivientes = 0;
        for (int i = 0; i < arrayCombatientes.length; i++) {
            if (arrayCombatientes[i].getIntSalud() > 0) {
                intIdentificadorGanador = arrayCombatientes[i].getIntIdentificador();
                intContadorSupervivientes++;
            } else {
                arrayCombatientes[i].setIntIdentificador(-1);
            }
            if (arrayCombatientes[i].getIntIdentificador() != -1) {
                System.out.println("El " + arrayCombatientes[i].getStrTipo() + " con identificador " + arrayCombatientes[i].getIntIdentificador() + " tiene " + arrayCombatientes[i].getIntSalud() + " de salud.");
            } else {
                System.out.println("El " + arrayCombatientes[i].getStrTipo() + " que poseía el identificador " + i + " yace en el suelo.");
            }
        }
        if (intContadorSupervivientes == 1) {
            boFinBatalla = true;
            for (Combatiente arrayCombatiente : arrayCombatientes) {
                if (arrayCombatiente.getIntSalud() > 0) {
                    System.out.println("Ha ganado el " + arrayCombatiente.getStrTipo() + " con indentificador " + intIdentificadorGanador);
                    arrayCombatiente.setIntIdentificador(-1);
                }
            }
        } else if (energia.intCantidadEnergia == 0) {
            boFinBatalla = true;
            comprobarGanadorEnergia();
        }
    }

    //determina el ganador si no queda energía
    private void comprobarGanadorEnergia() {
        Combatiente combatienteGanador = null;
        int mayorSalud = 0;
        for (Combatiente arrayCombatiente : arrayCombatientes) {
            if (arrayCombatiente.getIntSalud() > mayorSalud) {
                mayorSalud = arrayCombatiente.getIntSalud();
                combatienteGanador = arrayCombatiente;
            }
        }
        for (Combatiente arrayCombatiente : arrayCombatientes) {
            if (arrayCombatiente.getIntSalud() == mayorSalud && arrayCombatiente != combatienteGanador) {
                System.out.println("Ha ganado el " + arrayCombatiente.getStrTipo() + " con indentificador " + arrayCombatiente.getIntIdentificador());
            }
        }
        if (combatienteGanador != null) {
            System.out.println("Ha ganado el " + combatienteGanador.getStrTipo() + " con indentificador " + combatienteGanador.getIntIdentificador());
        }
    }

    //resta 100 de energia en cada turno de ataque
    private void gastarEnergia(Energia energia) {
        synchronized (energia) {
            energia.intCantidadEnergia -= 100;
            System.out.println("ESTADO DE ENERGÍA: Tras el gasto de energía queda " + energia.intCantidadEnergia);
        }
    }

    //si un combatiente se cura, añade 100 a la cantidad total de energía
    void devolverEnergia(Energia energia) {
        synchronized (energia) {
            energia.intCantidadEnergia += 100;
            System.out.println("ESTADO DE ENERGÍA: Tras la devolución de energía queda " + energia.intCantidadEnergia);
        }
    }
}



