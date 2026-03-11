public class Esercizio6_001 extends Thread{
        public Esercizio6_001(String name) {
        super(name);
    }

    public void run(){
    System.out.println(this.getName());
    }

    public static void main(String args []) {
        int numero = Integer.parseInt(args[0]);
        for(int i = 0; i < numero; i++){
        Esercizio6_001 t1 = new Esercizio6_001("il mio thread è il numero " + i);
        t1.start();
        }
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }
}
