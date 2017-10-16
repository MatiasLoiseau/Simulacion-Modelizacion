package sistema;

public class Servidor implements Runnable{

	private long mu;
	private Cola cola;
	
	public Servidor(long mu, Cola cola) {
		setMu(mu);
		setCola(cola);
		//this.run();
	}
	

	public void run () {
		while(true) {
			try {
				Thread.sleep(this.mu);
				cola.take();
				System.out.println("Te saque un wacho jiog jiog jiog");
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
	}
	
	
	public long getMu() {return mu;}
	public void setMu(long mu) {this.mu = mu * 1000;}//convert to seconds
	public Cola getCola() {return cola;}
	public void setCola(Cola cola) {this.cola = cola;}
	
}
