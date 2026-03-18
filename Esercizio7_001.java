import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Esercizio7_001 {
	private void exec() {
		ThreadEs7 t=new ThreadEs7();
		t.start();
		String cmd=" ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			System.out.print("Inserisci comando > ");
			try {
				cmd=br.readLine();
			} catch (IOException e) {
				System.out.println("I/O Error: termino");
				break;
			}
			if(cmd.equals("fine")){
				t.interrupt();
				System.out.println("Main ha letto il comando di terminazione ");
				break;
			} else {
				System.out.println("Main ha letto il comando "+cmd+" e lo ha ignorato");
			}
		}
		try {
			t.join();
		} catch (InterruptedException e) {
			// il main non riceve nterrupt
		}
		System.out.println("Main termina");
	}
	public static void main(String[] args) throws InterruptedException {
		new Esercizio7_001().exec();
	}
}

