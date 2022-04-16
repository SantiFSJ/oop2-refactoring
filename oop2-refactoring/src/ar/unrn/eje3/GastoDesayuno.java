package ar.unrn.eje3;

public class GastoDesayuno extends Gasto {

	public GastoDesayuno(int monto) {
		super(monto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String nombre() {
		return "Desayuno";
	}

	@Override
	public int sumaMontoComida(int monto) {
		return monto + this.monto;
	}

	@Override
	public Boolean existeExceso() {
		if (this.monto > 1000)
			return true;
		return false;
	}
}
