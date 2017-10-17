package sistema;

import java.util.Random;

public class Sistema implements Runnable{
	private Cronometro cronometro;
	private Cola cola;
	private Cliente cliente;
	private Servidor servidor;
	private double lambda;
	private int cantClientesMaximos;
	private Random rand;
	
	private Thread hiloSistema;
	

	public Sistema (double lambda, double mu, int cantServidores, int cantClientesMaximos) {
		this.cronometro = new Cronometro();
		
		setLambda(lambda);
		
		//falta implementar cola
		this.cola = new Cola ();
		
		//falta implementar muchos servidores
		this.servidor = new Servidor(mu, cola, this.cronometro);
		
		this.cantClientesMaximos = cantClientesMaximos;
		
		this.hiloSistema = new Thread(this);
		
		rand = new Random(System.currentTimeMillis());
		
		hiloSistema.start();
		
	}
	
	
	public void run () {
		for(int x=0; x<cantClientesMaximos; x++) {
			try {
				cliente = new Cliente(this.cronometro.getTiempoSimulacion());
				cola.put(cliente);
				Thread.sleep(tiempoCliente());
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
	}
	
	public long tiempoCliente() {
		long tiempo = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-lambda));
		System.out.println("Tiempo al proximo cliente: " + tiempo);
		return tiempo;
	}

	//Getters and Setters
	public Cronometro getCronometro() {return cronometro;}
	public void setCronometro(Cronometro cronometro) {this.cronometro = cronometro;}
	public Cola getCola() {return cola;}
	public void setCola(Cola cola) {this.cola = cola;}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	public double getLambda() {
		return lambda;
	}
	public void setLambda(double lambda) {
		this.lambda = lambda; //Convert to seconds
	}
	public int getCantClientesMaximos() {
		return cantClientesMaximos;
	}
	public void setCantClientesMaximos(int cantClientesMaximos) {
		this.cantClientesMaximos = cantClientesMaximos;
	}
	
}
