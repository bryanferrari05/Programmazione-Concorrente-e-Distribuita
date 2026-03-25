/*
    Stesso concetto di prima ma fatto in un altro modo 
    anche qui si hanno due thread ma la differenza è che non estendo thread ma uso Runnable
*/

public class Esercizio2_001 implements Runnable{ // questa classe descrive cosa deve fare un thread (sto creando un task non un thread)
    public void run(){ // codice da eseguire del thread
        for (int i = 0; i < 3; i++) {
            System.out.println("thread");
        }
    }

    public static void main (String args[]){ // thread main
        Esercizio2_001 re = new Esercizio2_001(); // creazione di un oggetto che implementa runnable
        Thread t1 = new Thread(re); // creazione di un thread vero e gli passi dentro (re) "questo thread eseguirà il run() di re"
        t1.start(); // avvio thread

        for (int i = 0; i < 3; i++) {
            System.out.println("Main");
        }
    }
}

/*
perché può essere meglio runnable?
- Puoi estendere altre classi (Java non supporta l'ereditarietà multipla)
- separi la logica (runnable) e l'esecuzione (thread)

👉 Il programma fa:

creo un lavoro (Runnable)
creo un thread che lo esegue
partono insieme → output misto
*/