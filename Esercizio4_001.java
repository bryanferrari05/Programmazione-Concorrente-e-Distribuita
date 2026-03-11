public class Esercizio4_001 implements  Runnable{

        public void run(){
        for(int i=0;i<3;i++){
			System.out.println(Thread.currentThread().getName());
		}
    }

    public static void main (String args[]){
        Esercizio4_001 re = new Esercizio4_001();
        Thread t1 = new Thread(re, "pippo");
        Thread t2 = new Thread(re, "pluto");
        t1.start();
        t2.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }
}
