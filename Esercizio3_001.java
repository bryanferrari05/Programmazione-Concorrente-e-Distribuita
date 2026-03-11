public class Esercizio3_001 extends Thread{

    public Esercizio3_001(String name) {
        super(name);
    }

    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(this.getName());
        }
    }

    public static void main(String[] args) {
        Esercizio3_001 t1 = new Esercizio3_001("my thread");
        t1.start();
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }
}
