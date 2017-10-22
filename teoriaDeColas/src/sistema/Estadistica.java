package sistema;

public class Estadistica implements Runnable{
	
	private int cantClientesTotal;
	private double tiempoClienteCola;
	private double tiempoClienteServidor;
	private double tiempoClienteSistema;
	private double promedioTiempoClienteCola;
	private double promedioTiempoClienteServidor;
	private double promedioTiempoClienteSistema;
	private boolean continuar;
	private Thread hiloEstadistica;


	public Estadistica() {
		setContinuar(true);
		setCantClientesTotal(0);
		setTiempoClienteCola(0);
		setTiempoClienteServidor(0);
		setTiempoClienteSistema(0);
		setPromedioTiempoClienteCola(0);
		setPromedioTiempoClienteServidor(0);
		setPromedioTiempoClienteSistema(0);

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

	public void agregarCliente(Cliente cliente) {
		this.cantClientesTotal++;
		this.tiempoClienteCola = this.tiempoClienteCola + cliente.getTiempoCola();
		this.tiempoClienteServidor = this.tiempoClienteServidor + cliente.getTiempoServidor();
		this.tiempoClienteSistema = this.tiempoClienteSistema + cliente.getTiempoSalidaSistema();
		this.promedioTiempoClienteCola = (this.tiempoClienteCola)/(cantClientesTotal);
		this.promedioTiempoClienteServidor = (this.tiempoClienteServidor)/(cantClientesTotal);
		this.promedioTiempoClienteSistema = (this.tiempoClienteSistema)/(cantClientesTotal);
	}
	
	public void mostrar() {
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("Informacion estadistica del sistema:");
		System.out.println("Tiempo promedio en la cola: " + this.getPromedioTiempoClienteCola());
		System.out.println("Tiempo promedio en el servidor: " + this.getPromedioTiempoClienteServidor());
		System.out.println("Tiempo promedio en el sistema: " + this.getPromedioTiempoClienteSistema());
	
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
	public int getCantClientesTotal() {
		return cantClientesTotal;
	}
	public void setCantClientesTotal(int cantClientesTotal) {
		this.cantClientesTotal = cantClientesTotal;
	}
	public double getTiempoClienteCola() {
		return tiempoClienteCola;
	}
	public void setTiempoClienteCola(double tiempoClienteCola) {
		this.tiempoClienteCola = tiempoClienteCola;
	}
	public double getTiempoClienteServidor() {
		return tiempoClienteServidor;
	}
	public void setTiempoClienteServidor(double tiempoClienteServidor) {
		this.tiempoClienteServidor = tiempoClienteServidor;
	}
	public double getTiempoClienteSistema() {
		return tiempoClienteSistema;
	}
	public void setTiempoClienteSistema(double tiempoClienteSistema) {
		this.tiempoClienteSistema = tiempoClienteSistema;
	}
	public double getPromedioTiempoClienteCola() {
		return promedioTiempoClienteCola;
	}
	public void setPromedioTiempoClienteCola(double promedioTiempoClienteCola) {
		this.promedioTiempoClienteCola = promedioTiempoClienteCola;
	}
	public double getPromedioTiempoClienteServidor() {
		return promedioTiempoClienteServidor;
	}
	public void setPromedioTiempoClienteServidor(double promedioTiempoClienteServidor) {
		this.promedioTiempoClienteServidor = promedioTiempoClienteServidor;
	}
	public double getPromedioTiempoClienteSistema() {
		return promedioTiempoClienteSistema;
	}
	public void setPromedioTiempoClienteSistema(double promedioTiempoClienteSistema) {
		this.promedioTiempoClienteSistema = promedioTiempoClienteSistema;
	}

}
