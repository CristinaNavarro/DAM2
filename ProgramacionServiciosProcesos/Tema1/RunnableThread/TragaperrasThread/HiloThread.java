public class HiloThread extends Thread {

    //halla numero enter 0 y 3 y escribe el resultado
    public void run(){
        int numero = (int)Math.floor(Math.random()*4);
        switch (numero){
            case 0:
                setName("Platano");
                break;
            case 1:
                setName("Cereza");
                break;
            case 2:
                setName("Sandia");
                break;
            default:
                setName("$");
        }
        System.out.print("||     "+getName() +"     || ");

    }
}
