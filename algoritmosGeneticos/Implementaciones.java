package sistema;

import java.util.ArrayList;
import java.util.Random;

public class Implementaciones {

	private Random rand;
	
	public Implementaciones() {
		rand = new Random(System.currentTimeMillis());
	}	
	public void primeraGeneracion(ArrayList<Materia> listaMaterias) {
		for(int i = 1; i <= 27;i++){
			
			int diaOpcion1 = (int)(1 + 5*rand.nextDouble());
			int turnoOpcion1 = (int)(1 + 2*rand.nextDouble());
			DiaTurno primeraOpcion = new DiaTurno(diaOpcion1, turnoOpcion1);
			int diaOpcion2 = (int)(1 + 5*rand.nextDouble());
			int turnoOpcion2 = (int)(1 + 2*rand.nextDouble());
			DiaTurno segundaOpcion = new DiaTurno(diaOpcion2, turnoOpcion2);
			int profesorRandom = (int)(1 + 20*rand.nextDouble());
			//Creo la materia con valores randoms
			Materia materia = new Materia(i, primeraOpcion, segundaOpcion, profesorRandom);
			//Agrego la materia a la lista
			listaMaterias.add(materia);
		}
	}
	
	//Puntaje a la lista de materias segun las preferencias de los profesores
	public void fitness(ArrayList<Materia> listaMaterias, ArrayList<Profesor> listaProfesores) {
		
	}
	//	1 Ordeno la lista de materias segun el fitness de cada una
	//	2 La divido en 2
	//	3 Armo una lista nueva con la mejor mitad
	//	4 Agarro dos materias, las reproduzco, creo dos materias nuevas y las meto en la nueva lista
	//	5 Asi con las 10 mejores materias
	public void reproduccion(ArrayList<Materia> listaMaterias, ArrayList<Profesor> listaProfesores) {
		
	}
	//	1 Agarro 5 materias al azar y las muto
	public void mutacion(ArrayList<Materia> listaMaterias) {
		
	}
	
}
