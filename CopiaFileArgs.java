/* questo esercizio introduce un concetto nuovo rispetto ai precedenti, si legge non da tastiera ma da un file e si copia il contenuto in un altro file
file sorgente --> programma java --> file destinazione

*/

import java.io.*;

class CopiaFileArgs { // contiene solo il main non serve creare oggetti perché è un programma semplice

    public static void main(String[] args) throws IOException { // args è un array di stringhe che contiene gli argomenti passati da terminale java CopiaFileArgs file1.txt file2.txt args[0] = "file1.txt" args[1] = "file2.txt"

        if (args.length == 2) {  // controllo degli argomenti, il programma deve passare due argomenti, se non ne riceve due eccezzione ArrayIndexOutOfBoundsException
            FileReader frd = new FileReader(args[0]); // si crea uno stream di input da file
            FileWriter fwr = new FileWriter(args[1]); // si crea uno stream di output da file se il file non esiste java lo crea automaticamente se esiste viene sovrascritto

            int i; // memorizza il carattere letto perché read() restituisce un int e non un char (-1 --> EOF)
            while ((i = frd.read()) != -1) { // legge un carattere dal file e lo salva in i e controlla se è -1
                fwr.write(i); // scrive il carattere nel nuovo file
            }
            System.out.println("copia conclusa"); // stampato dopo che la copia è terminata
            frd.close(); // chiude lo stream di lettura
            fwr.flush(); // forza la scrittura dei dati nel file serve perché i dati potrebbere essere ancora nel buffer
            fwr.close(); // chiude lo stream di chiusura

        } else {
            System.out.println("Uso: java CopiaFileArgs <file_da_copiare> <file_copia>");// caso di uso errato
        }
    }
}
