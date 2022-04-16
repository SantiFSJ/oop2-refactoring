package ar.unrn.eje1;

import java.util.ArrayList;

public class Alquileres {
	public ArrayList<Alquiler> alquileres;

	public Alquileres() {
		alquileres = new ArrayList<Alquiler>();
	}

	public void añadir(Alquiler alquiler) {
		alquileres.add(alquiler);
	}

	public ArrayList<Alquiler> alquileres() {
		return alquileres;
	}
}
