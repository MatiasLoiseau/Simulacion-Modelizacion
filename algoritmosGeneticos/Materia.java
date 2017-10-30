package sistema;

public class Materia {
	private int id;
	private String nombre;
	private DiaTurno bloque1;
	private DiaTurno bloque2;
	private int profesorAsignado;
	private int puntaje;
	

	public Materia(int id, DiaTurno b1, DiaTurno b2, int profesor) {
		setId(id);
		setBloque1(b1);
		setBloque2(b2);
		setProfesorAsignado(profesor);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProfesorAsignado() {
		return profesorAsignado;
	}
	public void setProfesorAsignado(int profesor) {
		this.profesorAsignado = profesor;
	}
	public DiaTurno getBloque1() {
		return bloque1;
	}
	public void setBloque1(DiaTurno bloque1) {
		this.bloque1 = bloque1;
	}
	public DiaTurno getBloque2() {
		return bloque2;
	}
	public void setBloque2(DiaTurno bloque2) {
		this.bloque2 = bloque2;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}
