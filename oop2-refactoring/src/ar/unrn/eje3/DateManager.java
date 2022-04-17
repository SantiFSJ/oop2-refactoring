package ar.unrn.eje3;

import java.time.LocalDate;

public class DateManager implements ProveedorFecha {

	@Override
	public LocalDate obtenerFechaActual() {
		return LocalDate.now();
	}

}
