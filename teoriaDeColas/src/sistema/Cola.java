package sistema;

import java.util.ArrayList;

public class Cola {
	public double lambda;
	public int cantClientes;
	public double tiempoLlegadaUltimoCliente;
	public double tiempoLlegadaProximoCliente;
	private ArrayList<Cliente> listaClientes  = new ArrayList<Cliente>();
	
	public Cola (double lambda) {
		this.lambda = lambda;
	}
	
	public void iterador() {
		
	}
	
	public void setClientes (int n, Cronometro cron) {
		double tiempoCronometroActual = cron.getTiempoSimulacion ();
		for (int i=0; i<n; i++) {
			tiempoLlegadaUltimoCliente = tiempoCronometroActual;
			//implementar Cliente
			//listaClientes.add(new Cliente (tiempoLlegadaUltimoCliente));
		}
	}
	
}
