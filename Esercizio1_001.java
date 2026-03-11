public class Esercizio1_001 extends Thread {
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("Thread");
        }
    }
    public static void main(String args[]){
        Esercizio1_001 t1 =  new Esercizio1_001();
        t1.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }   
}
