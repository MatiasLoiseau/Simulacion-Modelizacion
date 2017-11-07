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

	
	public void primeraGeneracion(ArrayList<Profesor> listaProfesores) {
		for(int x=0; x<500; x++) {
			Individuo individuo = new Individuo();
			for(int i = 1; i <= 27;i++){
				
				int diaOpcion1 = (1 + rand.nextInt(5));
				int turnoOpcion1 = (1 + rand.nextInt(2));
				DiaTurno primeraOpcion = new DiaTurno(diaOpcion1, turnoOpcion1);
				int diaOpcion2 = (1 + rand.nextInt(5));
				int turnoOpcion2 = (1 + rand.nextInt(2));
				DiaTurno segundaOpcion = new DiaTurno(diaOpcion2, turnoOpcion2);
				int profesorRandomB1 = (1 + rand.nextInt(20));
				int profesorRandomB2 = (1 + rand.nextInt(20));
				while(!listaProfesores.get(profesorRandomB1 - 1).getMateriasProfesor().contains(i)) {
					profesorRandomB1 = (1 + rand.nextInt(20));
				}
				while(!listaProfesores.get(profesorRandomB2 - 1).getMateriasProfesor().contains(i)) {
					profesorRandomB2 = (1 + rand.nextInt(20));
				}
				Materia materia = new Materia(i, primeraOpcion, segundaOpcion, profesorRandomB1, profesorRandomB2);
				individuo.getListaMaterias().add(materia);
			}
			this.getPoblacion().add(individuo);
		}
	}
	
	
	
	//Puntaje a la lista de materias segun las preferencias de los profesores
	public void fitness(ArrayList<Profesor> listaProfesores) {
		for(Individuo individuo: this.getPoblacion()) {
			int valorFitness=0;
			if(individuo.esValido()) {
				for(Materia materia: individuo.getListaMaterias()) {
					int indiceProfesorMateriaActualB1 = materia.getProfesorAsignadoB1();
					int indiceProfesorMateriaActualB2 = materia.getProfesorAsignadoB2();
					Profesor profesorActualB1 = listaProfesores.get(indiceProfesorMateriaActualB1 - 1);
					Profesor profesorActualB2 = listaProfesores.get(indiceProfesorMateriaActualB2 - 1);
					
					if(recorrerDiaTurnoB1(materia,profesorActualB1)) {
						valorFitness=valorFitness+1;
					}
					if(recorrerDiaTurnoB2(materia,profesorActualB2)) {
						valorFitness=valorFitness+1;
					}
				}
				individuo.setPuntajeFitness(valorFitness);
			}
			else {
				individuo.setPuntajeFitness(0);
			}
			
			//int valorFinal = individuo.sumarFitnessMaterias();
			
		}
		Collections.sort(getPoblacion());
	}
	
	public boolean recorrerDiaTurnoB1(Materia materia, Profesor profesor) {
		boolean profesorValido=false;
		for(DiaTurno diaTurnoProfesor: profesor.getDiasTurnosProfesor()) {
			if((materia.getBloque1().getDia() == diaTurnoProfesor.getDia()) && 
					(materia.getBloque1().getTurno() == diaTurnoProfesor.getTurno())) {
				profesorValido=true;
			}
		}
		return profesorValido;
	}
	public boolean recorrerDiaTurnoB2(Materia materia, Profesor profesor) {
		boolean profesorValido=false;
		for(DiaTurno diaTurnoProfesor: profesor.getDiasTurnosProfesor()) {
			if((materia.getBloque2().getDia() == diaTurnoProfesor.getDia()) && 
					(materia.getBloque2().getTurno() == diaTurnoProfesor.getTurno())) {
				profesorValido=true;
			}
		}
		return profesorValido;
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
	
	public void fitnessZero() {
		for(Individuo individuo: this.getPoblacion()) {
			for(Materia materia: individuo.getListaMaterias()) {
				materia.setPuntaje(0);
			}
			individuo.setPuntajeFitness(0);
		}
	}
	
	//	1 Ordeno la lista de materias segun el fitness de cada una
	//	2 La divido en 2
	//	3 Armo una lista nueva con la mejor mitad
	//	4 Agarro dos materias, las reproduzco, creo dos materias nuevas y las meto en la nueva lista
	//	5 Asi con las 10 mejores materias
	public void reproduccion() {
		for(int x=0; x<250; x++) {
			this.getPoblacion().remove(250);
		}
		//Nose porque no anda la funcion de abajo
		//this.getPoblacion().removeRange(250,499);
		/*for(int x=0; x<250; x++) {
			int indiceIndividuoAzar1 = (int)(250*rand.nextDouble());
			int indiceIndividuoAzar2 = (int)(250*rand.nextDouble());
			Individuo individuo1 = this.getPoblacion().get(indiceIndividuoAzar1);
			Individuo individuo2 = this.getPoblacion().get(indiceIndividuoAzar2);
			reproducir(individuo1, individuo2);
		}
		 * 
		 * 
		 */
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
				Materia materiaIndividuo2 = individuo2.getListaMaterias().get(materia.getId() - 1);
				Materia nuevaMateria1 = new Materia(materia.getId(), materiaIndividuo2.getBloque1(), 
						materiaIndividuo2.getBloque2(), materiaIndividuo2.getProfesorAsignadoB1(), 
						materiaIndividuo2.getProfesorAsignadoB2());
				individuoHijo1.getListaMaterias().add(nuevaMateria1);
			}
			else {
				Materia nuevaMateria2 = new Materia(materia.getId(), materia.getBloque1(), 
						materia.getBloque2(), materia.getProfesorAsignadoB1(), materia.getProfesorAsignadoB2());
				individuoHijo1.getListaMaterias().add(nuevaMateria2);
			}
		}
		for(Materia materia: individuo2.getListaMaterias()) {
			if(materia.getPuntaje() == 0) {
				Materia materiaIndividuo1 = individuo1.getListaMaterias().get(materia.getId() - 1);
				Materia nuevaMateria1 = new Materia(materia.getId(), materiaIndividuo1.getBloque1(), 
						materiaIndividuo1.getBloque2(), materiaIndividuo1.getProfesorAsignadoB1(),
						materiaIndividuo1.getProfesorAsignadoB2());
				individuoHijo2.getListaMaterias().add(nuevaMateria1);
			}
			else {
				Materia nuevaMateria2 = new Materia(materia.getId(), materia.getBloque1(), 
						materia.getBloque2(), materia.getProfesorAsignadoB1(), materia.getProfesorAsignadoB2());
				individuoHijo2.getListaMaterias().add(nuevaMateria2);
			}
		}
		this.getPoblacion().add(individuoHijo1);
		this.getPoblacion().add(individuoHijo2);
	}
	
	
	public void mutacion(ArrayList<Profesor> listaProfesores) {
		for(int x=0; x<100; x++) {
			int individuoAzar = (int)(rand.nextInt(500));
			for(Materia materia: this.getPoblacion().get(individuoAzar).getListaMaterias()) {
				asignarParametrosRandom(materia, listaProfesores);
			}
			
			//asignarParametrosRandom(this.getPoblacion().get(individuoAzar).getListaMaterias().get(materiaCualquiera));
		}
		
	}
	
	public void asignarParametrosRandom(Materia materia, ArrayList<Profesor> listaProfesores) {
		int diaOpcion1 = (1 + rand.nextInt(5));
		int turnoOpcion1 = (1 + rand.nextInt(2));
		DiaTurno primeraOpcion = new DiaTurno(diaOpcion1, turnoOpcion1);
		int diaOpcion2 = (1 + rand.nextInt(5));
		int turnoOpcion2 = (1 + rand.nextInt(2));
		DiaTurno segundaOpcion = new DiaTurno(diaOpcion2, turnoOpcion2);
		int profesorRandomB1 = (1 + rand.nextInt(20));
		int profesorRandomB2 = (1 + rand.nextInt(20));
		while(!listaProfesores.get(profesorRandomB1 - 1).getMateriasProfesor().contains(materia.getId())) {
			profesorRandomB1 = (1 + rand.nextInt(20));
		}
		while(!listaProfesores.get(profesorRandomB2 - 1).getMateriasProfesor().contains(materia.getId())) {
			profesorRandomB2 = (1 + rand.nextInt(20));
		}
		materia.setBloque1(primeraOpcion);
		materia.setBloque2(segundaOpcion);
		materia.setProfesorAsignadoB1(profesorRandomB1);
		materia.setProfesorAsignadoB2(profesorRandomB2);
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
