package ar.unrn.eje1;

public class LibroInfantil extends Libro {

	public LibroInfantil(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularDeuda(int cantidadDeDias) {
		double monto = 0.0;
		monto += 1.5;
		if (cantidadDeDias > 3)
			monto += (cantidadDeDias - 3) * 1.5;
		return monto;
	}

	@Override
	public int calcularPuntaje(int diasAlquilados) {
		return 1;
	}

}
