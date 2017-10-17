package sistema;

//Tiene que ser  implements runnable segun Agus
public class Cronometro implements Runnable{
	
	//Variables
	private int tiempoSimulacion;
	private boolean continuar=true;
	
	private Thread hiloCronometro;

	public Cronometro() {
		setTiempoSimulacion(0);
		this.hiloCronometro = new Thread(this);
		this.hiloCronometro.start();
	}
	
	public void run () {
		while (continuar == true) {
			try {
		      Thread.sleep (10);
		      this.tiempoSimulacion++;
	      }
	      catch (InterruptedException err) {
		      err.printStackTrace();
	      }
		}
	}
	
	//Getters and setters
	public int getTiempoSimulacion() {
		return tiempoSimulacion;
	}

	public void setTiempoSimulacion(int tiempoSimulacion) {
		this.tiempoSimulacion = tiempoSimulacion;
	}

	public boolean iscontinuar() {
		return continuar;
	}

	public void setcontinuar(boolean continuar) {
		this.continuar = continuar;
	}
	

	public void mostrarDatosCronometro() {
		System.out.println("El tiempo transcurrido es" + getTiempoSimulacion());
	}
	public void estadisticaInicializarCronometro() {
		//Implementame luego
	}
	public void estadisticaActualizarCronometro() {
		//Implementame luego
	}
	public void estadisticaObtenerCronometro() {
		//Implementame luego
	}
	
}
