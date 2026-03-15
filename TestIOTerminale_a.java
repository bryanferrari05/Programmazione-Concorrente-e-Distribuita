/*
Stessa logica del primo ma gestisce gli errori
1 chiedi numero
2 leggi input
3 prova a convertirlo in intero
4 se non è un numero -> messaggio errore
5 ripeti finché input non è valido
6 stampa il numero

*/

import java.io.*;

class TestIOTerminale_a {

    public static void main(String[] args) throws IOException {
        // costruiamo un buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean completato=false;
        int n=0;
        while(!completato) {     
            System.out.print("Scrivi un numero > "); // propmt
            String s = br.readLine();  //lettura
            try {               // se nel try si verifica un’eccezione, l’esecuzione si ferma immediatamente e passa al catch. Il resto del try non viene eseguito.
                n = Integer.parseInt(s);
            	completato=true;
            } catch(NumberFormatException e) {
                System.out.println("Input non riconosciuto");          	
            }
            if(completato) {
                System.out.println("Numero scritto > " + n); //stampa
            }
        }
    }
}
