package sistema;

public class Sistema {
	public Cronometro cronometro;
	public Cola cola;
	public Thread hilo;
	public Servidor listaServidores[];
	
	public Sistema (double lambda, double mu, int cantServidores) {
		//falta implementar cola
		cola = new Cola (lambda);
		
		//falta implementar servidores
		listaServidores = new Servidor[cantServidores];
	}
	

	//Getters and Setters
	public Cronometro getCronometro() {
		return cronometro;
	}
	public void setCronometro(Cronometro cronometro) {
		this.cronometro = cronometro;
	}
	public Cola getCola() {
		return cola;
	}
	public void setCola(Cola cola) {
		this.cola = cola;
	}
	public Thread getHilo() {
		return hilo;
	}
	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}
	public Servidor[] getListaServidores() {
		return listaServidores;
	}
	public void setListaServidores(Servidor[] listaServidores) {
		this.listaServidores = listaServidores;
	}
	

}
