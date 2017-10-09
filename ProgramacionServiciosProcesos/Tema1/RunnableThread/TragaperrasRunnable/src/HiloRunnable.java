public class HiloRunnable implements Runnable {
    Thread t;
    HiloRunnable(){
        t = new Thread(this);
        t.start();
    }

    //halla numero enter 0 y 3 y escribe el resultado
    public void run(){
        int numero = (int)Math.floor(Math.random()*3);
        switch (numero){
            case 0:
                t.setName("Platano");
                break;
            case 1:
                t.setName("Cereza");
                break;
            case 2:
                t.setName("Sandia");
                break;
            default:
                t.setName("$");
        }
        System.out.print("||     "+t.getName() +"     || ");

    }
}
