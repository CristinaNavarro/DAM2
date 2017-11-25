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
public class Combatiente implements Runnable {

    //Atributos
    private Thread threadCombatiente;
    private CampoBatalla campoBatalla;
    private Energia energia;
    private String strTipo;
    private int intSaludMaxima;
    private int intSalud;
    private int intIdentificador;
    private int intAtaque;
    private int intResistencia;
    private int intCura;

    //Constructor
    Combatiente(String strTipo, CampoBatalla campoBatalla, Energia energia, int[] datosCombatiente) {
        this.threadCombatiente = new Thread(this);
        this.campoBatalla = campoBatalla;
        this.energia = energia;
        this.strTipo = strTipo;
        this.intIdentificador = -1;
        this.intSalud = datosCombatiente[0];
        this.intAtaque = datosCombatiente[1];
        this.intResistencia = datosCombatiente[2];
        this.intCura = datosCombatiente[3];
        this.intSaludMaxima = this.intSalud;
        this.threadCombatiente.start();
    }

    //Getter&Setter
    synchronized String getStrTipo() {
        return this.strTipo;
    }

    synchronized void setIntIdentificador(int intIdentificador) {
        this.intIdentificador = intIdentificador;
    }

    synchronized int getIntIdentificador() {
        return this.intIdentificador;
    }

    synchronized void setIntSalud(int intRestarSalud) {
        this.intSalud -= (intRestarSalud - intResistencia);
    }

    synchronized int getIntSalud() {
        return this.intSalud;
    }

    //Métodos
    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 3000 + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        campoBatalla.comprobarEntrada(this);
        if (this.getIntIdentificador() != -1) {
            while (this.intSalud > 0 && this.getIntIdentificador() != -1 && energia.intCantidadEnergia > 0) {
                /*try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if (campoBatalla.campoLleno() && this.intIdentificador != -1 && energia.intCantidadEnergia != 0) {
                    campoBatalla.turnoAtaque(this.intIdentificador, this.strTipo, energia, this.intAtaque);
                    if (this.intSalud > 0 && this.intCura > 0 && this.intSalud != this.intSaludMaxima && this.energia.intCantidadEnergia != 0 && !campoBatalla.finBatalla()) {
                        System.out.println("CURACIÓN: El " + this.strTipo + " con identificador " + this.getIntIdentificador() + " se ha curado " + this.intCura);
                        this.intSalud += intCura;
                        campoBatalla.devolverEnergia(this.energia);
                    }
                }
            }
        }
    }
}


