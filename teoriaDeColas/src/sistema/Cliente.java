package sistema;

public class Cliente {
	private double tiempoInicioSistema;
	private double tiempoInicioServidor;
	private double tiempoSalidaSistema;
	
	public Cliente(double tiempoInicioSistema) {
		this.setTiempoInicioSistema(tiempoInicioSistema);
	}
	
	public void mostrarInformacion() {
		System.out.println("Informacion cliente:");
		System.out.println("Entro al sistema: " + this.getTiempoInicioSistema());
		System.out.println("Entro al servidor: " + this.getTiempoInicioServidor());
		System.out.println("Salio: " + this.getTiempoSalidaSistema());
	}
	
	public double getTiempoInicioSistema() {
		return tiempoInicioSistema;
	}
	public void setTiempoInicioSistema(double tiempoInicioSistema) {
		this.tiempoInicioSistema = tiempoInicioSistema;
	}
	public double getTiempoInicioServidor() {
		return tiempoInicioServidor;
	}
	public void setTiempoInicioServidor(double tiempoInicioServidor) {
		this.tiempoInicioServidor = tiempoInicioServidor;
	}
	public double getTiempoSalidaSistema() {
		return tiempoSalidaSistema;
	}
	public void setTiempoSalidaSistema(double tiempoSalidaSistema) {
		this.tiempoSalidaSistema = tiempoSalidaSistema;
	}
}
