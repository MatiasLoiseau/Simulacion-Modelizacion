package sistema;

public class Estadistica implements Runnable{
	
	private boolean continuar;
	private Thread hiloEstadistica;



	public Estadistica() {
		setContinuar(true);
		this.hiloEstadistica = new Thread(this);
		
		this.hiloEstadistica.start();
	}
	
	
	public void run () {
		while (continuar == true) {
			try {
		      Thread.sleep (1000);
		  }
	      catch (InterruptedException err) {
		      err.printStackTrace();
	      }
		}
	}

	public boolean isContinuar() {
		return continuar;
	}
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	public Thread getHiloEstadistica() {
		return hiloEstadistica;
	}
	public void setHiloEstadistica(Thread hiloEstadistica) {
		this.hiloEstadistica = hiloEstadistica;
	}	
	
}
