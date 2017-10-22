package sistema;

import java.util.Random;

public class Servidor implements Runnable{

	private double mu;
	private Cola cola;
	private Random rand;
	private int id;
	
	private Thread hiloServidor;
	
	public Servidor(double mu, Cola cola, int id) {
		setMu(mu);
		setCola(cola);
		setId(id);
		this.rand = new Random(System.currentTimeMillis());

		this.hiloServidor = new Thread(this);
		this.hiloServidor.start();
	}

	public void run () {
		while(true) {
			try {
				Cliente clienteEnServidor = cola.take();
				clienteEnServidor.setTiempoInicioServidor();
				clienteEnServidor.setTiempoCola();
				Thread.sleep(tiempoServidor());
				clienteEnServidor.setTiempoSalidaSistema();
				clienteEnServidor.setTiempoServidor();
				System.out.println("//////////////////////////INICIO//////////////////////////////");
				System.out.println("En el servidor:  " + id);
				clienteEnServidor.mostrarInformacion();	
					///////////////////////////////////
				//El método stop() es obsoleto
				clienteEnServidor.getHiloCliente().stop();	
				//El metodo interrupt me tira errores
				//clienteEnServidor.getHiloCliente().interrupt();	
				
					
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
	}
	
	public long tiempoServidor() {
		long tiempo = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-mu));
		//System.out.println("Tiempo de atencion del servidor: " + tiempo + " En el servidor: " + id);
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
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
