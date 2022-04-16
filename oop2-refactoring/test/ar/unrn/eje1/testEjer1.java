package ar.unrn.eje1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unrn.eje1.Cliente;
import ar.unrn.eje1.LibroInfantil;
import ar.unrn.eje1.LibroNuevoLanzamiento;
import ar.unrn.eje1.LibroRegular;

public class testEjer1 {
	@Test
	public void alquilerLibroRegular() {
		// Set Up
		LibroRegular elHobbit = new ar.unrn.eje1.LibroRegular("El Hobbit");
		Cliente yo = new Cliente("Santiago");

		// Ejercitacion
		yo.alquilar(elHobbit, 4);

		// Verificacion
		Double rtadoObtenido = yo.obtenerDeuda();
		assertEquals(5.0, rtadoObtenido);

	}

	@Test
	public void alquilerLibroRegularPorUnDia() {
		// Set Up
		LibroRegular elHobbit = new LibroRegular("El Hobbit");
		Cliente yo = new Cliente("Santiago");

		// Ejercitacion
		yo.alquilar(elHobbit, 1);

		// Verificacion
		Double rtadoObtenido = yo.obtenerDeuda();
		assertEquals(2.0, rtadoObtenido);

	}

	@Test
	public void alquilerLibroInfantilPorUnDia() {
		// Set Up
		LibroInfantil elHobbit = new LibroInfantil("El Hobbit");
		Cliente yo = new Cliente("Santiago");

		// Ejercitacion
		yo.alquilar(elHobbit, 1);

		// Verificacion
		Double rtadoObtenido = yo.obtenerDeuda();
		assertEquals(1.5, rtadoObtenido);

	}

	@Test
	public void alquilerLibroInfantil() {
		// Set Up
		LibroInfantil elHobbit = new LibroInfantil("El Hobbit");
		Cliente yo = new Cliente("Santiago");

		// Ejercitacion
		yo.alquilar(elHobbit, 4);

		// Verificacion
		Double rtadoObtenido = yo.obtenerDeuda();
		assertEquals(3.0, rtadoObtenido);

	}

	@Test
	public void alquilerLibroNuevo() {
		// Set Up
		LibroNuevoLanzamiento elHobbit = new LibroNuevoLanzamiento("El Hobbit");
		Cliente yo = new Cliente("Santiago");

		// Ejercitacion
		yo.alquilar(elHobbit, 4);

		// Verificacion
		Double rtadoObtenido = yo.obtenerDeuda();
		assertEquals(12.0, rtadoObtenido);

	}

}
