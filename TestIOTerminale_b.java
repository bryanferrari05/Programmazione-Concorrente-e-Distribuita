/*
non legge solo input: introduce una struttura più "pulita" e più vicina a come si progetta davvero un programma.
il programma continua a chiedere input all'utente e possono succedere 4 cose:
1 l'utente scrive un numero valido
2 l'utente scrive una cosa non valida
3 l'utente scrive "basta" e il programma termina
4 avviene un errore I/O

il prof fa una cosa elegante separando i ruoli, leggeInt() si occupa di leggere e classificare l'input e exec() si occupa di decidere cosa fare in base all'esito

*/

import java.io.*;

class TestIOTerminale_b { // questa volta si crea proprio un oggetto con dei campi e dei metodi 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // serve a leggere da tastiera come i programmi precedenti
	PrintStream out = System.out;
	int numeroLetto=0; // qui il numero letto non viene restituito direttamente dal metodo leggiInt() ma viene memorizzato in un campo dell'oggetto

	//quindi leggiInt() legge l'input poi se trova un numero valido lo salva in numeroLetto poi restituisce solo l'esito della lettura
	// il metodo leggiInt() non restituisce un boolean ma un enum
	// EsitoLettura leggiInt() restituisce solo il tipo di risultato ottenuto e non il numero
	EsitoLettura leggiInt()  {
		String s;
		try {
			s= br.readLine();
		} catch(IOException e) {
			return EsitoLettura.ErroreIO;
		}
		if(s.equals("Basta")) {
			return EsitoLettura.LettoEOF;
		}
		try {
			numeroLetto = Integer.parseInt(s);
			return EsitoLettura.LettoNumero;
		} catch(NumberFormatException e) {
			return EsitoLettura.LettoSchifezza;
		} 
	}

	public void exec() { // questo metodo gestisce il ciclo di iterazione con il terminale
		boolean completato=false;
		while(!completato) {
			out.print("Scrivi un numero > ");
			EsitoLettura el=leggiInt();  // lettura
			switch(el) {
			   case LettoNumero:
					out.println("Numero scritto > " + numeroLetto);
					completato=false;
					break; 
			   case LettoEOF:
					completato=true;
					break;
			   case LettoSchifezza:
					out.println("Numero non riconosciuto");
					completato=false;
					break;
			   case ErroreIO:
					out.println("I/O error: termino");
					completato=true;	   
			}
		}
	}

	public static void main(String[] args) throws IOException {
		TestIOTerminale_b tt=new TestIOTerminale_b(); //creazione oggetto
		tt.exec(); //esecuzione logica principale 
		System.out.println("main termina");
	}
}
