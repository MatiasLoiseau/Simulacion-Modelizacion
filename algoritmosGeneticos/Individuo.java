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
