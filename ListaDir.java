import java.io.*;

public class ListaDir {
	File f = null;
	void exec(String name) {
		f = new File(name);
		if (f.isFile())
			// se name indica file, ne stampa nome e dimensione 
			System.out.println("File: " + f.getAbsolutePath() + ", " + f.length() + " byte");
		else {
			// se name indica una dir., allora preleva la lista dei file
			System.out.println("Directory: " + f.getAbsolutePath());
			if(f.exists()) {
				String[] lista = f.list();
				//stampa
				for(int i=0; i < lista.length; i++){
					File tmp = new File(f.getAbsolutePath(), lista[i]);
					if (tmp.isFile())
						System.out.println(" file: " + tmp.getName() + " " + tmp.length()
						+ " byte");
					else
						System.out.println(" dir.: " + tmp.getName());
				}
			} else {
				System.out.println("File "+name+" does not exist!");
			}
		}
	}
	public static void main(String[] args) {
		ListaDir ld = new ListaDir();
		//se non ci sono argomenti consideriamo la directory corrente
		ld.exec(args.length == 0?".":args[0]); 
	}
}
