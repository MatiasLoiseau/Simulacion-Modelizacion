package sistema;

import java.util.ArrayList;

public class Individuo implements Comparable<Individuo>{

	ArrayList<Materia> listaMaterias;
	private int puntajeFitness;
	
	public Individuo() {
		ArrayList<Materia> listaMateriasNew = new ArrayList<Materia>();
		setListaMaterias(listaMateriasNew);
	}

	
	@Override
	public int compareTo(Individuo o) {
		// TODO Auto-generated method stub
		if(this.getPuntajeFitness() < o.getPuntajeFitness()) {
			return 1;
		}
		else if(this.getPuntajeFitness() == o.getPuntajeFitness()) {
			return 0;
		}
		else {
			return -1;
		}
		
	}
	
	public void mostrame() {
		System.out.println("El fitness del individuo es: " + this.getPuntajeFitness());
		for(Materia materia: this.getListaMaterias()) {
			System.out.println("La materia: " + materia.getId());
			System.out.println("El día: " + materia.getBloque1().getDia() + " turno: " + materia.getBloque1().getTurno()
					+ " tiene como profesor: " + materia.getProfesorAsignadoB1());
			System.out.println("El día: " + materia.getBloque2().getDia() + " turno: " + materia.getBloque2().getTurno()
					+ " tiene como profesor: " + materia.getProfesorAsignadoB2());
		}
	}
	
	/*public boolean esValida(ArrayList<Profesor> listaProfesores) {
		boolean individuoValido=true;
		for(Materia materiaActual: this.getListaMaterias()) {
			int idProfesorMateria = materiaActual.getProfesorAsignado();
			int idMateriaActual = materiaActual.getId(); 
			if(listaProfesores.get(idProfesorMateria - 1).getMateriasProfesor().contains(idMateriaActual)) {
				for(Materia materiaComparo: this.getListaMaterias()) {
					//Si el id es distinto y el profesor es el mismo me fijo:
					if((materiaActual.getId() != materiaComparo.getId()) && 
							(materiaActual.getProfesorAsignado() == materiaComparo.getProfesorAsignado())) {
						//Si la materia la da bloque1 es igual que el bloque2 de la materia comparo es falso
						if((materiaActual.getBloque1().getDia() == materiaComparo.getBloque1().getDia()) &&
								(materiaActual.getBloque1().getTurno() == materiaComparo.getBloque1().getTurno())){
							individuoValido = false;
						}
						//if((materiaActual.getBloque1().getDia() == materiaComparo.getBloque2().getDia()) &&
							//	(materiaActual.getBloque1().getTurno() == materiaComparo.getBloque2().getTurno())){
							//individuoValido = false;
						//}
						if((materiaActual.getBloque2().getDia() == materiaComparo.getBloque2().getDia()) &&
								(materiaActual.getBloque2().getTurno() == materiaComparo.getBloque2().getTurno())){
							individuoValido = false;
						}
						if((materiaActual.getBloque1().getDia() == materiaActual.getBloque2().getDia()) &&
								(materiaActual.getBloque1().getTurno() == materiaActual.getBloque2().getTurno())) {
							individuoValido = false;
						}
					}
				}
			}
			else {
				individuoValido = false;
			}
			
			
		}
		
		return individuoValido;
	}*/
	
	public boolean esValido() {
		boolean valido=true;
		for(Materia materiaActual: this.getListaMaterias()) {
			for(Materia materiaComparo: this.getListaMaterias()) {
				if(materiaActual.getId()!=materiaComparo.getId()) {
					//Mismo profesor en B1
					if(materiaActual.getProfesorAsignadoB1()==materiaComparo.getProfesorAsignadoB1()) {
						if(materiaActual.getBloque1().getDia()==materiaComparo.getBloque1().getDia()
								&& materiaActual.getBloque1().getTurno()==materiaComparo.getBloque1().getTurno()) {
							valido=false;
						}
					}
					//Mismo profesor en B2
					if(materiaActual.getProfesorAsignadoB2()==materiaComparo.getProfesorAsignadoB2()) {
						if(materiaActual.getBloque2().getDia()==materiaComparo.getBloque2().getDia()
								&& materiaActual.getBloque2().getTurno()==materiaComparo.getBloque2().getTurno()) {
							valido=false;
						}
					}
					//Mismos profesores en B1 y B2
					if(materiaActual.getProfesorAsignadoB1()==materiaComparo.getProfesorAsignadoB2()) {
						if(materiaActual.getBloque1().getDia()==materiaComparo.getBloque2().getDia()
								&& materiaActual.getBloque1().getTurno()==materiaComparo.getBloque2().getTurno()) {
							valido=false;
						}
					}
				}
				else {
					if(materiaActual.getBloque1().getDia()==materiaComparo.getBloque2().getDia()
							&& materiaActual.getBloque1().getTurno()==materiaComparo.getBloque2().getTurno()) {
						valido=false;
					}
				}
			}
		}
		
		return valido;
	}
	
	//Recorro mi lista de materias y devuelvo la suma de sus puntajes
	public int sumarFitnessMaterias() {
		int suma=0;
		for(Materia materiaActual: this.getListaMaterias()) {
			suma=suma+materiaActual.getPuntaje();
		}
		return suma;
	}
	
	
	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}

	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}

	public int getPuntajeFitness() {
		return puntajeFitness;
	}

	public void setPuntajeFitness(int puntajeFitness) {
		this.puntajeFitness = puntajeFitness;
	}
	
}
