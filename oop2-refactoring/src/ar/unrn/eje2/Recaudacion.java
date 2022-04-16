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

		if (options.containsKey("company_name")) {
			List<String[]> results = new ArrayList<String[]>();

			for (int i = 0; i < csvData.size(); i++) {
				if (csvData.get(i)[1].equals(options.get("company_name"))) {
					results.add(csvData.get(i));
				}
			}
			csvData = results;
		}

		if (options.containsKey("city")) {
			List<String[]> results = new ArrayList<String[]>();

			for (int i = 0; i < csvData.size(); i++) {
				if (csvData.get(i)[4].equals(options.get("city"))) {
					results.add(csvData.get(i));
				}
			}
			csvData = results;
		}

		if (options.containsKey("state")) {
			List<String[]> results = new ArrayList<String[]>();

			for (int i = 0; i < csvData.size(); i++) {
				if (csvData.get(i)[5].equals(options.get("state"))) {
					results.add(csvData.get(i));
				}
			}
			csvData = results;
		}

		if (options.containsKey("round")) {
			List<String[]> results = new ArrayList<String[]>();

			for (int i = 0; i < csvData.size(); i++) {
				if (csvData.get(i)[9].equals(options.get("round"))) {
					results.add(csvData.get(i));
				}
			}
			csvData = results;
		}

		List<Map<String, String>> output = new ArrayList<Map<String, String>>();

		for (int i = 0; i < csvData.size(); i++) {
			Map<String, String> mapped = new HashMap<String, String>();
			mapear(mapped, csvData, i);
			output.add(mapped);
		}

		return output;
	}

	public static void mapear(Map<String, String> mapped, List<String[]> csvData, int indice) {
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

	public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
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

			Datos datos = new CsvData();
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