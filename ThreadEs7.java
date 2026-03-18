public class ThreadEs7 extends Thread{
	public void run(){
		int a=1;
		for(;;){
			System.out.println("Ciao");
			for(int i=0;i<1000; i++) {
				for(int j=0;j<1000; j++) {
					for(int z=0;z<1000; z++) {
						a=1-a;
					}
				}
			}
			if(this.isInterrupted()) {
				System.out.println("Thread termina per interrupt da sveglio");
				break;				
			}
			System.out.println("Thread va a dormire");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Thread termina per interrupt da sleeping");
				break;	
			}
		}
		System.out.println("Thread termina");
	}
}
