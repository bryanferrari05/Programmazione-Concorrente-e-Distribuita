/*
	Questo programma fa sempre la copia di un file in un altro file, ma questa volta aggiunge un contatore di caratteri.
	e alla fine stampa quanti caratteri copiati.
*/

import java.io.*;

public class CopiaFileArgs_b {
    FileReader frd;
	FileWriter fwr;
	int count=0;

	public void exec(String fn_in, String fn_out) {
		//stream lettura da file
		try {
			frd = new FileReader(fn_in);
		} catch(FileNotFoundException e) {
			System.out.println("File "+fn_in+" non trovato");
			return;
		}
		//stream scrittura su file
		try {
			fwr = new FileWriter(fn_out);
		} catch(IOException e) {
			System.out.println("File "+fn_out+" non creabile");
			return;
		}
		//lettura e scrittura
		int i;
		try {
			while ((i = frd.read()) != -1) { //read() restituisce un int
				fwr.write(i); // write(i) scrive il carattere corrispondente a i
				count++;
			}
		} catch (IOException e1) {
			System.out.println("Problema di I/O durante la copia");
			System.exit(0);
		}
		//chiusura degli stream
		try {
			frd.close();
			fwr.flush();
			fwr.close();
		} catch(IOException e) {
			System.out.println("Problemi in chiusura");
		}
		finally {
			System.out.println("Copiati "+count+" caratteri");
		}
	}
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Uso: java CopiaFileArgs <file_da_copiare> <file_copia>");
		} else {
			CopiaFileArgs_b cf=new CopiaFileArgs_b();
			cf.exec(args[0], args[1]);
		}
	}
}
