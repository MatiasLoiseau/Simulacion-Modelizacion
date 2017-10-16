package sistema;

public class Cliente {
	public double tiempoInicioSistema;
	public double tiempoInicioServidor;
	public double tiempoSalidaSistema;
	
	public Cliente(double tiempoInicioSistema) {
		this.setTiempoInicioSistema(tiempoInicioSistema);
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
