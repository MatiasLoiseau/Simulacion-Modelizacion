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
	


}
