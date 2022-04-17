package arj.unrn.eje3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.unrn.eje3.DateManager;
import ar.unrn.eje3.Gasto;
import ar.unrn.eje3.GastoAlquilerAuto;
import ar.unrn.eje3.GastoCena;
import ar.unrn.eje3.GastoDesayuno;
import ar.unrn.eje3.ReporteDeGastos;

public class testEjer3 {

	DateManager gestorFecha = new DateManager();

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
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, gestorFecha);

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
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, gestorFecha);

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
		ReporteDeGastos reporte = new ReporteDeGastos(listaGastos, gestorFecha);

		// Verificacion
		System.out.println(reporte.informacionCompleta().toString());
		String infoEsperada = "Expenses 2022-04-17" + "Cena	750	 " + "Alquiler	2000	 " + "Desayuno	200	 " + ""
				+ "Gastos de comida: 950" + "Total de gastos: 2950";
		// System.out.println(infoEsperada);
		assertEquals(infoEsperada, reporte.informacionCompleta().toString());

	}
}
