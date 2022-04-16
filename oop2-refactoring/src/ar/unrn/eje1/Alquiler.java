package ar.unrn.eje1;

public class Alquiler {
	private Libro libro;
	private int diasAlquilados;

	public Alquiler(Libro copia, int diasAlquilados) {
		this.libro = copia;
		this.diasAlquilados = diasAlquilados;

	}

	public int diasAlquilados() {
		return this.diasAlquilados;

	}

	public Double calcularMonto() {
		return this.libro.calcularDeuda(this.diasAlquilados);
	}

	public int calcularPuntaje() {
		return this.libro.calcularPuntaje(this.diasAlquilados);
	}

	public Libro copia() {
		return this.libro;

	}
}