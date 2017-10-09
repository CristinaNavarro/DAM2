/*
⦁	Crear un hilo que calcule la serie fibonacci de un número
introducido por teclado. (1,1,2,3,5,8,13,...)
 */

import java.util.Scanner;

public class Hilo implements Runnable {
    Thread t;
    Scanner sc = new Scanner(System.in);
    Hilo(){
        t = new Thread(this);
        System.out.println("Introduce un numero");
        t.start();
    }

    public void run(){
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
