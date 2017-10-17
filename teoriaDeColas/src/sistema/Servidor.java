package sistema;

import java.util.Random;

public class Servidor implements Runnable{

	private double mu;
	private Cola cola;
	private Cronometro cronometro;
	private Random rand;
	
	private Thread hiloServidor;
	
	public Servidor(double mu, Cola cola, Cronometro cronometro) {
		setMu(mu);
		setCola(cola);
		setCronometro(cronometro);
		this.rand = new Random(System.currentTimeMillis());

		this.hiloServidor = new Thread(this);
		this.hiloServidor.start();
	}

	public void run () {
		while(true) {
			try {
				Cliente clienteASacar = cola.peek();
				if(clienteASacar != null) {
					//long tiempoAtencion = Math.round(1000 * (Math.log (1-Math.random ())/-mu));
					
					clienteASacar.setTiempoInicioServidor(cronometro.getTiempoSimulacion());
					Thread.sleep(tiempoServidor());
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
	
	public long tiempoServidor() {
		long tiempo = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-mu));
		System.out.println("Tiempo de atencion del servidor: " + tiempo);
		return tiempo;
	}
	
	
	public double getMu() {return mu;}
	public void setMu(double mu) {this.mu = mu;}//convert to seconds
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
