import java.util.Scanner;

public class Hilo1 implements Runnable{
    Thread h1;
    Hilo1(){
        h1 = new Thread(this);
        h1.start();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero entero");
        int num=sc.nextInt();
        long total=1;
        while(num>=2){
            total *= num;
            num--;
        }
        System.out.println("Resultado: " +total);
    }
}
