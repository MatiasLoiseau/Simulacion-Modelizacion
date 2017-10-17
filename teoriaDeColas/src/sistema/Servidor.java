package sistema;

public class Servidor implements Runnable{

	private long mu;
	private Cola cola;
	private Cronometro cronometro;
	
	private Thread hiloServidor;
	
	public Servidor(long mu, Cola cola, Cronometro cronometro) {
		setMu(mu);
		setCola(cola);
		setCronometro(cronometro);
		this.hiloServidor = new Thread(this);
		this.hiloServidor.start();
	}


	public void run () {
		while(true) {
			try {
				Cliente clienteASacar = cola.peek();
				if(clienteASacar != null) {
					clienteASacar.setTiempoInicioServidor(cronometro.getTiempoSimulacion());
					Thread.sleep(this.mu);
					clienteASacar.setTiempoSalidaSistema(cronometro.getTiempoSimulacion());
					cola.take();
					clienteASacar.mostrarInformacion();	
				}
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

	public Thread getHiloServidor() {
		return hiloServidor;
	}
	public void setHiloServidor(Thread hiloServidor) {
		this.hiloServidor = hiloServidor;
	}

	public Cronometro getCronometro() {
		return cronometro;
	}
	public void setCronometro(Cronometro cronometro) {
		this.cronometro = cronometro;
	}
	
}
