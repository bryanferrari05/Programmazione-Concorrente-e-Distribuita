public class Esercizio2_001 implements Runnable{
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("thread");
        }
    }

    public static void main (String args[]){
        Esercizio2_001 re = new Esercizio2_001();
        Thread t1 = new Thread(re);
        t1.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }
}
