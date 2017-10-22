package sistema;

public class Principal {
	
	public static Sistema sistema;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double lambda = 0.9;
		double mu = 0.1;
		int cantServidores = 1;
		
		sistema = new Sistema (lambda, mu, cantServidores);
		

	}

	public Principal() {
		
	}
	
}
