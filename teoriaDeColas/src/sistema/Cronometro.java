package sistema;

//Tiene que ser  implements runnable segun Agus
public class Cronometro implements Runnable{
	
	//Variables
	public int tiempoSimulacion;
	public boolean continuar=true;

	public Cronometro() {
		inicializacion();
	}
	
	public void iterarCronometro () {
		while (!continuar) {
			try {
		      Thread.sleep (1);
		      tiempoSimulacion++;
	      }
	      catch (InterruptedException err) {
		      err.printStackTrace();
	      }
		}
	}
	
	public void run () {
		iterarCronometro ();
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
	
	//funciones
	public void inicializacion() {
		setTiempoSimulacion(0);
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
