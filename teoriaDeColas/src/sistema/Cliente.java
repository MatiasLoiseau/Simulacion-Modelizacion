package sistema;

public class Cliente implements Runnable{
	private double tiempoInicioServidor;
	private double tiempoSalidaSistema;
	private double tiempoCola;//es el tiempo que entro al servidor
	private double tiempoServidor;//tiempo simulacion - tiempo inicio servidor
	private double tiempoSimulacion;//tiempo que suma de a 1 mili segundo
	private boolean continuar;
	
	private Thread hiloCliente;
		
	public Cliente() {
		this.hiloCliente = new Thread(this);
		setContinuar(true);
		setTiempoSimulacion(0);
		this.hiloCliente.start();
	}
	
	public void run() {
		while (continuar == true) {
			try {
		      Thread.sleep (1);
		      this.tiempoSimulacion++;
	      }
	      catch (InterruptedException err) {
		      err.printStackTrace();
	      }
		}
	}
	
	//Cambiar los tiempos, el cronometro no tiene que llevar la cuenta ! ! ! !
	public void mostrarInformacion() {
		System.out.println("Informacion cliente:");
		System.out.println("Tiempo en la cola: " + this.getTiempoCola());
		System.out.println("Tiempo en el servidor: " + this.getTiempoServidor());
		System.out.println("Tiempo en el sistema: " + this.getTiempoSalidaSistema());
		System.out.println("//////////////////////////FIN//////////////////////////////");
	}
	
	public double getTiempoInicioServidor() {
		return tiempoInicioServidor;
	}
	//Setter modificado
	public void setTiempoInicioServidor() {
		this.tiempoInicioServidor = getTiempoSimulacion();
	}
	public double getTiempoSalidaSistema() {
		return tiempoSalidaSistema;
	}
	//Setter modificado
	public void setTiempoSalidaSistema() {
		this.tiempoSalidaSistema = getTiempoSimulacion();	
	}
	public boolean isContinuar() {
		return continuar;
	}
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
	}
	public Thread getHiloCliente() {
		return hiloCliente;
	}
	public void setHiloCliente(Thread hiloCliente) {
		this.hiloCliente = hiloCliente;
	}
	public double getTiempoSimulacion() {
		return tiempoSimulacion;
	}
	public void setTiempoSimulacion(double tiempoSimulacion) {
		this.tiempoSimulacion = tiempoSimulacion;
	}
	public double getTiempoCola() {
		return tiempoCola;
	}
	//Setter modificado
	public void setTiempoCola() {
		this.tiempoCola = this.getTiempoInicioServidor();
	}
	public double getTiempoServidor() {
		return tiempoServidor;
	}
	//Setter modificado
	//Es el resultado de la salida del sistema y el inicio del servidor
	public void setTiempoServidor() {
		this.tiempoServidor = this.getTiempoSalidaSistema() - this.getTiempoInicioServidor();
	}
	public void setTiempoInicioServidor(double tiempoInicioServidor) {
		this.tiempoInicioServidor = tiempoInicioServidor;
	}
	public void setTiempoSalidaSistema(double tiempoSalidaSistema) {
		this.tiempoSalidaSistema = tiempoSalidaSistema;
	}
	
	
}
