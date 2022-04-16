package arj.unrn.eje3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.unrn.eje3.Gasto;
import ar.unrn.eje3.GastoAlquilerAuto;
import ar.unrn.eje3.GastoCena;
import ar.unrn.eje3.GastoDesayuno;
import ar.unrn.eje3.ReporteDeGastos;

public class testEjer3 {
	@Test
	public void testMontoTotalComida() {
		// Set Up
		GastoCena gasto1 = new GastoCena(750);
		GastoAlquilerAuto gasto2 = new GastoAlquilerAuto(2000);
		GastoDesayuno gasto3 = new GastoDesayuno(200);

		ArrayList<Gasto> listaGastos = new ArrayList<Gasto>();
		listaGastos.add(gasto1);
		listaGastos.add(gasto2);
		listaGastos.add(gasto3);

		// Ejercitacion
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos);

		// Verificacion
		assertEquals(950, reporte.montoTotalComida());

	}

	@Test
	public void testMontoTotal() {
		// Set Up
		GastoCena gasto1 = new GastoCena(750);
		GastoAlquilerAuto gasto2 = new GastoAlquilerAuto(2000);
		GastoDesayuno gasto3 = new GastoDesayuno(200);

		ArrayList<Gasto> listaGastos = new ArrayList<Gasto>();
		listaGastos.add(gasto1);
		listaGastos.add(gasto2);
		listaGastos.add(gasto3);

		// Ejercitacion
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos);

		// Verificacion
		assertEquals(2950, reporte.montoTotalGastos());

	}

	@Test
	public void testMostrarInformacionCompleta() {
		// Set Up
		GastoCena gasto1 = new GastoCena(750);
		GastoAlquilerAuto gasto2 = new GastoAlquilerAuto(2000);
		GastoDesayuno gasto3 = new GastoDesayuno(200);

		ArrayList<Gasto> listaGastos = new ArrayList<Gasto>();
		listaGastos.add(gasto1);
		listaGastos.add(gasto2);
		listaGastos.add(gasto3);

		// Ejercitacion
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos);

		// Verificacion
		System.out.println(reporte.informacionCompleta());
		StringBuffer infoEsperada = new StringBuffer();
		infoEsperada.append("Expenses " + LocalDate.now() + "\n");
		infoEsperada.append("Cena	750\nAlquiler	2000\nDesayuno	200\n");
		infoEsperada.append("Gastos de comida: " + reporte.montoTotalComida() + "\n");
		infoEsperada.append("Total de gastos: " + reporte.montoTotalGastos() + "\n");

		assertEquals(infoEsperada, reporte.informacionCompleta());

	}
}
