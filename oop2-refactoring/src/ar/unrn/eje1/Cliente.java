package ar.unrn.eje1;

public class Cliente {
	private Alquileres alquileres;// Cambio la coleccion por una clase que la contenga, Regla 4
	private String name;

	public Cliente(String nombre) {
		alquileres = new Alquileres();
		this.name = nombre;
	}

	public double obtenerDeuda() {// divido el metodo y reformulo la logica, Cambios por la Regla 5, Regla 1, y
									// Regla 9
		double total = 0;
		for (Alquiler alquiler : alquileres.alquileres()) {
			total += alquiler.calcularMonto();
		}
		return total;
	}

	public int obtenerPuntosObtenidos() {// divido el metodo y reformulo la logica, Cambios por la Regla 5, Regla 1, y
											// Regla 9
		int puntos = 0;
		for (Alquiler alquiler : alquileres.alquileres()) {
			puntos += alquiler.calcularPuntaje();
		}
		return 0;
	}

	public void alquilar(Libro libro, int cantidadDeDias) {// Regla 4
		Alquiler alquiler = new Alquiler(libro, cantidadDeDias);
		alquileres.añadir(alquiler);
	}
}