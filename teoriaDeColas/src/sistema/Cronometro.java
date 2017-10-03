package sistema;

//Tiene que ser  implements runnable segun Agus
public class Cronometro{
	
	//Variables
	public int tiempoSimulacion;
	
	//Getters and setters
	public int getTiempoSimulacion() {
		return tiempoSimulacion;
	}

	public void setTiempoSimulacion(int tiempoSimulacion) {
		this.tiempoSimulacion = tiempoSimulacion;
	}

	//funciones
	public void inicializacion() {
		setTiempoSimulacion(0);
	}
	public void iterador() {
		//Thread.sleep(1)
		//Si no esta frenado tiene que sumar el tiempo. 1 o 0 ?
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
