package ar.unrn.eje3;

public class GastoCena extends Gasto {

	public GastoCena(int monto) {
		super(monto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String nombre() {
		return "Cena";
	}

	@Override
	public int sumaMontoComida(int monto) {
		return monto + this.monto;
	}

	@Override
	public Boolean existeExceso() {
		if (this.monto > 5000)
			return true;
		return false;
	}
}
