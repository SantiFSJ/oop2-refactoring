package ar.unrn.eje1;

public class LibroNuevoLanzamiento extends Libro {

	public LibroNuevoLanzamiento(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularDeuda(int cantidadDeDias) {
		double monto = cantidadDeDias * 3;
		return monto;
	}

	@Override
	public int calcularPuntaje(int diasAlquilados) {
		if (diasAlquilados > 1)
			return 2;
		return 1;
	}

}
