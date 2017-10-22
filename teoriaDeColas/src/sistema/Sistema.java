package sistema;

import java.util.Random;

public class Sistema implements Runnable{
	private Estadistica estadistica;
	private Cola cola;
	private Cliente cliente;
	private Servidor servidor;
	private Servidor listaServidores[];
	private double lambda;
	private boolean continuar;
	private Random rand;
	
	private Thread hiloSistema;
	

	public Sistema (double lambda, double mu, int cantServidores) {
		setLambda(lambda);
		setContinuar(true);
		this.estadistica = new Estadistica();
		this.cola = new Cola ();
		this.listaServidores = new Servidor[cantServidores];
		inicializacionServidores(cantServidores, mu, this.cola);
		this.hiloSistema = new Thread(this);
		rand = new Random(System.currentTimeMillis());
		hiloSistema.start();
		
	}
	
	public void run () {
		while(continuar == true) {
			try {
				cliente = new Cliente();
				cola.put(cliente);
				Thread.sleep(tiempoCliente());
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
	}
	
	public void inicializacionServidores(int cantServidores, double mu, Cola cola) {
		for(int x=0; x<cantServidores; x++) {
			this.listaServidores[x] = new Servidor(mu, cola, x, this.estadistica);
		}
	}
	
	public long tiempoCliente() {
		long tiempo = Math.round(1000 * Math.log(1 - rand.nextDouble()) / (-lambda));
		//System.out.println("Tiempo al proximo cliente: " + tiempo);
		return tiempo;
	}

	//Getters and Setters
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
	public Servidor[] getListaServidores() {
		return listaServidores;
	}
	public void setListaServidores(Servidor[] listaServidores) {
		this.listaServidores = listaServidores;
	}
	public boolean isContinuar() {
		return continuar;
	}
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	public Thread getHiloSistema() {
		return hiloSistema;
	}
	public void setHiloSistema(Thread hiloSistema) {
		this.hiloSistema = hiloSistema;
	}
	public Estadistica getEstadistica() {
		return estadistica;
	}
	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}

	
}
