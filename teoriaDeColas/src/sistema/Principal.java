package sistema;

public class Principal {
	
	public static Sistema sistema;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double lambda = 0.5;
		double mu = 0.6;
		int cantServidores = 1;
		int cantClientes = 1000;
		
		sistema = new Sistema (lambda, mu, cantServidores, cantClientes);
		

	}

	public Principal() {
		
	}
	
}
