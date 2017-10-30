package sistema;

import java.util.ArrayList;
import java.util.Random;

public class Implementaciones {

	private Random rand;
	
	public Implementaciones() {
		rand = new Random(System.currentTimeMillis());
	}
	//	For del 1 al 27 (Todos los ids de las materias)
	//	Creo dias y turnos randoms
	//	Creo un profesor random
	//	Creo una nueva materia y le asigno los dias, turnos y el profesor
	//	La agrego a la lista de materias
	public void primeraGeneracion(ArrayList<Materia> listaMaterias) {
		for(int i = 1; i <= 27;i++){
			
			int diaOpcion1 = (int)(1 + 5*rand.nextDouble());
			int turnoOpcion1 = (int)(1 + 2*rand.nextDouble());
			DiaTurno primeraOpcion = new DiaTurno(diaOpcion1, turnoOpcion1);
			int diaOpcion2 = (int)(1 + 5*rand.nextDouble());
			int turnoOpcion2 = (int)(1 + 2*rand.nextDouble());
			DiaTurno segundaOpcion = new DiaTurno(diaOpcion2, turnoOpcion2);
			int profesorRandom = (int)(1 + 20*rand.nextDouble());
			Materia materia = new Materia(i, primeraOpcion, segundaOpcion, profesorRandom);
			listaMaterias.add(materia);
		}
	}
	
	//Puntaje a la lista de materias segun las preferencias de los profesores
	public void fitness(ArrayList<Materia> listaMaterias, ArrayList<Profesor> listaProfesores) {
		for(Materia materia: listaMaterias) {
			int indiceProfesorMateriaActual = materia.getProfesorAsignado();
			Profesor profesorActual = listaProfesores.get(indiceProfesorMateriaActual);
			//Si la materia no esta dada por el profesor, se le asigna 0
			if(profesorActual.getMateriasProfesor().contains(materia.getId()) == false) {
				materia.setPuntaje(0);
			}
			else {
				int puntajeMateria = materia.getPuntaje();
				int suma = recorrerDiaTurno(materia, profesorActual) + puntajeMateria;
				materia.setPuntaje(suma);
			}
		}
	}
	
	public int recorrerDiaTurno(Materia materia, Profesor profesor) {
		int valor=0;
		for(DiaTurno diaTurnoProfesor: profesor.getDiasTurnosProfesor()) {
			if((materia.getBloque1().getDia() == diaTurnoProfesor.getDia()) && 
					(materia.getBloque1().getTurno() == diaTurnoProfesor.getTurno())) {
				valor = valor + 1;
			}
			if((materia.getBloque2().getDia() == diaTurnoProfesor.getDia()) && 
					(materia.getBloque2().getTurno() == diaTurnoProfesor.getTurno())) {
				valor = valor + 1;
			}
			
		}
		return valor;
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
	
	public void recorrer(ArrayList<Materia> listaMaterias) {
		for(Materia m: listaMaterias) {
			System.out.println(m.getProfesorAsignado());
		}
	}
	
}
