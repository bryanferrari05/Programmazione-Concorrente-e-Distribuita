/*
    parte il thread principale main
    parte il secondo thread t1
    entrambi stampano cose in parallelo
*/

public class Esercizio1_001 extends Thread { // creazione di una classe che estende thread
    public void run(){ // codice che esegue il thread parte quando chiamo start()
        for(int i = 0; i < 3; i++){
            System.out.println("Thread");
        }
    }
    public static void main(String args[]){ // programma prinicpale thread main
        Esercizio1_001 t1 =  new Esercizio1_001(); // creazione dell'oggetto thread 
        t1.start(); // avvio del thread 
        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }   
}


/*
- extends Thread → creo un thread
- run() → cosa fa
- start() → lo avvia davvero
- main e t1 → lavorano in parallelo
- output → NON prevedibile
*/
