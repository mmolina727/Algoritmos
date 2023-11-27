package Algoritmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Grafo {
	private HashMap<String, List<Tubo>> grafo;

	public Grafo() {
		this.grafo = new HashMap<>();
	}

	public void agregarVertice(String vertice) {
		if (!grafo.containsKey(vertice)) {
			grafo.put(vertice, new ArrayList<Tubo>());
		}
	}

	public void addTubo(String estacion1, String estacion2, int distancia) {
		if (grafo.get(estacion1) != null && grafo.get(estacion2) != null) {
			Tubo tubo1 = new Tubo(estacion1, estacion2, distancia);
			Tubo tubo2 = new Tubo(estacion2, estacion1, distancia);
			grafo.get(estacion1).add(tubo1);
			grafo.get(estacion2).add(tubo2);
		}
	}

	public Iterator<String> obtenerVertices() {

		return grafo.keySet().iterator();
	}

	public Iterator<String> obtenerAdyacentes(String vertice) {
		List<Tubo> tubos = grafo.get(vertice);
		List<String> adjacentes = new ArrayList<>();

		if (!tubos.isEmpty()) {
			for (Tubo tubo : grafo.get(vertice)) {
				adjacentes.add(tubo.getEstacion2());
			}
		}

		return adjacentes.iterator();
	}

	public int getDistanciaTubo(String estacion1, String estacion2) {
		for (Tubo tubo : grafo.get(estacion1)) {
			if (tubo.getEstacion2().equals(estacion2)) {
				return tubo.getDistancia();
			}
		}

		return -1;
	}

	public boolean existeTubo(String estacion1, String estacion2) {

		for (Entry<String, List<Tubo>> entry : grafo.entrySet()) {
			if (entry.getKey().contains(estacion1)) {
				List<Tubo> listAux = grafo.get(entry.getKey());
				for (Tubo tubo : listAux) {
					if (tubo.getEstacion2().equals(estacion2)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public int cantidadVertices() {

		return grafo.size();
	}

	public Tubo obtenerTubo(String estacion1, String estacion2) {

		List<Tubo> tubos = grafo.get(estacion1);
		if (!tubos.isEmpty()) {
			for (Tubo tubo : tubos) {
				if (tubo.getEstacion2().equals(estacion2)) {

					return tubo;
				}
			}

		}
		return null;
	}

	public void borrarTubo(String estacion1, String estacion2) {

		if (existeTubo(estacion1, estacion2)) {
			grafo.get(estacion1).remove(obtenerTubo(estacion1, estacion2));
		}
	}

	public int cantidadTubos() {

		int totalArcos = 0;
		for (Entry<String, List<Tubo>> entry : grafo.entrySet()) {
			List<Tubo> listAux = entry.getValue();
			totalArcos += listAux.size();
		}
		return totalArcos;
	}

	public Iterator<Tubo> obtenerTubos(String estacion) {

		List<Tubo> tubos = new ArrayList<>();
		for(Entry<String, List<Tubo>> entry : grafo.entrySet()){
			if(entry.getKey().equals(estacion)) {
				tubos.addAll(entry.getValue());
			}
		}
		return tubos.iterator();
	}
}
