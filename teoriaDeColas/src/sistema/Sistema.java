package sistema;

public class Sistema implements Runnable{
	private Cronometro cronometro;
	private Cola cola;
	private Cliente cliente;
	private Servidor servidor;
	private long lambda;
	private int cantClientesMaximos;
	
	private Thread hiloSistema;
	

	public Sistema (long lambda, long mu, int cantServidores, int cantClientesMaximos) {
		this.cronometro = new Cronometro();
		
		setLambda(lambda);
		
		//falta implementar cola
		this.cola = new Cola ();
		
		//falta implementar muchos servidores
		this.servidor = new Servidor(mu, cola, this.cronometro);
		
		this.cantClientesMaximos = cantClientesMaximos;
		
		this.hiloSistema = new Thread(this);
		
		hiloSistema.start();
		
	}
	
	public void run () {
		for(int x=0; x<cantClientesMaximos; x++) {
			try {
				cliente = new Cliente(this.cronometro.getTiempoSimulacion());
				cola.put(cliente);
				Thread.sleep(this.lambda);
		      }
		    catch (InterruptedException err) {
			      err.printStackTrace();
		      }
		}
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
	public long getLambda() {
		return lambda;
	}
	public void setLambda(long lambda) {
		this.lambda = lambda * 1000; //Convert to seconds
	}
	public int getCantClientesMaximos() {
		return cantClientesMaximos;
	}
	public void setCantClientesMaximos(int cantClientesMaximos) {
		this.cantClientesMaximos = cantClientesMaximos;
	}
	
}
