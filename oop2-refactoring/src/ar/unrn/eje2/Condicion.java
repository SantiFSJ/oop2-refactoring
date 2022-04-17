package ar.unrn.eje2;

import java.util.List;
import java.util.Map;

public interface Condicion {
	boolean esIgual(int columna, List<String[]> csvData, Map<String, String> options);
}
