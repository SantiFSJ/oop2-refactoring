package ar.unrn.eje1;

public class LibroRegular extends Libro {

	public LibroRegular(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularDeuda(int cantidadDeDias) {
		double monto = 0.0;
		monto += 2;
		if (cantidadDeDias > 2)
			monto += (cantidadDeDias - 2) * 1.5;
		return monto;
	}

	@Override
	public int calcularPuntaje(int diasAlquilados) {

		return 1;
	}

}
