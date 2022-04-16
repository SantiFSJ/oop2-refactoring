package ar.unrn.eje2;

import java.io.IOException;
import java.util.List;

public interface Datos {

	List<String[]> leerArchivo() throws IOException;
}
