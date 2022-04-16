package ar.unrn.eje2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {

	public static Datos datos;

	public Recaudacion(Datos datos) {
		this.datos = datos;
	}

	public List<Map<String, String>> where(Map<String, String> options) throws IOException {

		List<String[]> csvData = datos.leerArchivo();

		if (options.containsKey("company_name"))
			csvData = obtenerDatosPorLlave(options, csvData, "company_name", 1);

		if (options.containsKey("city"))
			csvData = obtenerDatosPorLlave(options, csvData, "city", 4);

		if (options.containsKey("state"))
			csvData = obtenerDatosPorLlave(options, csvData, "state", 5);

		if (options.containsKey("round"))
			csvData = obtenerDatosPorLlave(options, csvData, "round", 9);

		List<Map<String, String>> output = new ArrayList<Map<String, String>>();

		for (int i = 0; i < csvData.size(); i++) {
			Map<String, String> mapped = new HashMap<String, String>();
			mapear(mapped, csvData, i);
			output.add(mapped);
		}

		return output;

	}

	private List<String[]> obtenerDatosPorLlave(Map<String, String> options, List<String[]> csvData,
			String nombreColumna, int columna) throws IOException {
		/*
		 * List<String[]> results = new ArrayList<String[]>();
		 * 
		 * 
		 * for (int i = 0; i < csvData.size(); i++) {
		 * 
		 * if (csvData.get(i)[4].equals(options.get(nombreColumna))) {
		 * results.add(csvData.get(i)); }
		 * 
		 * } csvData = results; return csvData;
		 */
		List<String[]> results = new ArrayList<String[]>();
		String nombreLlave = datos.leerArchivo().get(0)[columna]; // No se me ocurre como quitar los puntos

		for (int i = 0; i < csvData.size(); i++) {
			results = compararDatos(results, csvData, csvData.get(i)[columna], options.get(nombreLlave), i);
		}
		return results;
	}

	private List<String[]> compararDatos(List<String[]> results, List<String[]> csvData, String datoArchivo,
			String datoLlave, int indice) {

		if (datoArchivo.equals(datoLlave))
			results.add(csvData.get(indice));
		return results;
	}

	private static void mapear(Map<String, String> mapped, List<String[]> csvData, int indice) {
		mapped.put("permalink", csvData.get(indice)[0]);
		mapped.put("company_name", csvData.get(indice)[1]);
		mapped.put("number_employees", csvData.get(indice)[2]);
		mapped.put("category", csvData.get(indice)[3]);
		mapped.put("city", csvData.get(indice)[4]);
		mapped.put("state", csvData.get(indice)[5]);
		mapped.put("funded_date", csvData.get(indice)[6]);
		mapped.put("raised_amount", csvData.get(indice)[7]);
		mapped.put("raised_currency", csvData.get(indice)[8]);
		mapped.put("round", csvData.get(indice)[9]);

	}

	public Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
		List<String[]> csvData = datos.leerArchivo();

		Map<String, String> mapped = new HashMap<String, String>();

		for (int i = 0; i < csvData.size(); i++) {
			if (options.containsKey("company_name")) {
				if (csvData.get(i)[1].equals(options.get("company_name"))) {
					mapear(mapped, csvData, i);
				} else {
					continue;
				}
			}

			if (options.containsKey("city")) {
				if (csvData.get(i)[4].equals(options.get("city"))) {
					mapear(mapped, csvData, i);
				} else {
					continue;
				}
			}

			if (options.containsKey("state")) {
				if (csvData.get(i)[5].equals(options.get("state"))) {
					mapear(mapped, csvData, i);
				} else {
					continue;
				}
			}

			if (options.containsKey("round")) {
				if (csvData.get(i)[9].equals(options.get("round"))) {
					mapear(mapped, csvData, i);
				} else {
					continue;
				}
			}

			return mapped;
		}

		throw new NoSuchEntryException();
	}

	public static void main(String[] args) {
		try {

			Datos datos = new DatosCsv();
			Recaudacion r = new Recaudacion(datos);
			Map<String, String> options = new HashMap<String, String>();
			options.put("company_name", "Facebook");
			options.put("round", "a");
			System.out.print("Tamaño: " + r.where(options).size());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			System.out.print("error");
		}
	}
}

class NoSuchEntryException extends Exception {

}