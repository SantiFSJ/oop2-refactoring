package ar.unrn.eje1;

public class Main {
	public static void main(String args[]) {
		Libro elTunel = new Libro("El Túnel");
		Libro antesDelFin = new Libro("Antes del Fin");

		Cliente yo = new Cliente("Javier");
		yo.alquilar(elTunel, 5);
		yo.alquilar(antesDelFin, 3);
		double resultado = yo.obtenerDeuda();
		int puntaje = yo.obtenerPuntosObtenidos();

		System.out.println(resultado);
		System.out.println(puntaje);
	}
}