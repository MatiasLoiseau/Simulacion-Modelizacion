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
			System.out.println("La materia: " + materia.getId() + " tiene como profesor: " + materia.getProfesorAsignado());
			System.out.println("El día: " + materia.getBloque1().getDia() + " turno: " + materia.getBloque1().getTurno());
			System.out.println("El día: " + materia.getBloque2().getDia() + " turno: " + materia.getBloque2().getTurno());
		}
	}
	
	//NO VALIDA ENTRE BLOQUES, EL BLOQUE1 PUEDE SER IGUAL AL BLOQUE 2
	public boolean esValida() {
		boolean individuoValido=true;
		for(Materia materiaActual: this.getListaMaterias()) {
			for(Materia materiaComparo: this.getListaMaterias()) {
				if((materiaActual.getId() != materiaComparo.getId()) && 
						(materiaActual.getProfesorAsignado() == materiaComparo.getProfesorAsignado())) {
					if((materiaActual.getBloque1().getDia() == materiaComparo.getBloque1().getDia()) &&
							(materiaActual.getBloque1().getTurno() == materiaComparo.getBloque1().getTurno())){
						//System.out.println("Fallo en dia: " + materiaActual.getBloque1().getDia());
						//System.out.println("Fallo en turno: " + materiaActual.getBloque1().getTurno());
						individuoValido = false;
					}
					if((materiaActual.getBloque2().getDia() == materiaComparo.getBloque2().getDia()) &&
							(materiaActual.getBloque2().getTurno() == materiaComparo.getBloque2().getTurno())){
						//System.out.println("Fallo en dia: " + materiaActual.getBloque2().getDia());
						//System.out.println("Fallo en turno: " + materiaActual.getBloque2().getTurno());
						individuoValido = false;
					}
				}
			}
		}
		
		return individuoValido;
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
