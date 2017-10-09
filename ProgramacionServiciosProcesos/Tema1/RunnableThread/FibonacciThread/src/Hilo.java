import java.util.Scanner;

public class Hilo extends Thread{

    Hilo(){
        System.out.println("Introduce un numero");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int numeros = sc.nextInt();
        int total = 1; //suma anterior+total
        int aux;        //guarda valor total para modificar vble anterior
        int anterior = 0;   //lo que valia antes total
        System.out.print("Serie: " +anterior +", ");
        for(int i=1;i<numeros-1;i++){
            System.out.print(total +", ");
            aux = total;
            total+=anterior;
            anterior = aux;
        }
        System.out.print(total);
    }
}
