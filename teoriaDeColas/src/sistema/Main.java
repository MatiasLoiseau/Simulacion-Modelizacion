package sistema;

public class Main {
	
	public static Sistema sistema;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double lambda = 1;
		double mu = 2;
		int cantServidores = 1;
		int cantClientes = 100;
		
		sistema = new Sistema (lambda, mu, cantServidores);
		
		sistema.getCola().setClientes(cantClientes, sistema.getCronometro());
		
		//Empieza el hilo
		sistema.getHilo().start();
	}

	public Main() {
		
	}
	
}
