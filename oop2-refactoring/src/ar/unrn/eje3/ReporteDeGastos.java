package ar.unrn.eje3;

import java.util.List;

public class ReporteDeGastos {
	private Gastos gastos;
	private ProveedorFecha gestorFecha;

	public ReporteDeGastos(List<Gasto> gastos, ProveedorFecha gestorFecha) {
		this.gastos = new Gastos(gastos);
		this.gestorFecha = gestorFecha;
	}

	public int montoTotalComida() {
		return gastos.montoComidas();
	}

	public int montoTotalGastos() {
		return gastos.montoTotal();
	}

	public StringBuffer informacionCompleta() {
		StringBuffer reporte = new StringBuffer();

		reporte.append("Expenses " + this.gestorFecha.obtenerFechaActual() + "\n");
		reporte.append(this.gastos.informacionGastos() + "\n");
		reporte.append("Gastos de comida: " + this.gastos.montoComidas() + "\n");
		reporte.append("Total de gastos: " + this.gastos.montoTotal() + "\n");

		return reporte;
	}

}
