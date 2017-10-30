package sistema;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
		
		
		ArrayList<DiaTurno> diasTurnosKiper = new ArrayList<DiaTurno>();
		DiaTurno DiaTurno1Kipper = new DiaTurno(1,2);
		DiaTurno DiaTurno2Kipper = new DiaTurno(2,2);
		DiaTurno DiaTurno3Kipper = new DiaTurno(3,2);
		DiaTurno DiaTurno4Kipper = new DiaTurno(4,2);
		DiaTurno DiaTurno5Kipper = new DiaTurno(5,2);
		DiaTurno DiaTurno6Kipper = new DiaTurno(1,1);
		DiaTurno DiaTurno7Kipper = new DiaTurno(2,1);
		DiaTurno DiaTurno8Kipper = new DiaTurno(3,1);
		DiaTurno DiaTurno9Kipper = new DiaTurno(4,1);
		DiaTurno DiaTurno10Kipper = new DiaTurno(5,1);
		diasTurnosKiper.add(DiaTurno1Kipper);
		diasTurnosKiper.add(DiaTurno2Kipper);
		diasTurnosKiper.add(DiaTurno3Kipper);
		diasTurnosKiper.add(DiaTurno4Kipper);
		diasTurnosKiper.add(DiaTurno5Kipper);
		diasTurnosKiper.add(DiaTurno6Kipper);
		diasTurnosKiper.add(DiaTurno7Kipper);
		diasTurnosKiper.add(DiaTurno8Kipper);
		diasTurnosKiper.add(DiaTurno9Kipper);
		diasTurnosKiper.add(DiaTurno10Kipper);
		ArrayList<Integer> materiasKiper = new ArrayList<Integer>();
		materiasKiper.add(15);
		materiasKiper.add(16);
		materiasKiper.add(17);
		materiasKiper.add(18);
		Profesor kiper = new Profesor(1, "Kipper",diasTurnosKiper, materiasKiper);
		listaProfesores.add(kiper);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosMiguel = new ArrayList<DiaTurno>();
		DiaTurno DiaTurno1Miguel = new DiaTurno(3,2);
		DiaTurno DiaTurno2Miguel = new DiaTurno(3,1);
		DiaTurno DiaTurno3Miguel = new DiaTurno(5,2);
		DiaTurno DiaTurno4Miguel = new DiaTurno(1,1);
		DiaTurno DiaTurno5Miguel = new DiaTurno(2,1);
		diasTurnosMiguel.add(DiaTurno1Miguel);
		diasTurnosMiguel.add(DiaTurno2Miguel);
		diasTurnosMiguel.add(DiaTurno3Miguel);
		diasTurnosMiguel.add(DiaTurno4Miguel);
		diasTurnosMiguel.add(DiaTurno5Miguel);
		ArrayList<Integer> materiasMiguel = new ArrayList<Integer>();
		materiasMiguel.add(25);
		materiasMiguel.add(3);
		materiasMiguel.add(4);
		materiasMiguel.add(9);
		materiasMiguel.add(5);
		Profesor miguel = new Profesor(2, "Miguel",diasTurnosMiguel, materiasMiguel);
		listaProfesores.add(miguel);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosDubinsky = new ArrayList<DiaTurno>();
		DiaTurno diaTurno1Dubinsky = new DiaTurno(1,2);
		DiaTurno diaTurno2Dubinsky = new DiaTurno(2,2);
		DiaTurno diaTurno3Dubinsky = new DiaTurno(3,2);
		DiaTurno diaTurno4Dubinsky = new DiaTurno(4,2);
		DiaTurno diaTurno5Dubinsky = new DiaTurno(5,2);
		DiaTurno diaTurno6Dubinsky = new DiaTurno(1,1);
		DiaTurno diaTurno7Dubinsky = new DiaTurno(2,1);
		DiaTurno diaTurno8Dubinsky = new DiaTurno(3,1);
		DiaTurno diaTurno9Dubinsky = new DiaTurno(4,1);
		DiaTurno diaTurno10Dubinsky = new DiaTurno(5,1);
		diasTurnosDubinsky.add(diaTurno1Dubinsky);
		diasTurnosDubinsky.add(diaTurno2Dubinsky);
		diasTurnosDubinsky.add(diaTurno3Dubinsky);
		diasTurnosDubinsky.add(diaTurno4Dubinsky);
		diasTurnosDubinsky.add(diaTurno5Dubinsky);
		diasTurnosDubinsky.add(diaTurno6Dubinsky);
		diasTurnosDubinsky.add(diaTurno7Dubinsky);
		diasTurnosDubinsky.add(diaTurno8Dubinsky);
		diasTurnosDubinsky.add(diaTurno9Dubinsky);
		diasTurnosDubinsky.add(diaTurno10Dubinsky);
		ArrayList<Integer> materiasDubinsky = new ArrayList<Integer>();
		materiasDubinsky.add(5);
		materiasDubinsky.add(6);
		materiasDubinsky.add(7);
		materiasDubinsky.add(8);
		Profesor dubinsky = new Profesor(3, "Dubinskyr",diasTurnosDubinsky, materiasDubinsky);
		listaProfesores.add(dubinsky);
		/////////////////////////////////////////////////////////////////////////////
		ArrayList<DiaTurno> diasTurnosLagostena = new ArrayList<DiaTurno>();
		DiaTurno diaTurno1Lagostena = new DiaTurno(1,1);
		DiaTurno diaTurno2Lagostena = new DiaTurno(2,1);
		DiaTurno diaTurno3Lagostena = new DiaTurno(3,1);
		DiaTurno diaTurno4Lagostena = new DiaTurno(4,1);
		DiaTurno diaTurno5Lagostena = new DiaTurno(5,1);
		diasTurnosLagostena.add(diaTurno1Lagostena);
		diasTurnosLagostena.add(diaTurno2Lagostena);
		diasTurnosLagostena.add(diaTurno3Lagostena);
		diasTurnosLagostena.add(diaTurno4Lagostena);
		diasTurnosLagostena.add(diaTurno5Lagostena);
		ArrayList<Integer> materiasLagostena = new ArrayList<Integer>();
		materiasLagostena.add(26);
		Profesor lagostena = new Profesor(4, "Lagostena",diasTurnosLagostena, materiasLagostena);
		listaProfesores.add(lagostena);
		/////////////////////////////////////////////////////////////////////////////
		//otros profes
	
		
		ArrayList<Materia> listaPosiblesMaterias = new ArrayList<Materia>();
		
		Implementaciones funciones = new Implementaciones();
		
		funciones.primeraGeneracion(listaPosiblesMaterias);
		
		int puntaje = 0;
		//primera generacion
		while(puntaje<90) {
			//for de la posible lista de materias
			//calcular el fitness
			//si el fitness es alto salir con break ? ?? ?
			//reproducir
			//mutar
		}
	}

}
