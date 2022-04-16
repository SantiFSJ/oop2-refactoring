package ar.unrn.eje3;

import java.util.List;

public class Gastos {
	private List<Gasto> listaGastos;

	public Gastos(List<Gasto> listaGastos) {
		this.listaGastos = listaGastos;
	}

	public StringBuffer informacionGastos() {
		StringBuffer informacionGastos = new StringBuffer();

		for (Gasto gasto : this.listaGastos) {
			String marcaExceso = gasto.existeExceso() ? "X" : " ";
			informacionGastos.append(gasto.nombre() + "\t" + gasto.monto + "\t" + marcaExceso + "\n");
		}
		return informacionGastos;
	}

	public int montoComidas() {
		int montoComidas = 0;
		for (Gasto gasto : this.listaGastos) {
			montoComidas = gasto.sumaMontoComida(montoComidas);
		}
		return montoComidas;
	}

	public int montoTotal() {
		int montoTotal = 0;
		for (Gasto gasto : this.listaGastos) {
			montoTotal += gasto.monto();
		}
		return montoTotal;
	}

}
