package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Poblacion {
	private ArrayList<Individuo> poblacion;
	private Random rand;
	
	public Poblacion() {
		ArrayList<Individuo> poblacionNew = new ArrayList<Individuo>();
		setPoblacion(poblacionNew);
		rand = new Random(System.currentTimeMillis());
	}

	
	public void primeraGeneracion() {
		for(int x=0; x<500; x++) {
			Individuo individuo = new Individuo();
			for(int i = 1; i <= 27;i++){
				int diaOpcion1 = (int)(1 + 5*rand.nextDouble());
				int turnoOpcion1 = (int)(1 + 2*rand.nextDouble());
				DiaTurno primeraOpcion = new DiaTurno(diaOpcion1, turnoOpcion1);
				int diaOpcion2 = (int)(1 + 5*rand.nextDouble());
				int turnoOpcion2 = (int)(1 + 2*rand.nextDouble());
				DiaTurno segundaOpcion = new DiaTurno(diaOpcion2, turnoOpcion2);
				int profesorRandom = (int)(1 + 20*rand.nextDouble());
				Materia materia = new Materia(i, primeraOpcion, segundaOpcion, profesorRandom);
				individuo.getListaMaterias().add(materia);
			}
			this.getPoblacion().add(individuo);
		}
	}
	
	
	//Puntaje a la lista de materias segun las preferencias de los profesores
	public void fitness(ArrayList<Profesor> listaProfesores) {
		for(Individuo individuo: this.getPoblacion()) {
			int contadorPuntaje = 0;
			for(Materia materia: individuo.getListaMaterias()) {
				int indiceProfesorMateriaActual = materia.getProfesorAsignado();
				Profesor profesorActual = listaProfesores.get(indiceProfesorMateriaActual);
				//Si la materia no esta dada por el profesor, se le asigna 0
				if(profesorActual.getMateriasProfesor().contains(materia.getId()) == false) {
					materia.setPuntaje(0);
				}
				else {													//Es necesario el puntaje anterior ? Creo que no
					//int suma = recorrerDiaTurno(materia, profesorActual) + materia.getPuntaje();
					materia.setPuntaje(recorrerDiaTurno(materia, profesorActual));
				}
				contadorPuntaje = contadorPuntaje + materia.getPuntaje();
			}
			individuo.setPuntajeFitness(contadorPuntaje);
		}
	}
	
	public int recorrerDiaTurno(Materia materia, Profesor profesor) {
		int valor=0;
		for(DiaTurno diaTurnoProfesor: profesor.getDiasTurnosProfesor()) {
			if(materia.getBloque1().getDia() == diaTurnoProfesor.getDia()){
				valor = valor + 1;
				if(materia.getBloque1().getTurno() == diaTurnoProfesor.getTurno()) {
					valor = valor + 2;
					}
				}
			if(materia.getBloque2().getDia() == diaTurnoProfesor.getDia()){
				valor = valor + 1;
				if(materia.getBloque2().getTurno() == diaTurnoProfesor.getTurno()) {
					valor = valor + 2;
					}
				}
			} 
		return valor;
	}
	
	//	1 Ordeno la lista de materias segun el fitness de cada una
	//	2 La divido en 2
	//	3 Armo una lista nueva con la mejor mitad
	//	4 Agarro dos materias, las reproduzco, creo dos materias nuevas y las meto en la nueva lista
	//	5 Asi con las 10 mejores materias
	public void reproduccion() {
		Collections.sort(getPoblacion());
		for(int x=250; x<500; x++) {
			this.getPoblacion().remove(x);
		}
		for(int x=0; x<250; x=x+2) {
			Individuo individuo1 = this.getPoblacion().get(x);
			Individuo individuo2 = this.getPoblacion().get(x+1);
			reproducir(individuo1, individuo2);
		}
	}
	
	public void reproducir(Individuo individuo1, Individuo individuo2) {
		Individuo individuoHijo1 = new Individuo();
		Individuo individuoHijo2 = new Individuo();
		for(Materia materia: individuo1.getListaMaterias()) {
			if(materia.getPuntaje() == 0) {
				Materia materiaIndividuo2 = individuo2.getListaMaterias().get(materia.getId());
				Materia nuevaMateria1 = new Materia(materia.getId(), materiaIndividuo2.getBloque1(), 
						materiaIndividuo2.getBloque2(), materiaIndividuo2.getProfesorAsignado());
				individuoHijo1.getListaMaterias().add(nuevaMateria1);
			}
			else {
				Materia nuevaMateria2 = new Materia(materia.getId(), materia.getBloque1(), 
						materia.getBloque2(), materia.getProfesorAsignado());
				individuoHijo1.getListaMaterias().add(nuevaMateria2);
			}
		}
		for(Materia materia: individuo2.getListaMaterias()) {
			if(materia.getPuntaje() == 0) {
				Materia materiaIndividuo1 = individuo1.getListaMaterias().get(materia.getId());
				Materia nuevaMateria1 = new Materia(materia.getId(), materiaIndividuo1.getBloque1(), 
						materiaIndividuo1.getBloque2(), materiaIndividuo1.getProfesorAsignado());
				individuoHijo2.getListaMaterias().add(nuevaMateria1);
			}
			else {
				Materia nuevaMateria2 = new Materia(materia.getId(), materia.getBloque1(), 
						materia.getBloque2(), materia.getProfesorAsignado());
				individuoHijo2.getListaMaterias().add(nuevaMateria2);
			}
		}
	}
	
	public ArrayList<Individuo> getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(ArrayList<Individuo> poblacion) {
		this.poblacion = poblacion;
	}
	public Random getRand() {
		return rand;
	}
	public void setRand(Random rand) {
		this.rand = rand;
	}
	
}
