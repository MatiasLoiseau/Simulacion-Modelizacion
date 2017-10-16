package sistema;

public class Sistema implements Runnable{
	public Cronometro cronometro;
	public Cola cola;
	public Cliente cliente;
	public Servidor servidor;
	public long lambda;
	public int cantClientesMaximos;
	

	public Sistema (long lambda, long mu, int cantServidores, int cantClientesMaximos) {
		this.cronometro = new Cronometro();
		
		setLambda(lambda);
		
		//falta implementar cola
		this.cola = new Cola ();
		
		//falta implementar muchos servidores
		this.servidor = new Servidor(mu, cola);
		
		this.cantClientesMaximos = cantClientesMaximos;
		
		this.run();
		this.servidor.run();
		this.cronometro.run();
		
		
	}
	
	public void run () {
		for(int x=0; x<cantClientesMaximos; x++) {
			try {
				Thread.sleep(this.lambda);
				cliente = new Cliente(this.cronometro.getTiempoSimulacion());
				cola.put(cliente);
				System.out.println("Te puse un wacho");
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
