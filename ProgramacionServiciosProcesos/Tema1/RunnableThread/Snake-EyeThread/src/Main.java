public class Main {
    public static void main(String[] args) {
        int suma=0;
    //    while (suma!=7 || suma!=11) {
            for (int i = 0; i < 2; i++) {
                HiloThread t = new HiloThread();
          //      t.setName("0");
                t.start();
          //      System.out.println("dado" +Integer.parseInt(t.getName()));
          //      suma += Integer.parseInt(t.getName());
            }

        /*    switch (suma) {
                case 7:
                    System.out.println("Has sacado " + suma + ", has ganado.");
                    break;
                case 11:
                    System.out.println("Has sacado " + suma + ", has perdido.");
                    break;
                default:
                    System.out.println("Siga jugando " +suma);
            }*/
        }
   // }
}
