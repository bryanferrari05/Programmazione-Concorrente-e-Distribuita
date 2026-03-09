/*
	è un evoluzione del precedente, fa semore la copia di un file ma è scritto in modo più robusto
	si gestiscono meglio le eccezioni
	
	file sorgente --> programma java --> file destinazione
	si gestiscono le eccezioni con il try catch dando più messaggi chiari
*/

import java.io.*;

class CopiaFileArgs_a {
	FileReader frd; //campo della classe, non sono variabili locali (file reader lettura)
	FileWriter fwr; //campo della classe, non sono variabili locali (file wwriter scrittura)

	public void exec(String fn_in, String fn_out) { // metodo exec() riceve il nome del file di input e quelli di output ed esegue la copia quindi il main delega tutto il lavoro al metodo exec()
		try { // apertura del file di input 
			frd = new FileReader(fn_in);
		} catch(FileNotFoundException e) {
			System.out.println("File "+fn_in+" non trovato");
			return;
		}
		try { // apertura del file di output
			fwr = new FileWriter(fn_out);
		} catch(IOException e) {
			System.out.println("File "+fn_out+" non creabile");
			return;
		}

		//lettura e scrittura
		int i;
		try {
			while ((i = frd.read()) != -1) {
				fwr.write(i);
			}
		} catch (IOException e1) {
			System.out.println("Problema di I/O durante la copia");
			System.exit(0); // terminazione del programma
		}
		System.out.println("copia conclusa.");
		//chiusura degli stream
		try {
			frd.close();
			fwr.flush();
			fwr.close();
		} catch(IOException e) {
			System.out.println("Problemi in chiusura");
		}
	}
	public static void main(String[] args) {
		if (args.length != 2) { // controllo argomenti 
			System.out.println("Uso: java CopiaFileArgs <file_da_copiare> <file_copia>");
		} else { //esecuzione del rpgoramma 
			CopiaFileArgs_a cf=new CopiaFileArgs_a(); // creazione dell'oggetto 
			cf.exec(args[0], args[1]); // chiamata al metodo exec()
		}
	}
}
