public class Esercizio5_001 extends Thread{

    Esercizio5_001(){
        this.start();
    }
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread");
        }
    }

    public static void main(String[] args) {
        Esercizio5_001 t1 = new Esercizio5_001();

        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }
}
