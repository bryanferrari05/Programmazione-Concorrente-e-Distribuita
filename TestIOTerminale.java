/*
Idea generale del programma:
1. chiede all'utente di scrivere UN NUMERO
2. legge quello che l'utente scrive nel terminale
3. converte il testo in numero
4. lo ristampa a schermo

L'obiettivo è capire come funziona l'input tramite stream


Concetto base Stream --> uno stream è un flusso di dati.
puoi immaginarlo come un tubo dove scorrono i dati.

i tipi principali sono InputStream (dati che entrano nel programma) e OutputStream (dati che escono dal programma)
in questo esercizio Tastiera --> programma java quindi usiamo InputStream

Il problema è che la tastiera fornisce Byte, ma noi vogliamo stringhe leggibili.
per questo usiamo più oggetti uno sopra l'altro. System.in --> InputStreamReader --> BufferedReader

*/

import java.io.*; //importa tutte le classi del pacchetto java, tra queste ci sono BufferedReader, InpurSreamReader e IOException

class TestIOTerminale { //definizione della classe java chiamata TestIOTerminale

	public static void main(String[] args) throws IOException { //punto di partenza di ogni programma 
		// costruiamo un buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //creazione del BufferedReader (costruiamo un oggetto per leggere da tastiera) (new InputStreamReader prende i byte  e li trasforma in caratteri) (new BufferedReader serve per leggere righe di testo )
        System.out.print("Scrivi un numero > ");

		String s = br.readLine(); // usa il metodo readline per leggere tramite buffer (Tastiera --> System.in (byte) --> InputStreamReader (byte --> char) --> BufferedReader (letttura comoda))

		int n = Integer.parseInt(s); //conversione della stringa in numero 

		System.out.println("Numero scritto > " + n); //stampa
	}
}
