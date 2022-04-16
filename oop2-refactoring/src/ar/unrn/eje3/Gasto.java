package ar.unrn.eje3;

public abstract class Gasto {
	protected int monto;

	public Gasto(int monto) {
		this.monto = monto;
	}

	public String nombre() {
		return "";
	}

	public int sumaMontoComida(int monto) {
		return monto + 0;
	}

	public Boolean existeExceso() {
		return false;
	}

	public int monto() {
		return this.monto;
	}

}