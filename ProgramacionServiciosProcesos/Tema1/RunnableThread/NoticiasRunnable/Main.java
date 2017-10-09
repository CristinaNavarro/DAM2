/*
********Autor: Cristina Navarro*********************
********Fecha: 24/09/2017***************************
********Asignatura:ProgramacionServiciosYProcesos***
********Ejercicio: Crear un sistemas de mensajes de*
********  tres líneas (Deportes, Economía y*********
********  Política), de forma que vayan mostrándose*
********  por pantalla los mensajes que se han******
********  almacenado en un array)*******************
*/

public class Main {
    public static void main(String[] args) {
        String[] noticia = {"Deportes: “España sigue adelante en el campeonato”",
                "Economía: “El IBEX35 baja medio punto”",
                "Política: “España sigue sin acuerdo de gobierno”",
                "Economía: “La bolsa de NY se desploma”",
                "Economía: “Baja la prima de riesgo griega”",
                "Deportes: “El Málaga C.F. Campeón de Liga”"};

        for(String n:noticia){
            new HiloRunnable(n);
        }
    }
}
