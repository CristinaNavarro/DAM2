public class Persona extends Thread {
    Saludo saludo;
    Persona(int prioridad, Saludo saludo){
        this.saludo = saludo;
        this.setPriority(prioridad);
    }

    public void run(){
        if(getPriority() == MAX_PRIORITY){
            System.out.println("Ha entrado el Rey.");
        }else{
            System.out.println("Ha entrado un súbdito.");
        }
        saludo.saludar(this.getPriority());
    }

}
