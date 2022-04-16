package ar.unrn.eje3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
	private Gastos gastos;

	public ReporteDeGastos(List<Gasto> gastos) {
		this.gastos = new Gastos(gastos);
	}

	public int montoTotalComida() {
		return gastos.montoComidas();
	}

	public int montoTotalGastos() {
		return gastos.montoTotal();
	}

	public StringBuffer informacionCompleta() {
		StringBuffer reporte = new StringBuffer();

		reporte.append("Expenses " + LocalDate.now() + "\n");
		reporte.append(this.gastos.informacionGastos() + "\n");
		reporte.append("Gastos de comida: " + this.gastos.montoComidas() + "\n");
		reporte.append("Total de gastos: " + this.gastos.montoTotal() + "\n");

		return reporte;
	}

}
