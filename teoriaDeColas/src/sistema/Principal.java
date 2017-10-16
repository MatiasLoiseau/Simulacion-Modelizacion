package sistema;

public class Principal {
	
	public static Sistema sistema;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lambda = 1;
		long mu = 2;
		int cantServidores = 1;
		int cantClientes = 20;
		
		sistema = new Sistema (lambda, mu, cantServidores, cantClientes);
		

	}

	public Principal() {
		
	}
	
}
