package Algoritmos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RedSubteGreedy {

	private Grafo grafo;
	private List<Tubo> solucion;
	private int totalLargoTunel;
	private int iteraciones;
	public RedSubteGreedy(Grafo grafo) {
		this.grafo = grafo;
		this.solucion = new ArrayList<>();
		this.totalLargoTunel = -1;
		this.iteraciones = 0;
	}

	private List<String> cargarCandidatos() {
		
		List<String> candidatos = new ArrayList<>();
		Iterator<String> estacionesIt = grafo.obtenerVertices();
		while (estacionesIt.hasNext()) {
			candidatos.add(estacionesIt.next());
		}
		
		return candidatos;
	}

	public void construirRedSubte() {
		this.iteraciones++;
		List<String> visitados = new ArrayList<>();
		List<String> candidatos = cargarCandidatos();

		String estacionInicial = candidatos.get(0);
		visitados.add(estacionInicial);
		candidatos.remove(estacionInicial);

		while (!candidatos.isEmpty()) {
			this.iteraciones++;
			Tubo tuboMasCorto = null;
			String estacionDestino = null;

			for (String estacionVisitada : visitados) {
				for (String estacionNoVisitada : candidatos) {
					Tubo tubo = grafo.obtenerTubo(estacionVisitada, estacionNoVisitada);
						if (tuboMasCorto == null || tubo.getDistancia() < tuboMasCorto.getDistancia()) {
							tuboMasCorto = tubo;
							estacionDestino = estacionNoVisitada;
						}
					}
			}
			solucion.add(tuboMasCorto);
			visitados.add(estacionDestino);
			candidatos.remove(estacionDestino);
		}

		this.totalLargoTunel = this.calcularLargoTotalDeTunel();
	}

	public List<Tubo> getSolucion() {
		return new ArrayList<Tubo>(this.solucion);
	}

	public int getTotalLargoTunel() {
		return totalLargoTunel;
	}

	public int calcularLargoTotalDeTunel() {

		return calcularLargoTotalDeRecorrido(solucion);
	}

	private int calcularLargoTotalDeRecorrido(List<Tubo> lista) {

		if (lista.size() == 0)
			return -1;
		else {
			int largo = 0;
			for (int i = 0; i < lista.size(); i++) {
				String estacion1 = lista.get(i).getEstacion1();
				String estacion2 = lista.get(i).getEstacion2();
				largo += grafo.getDistanciaTubo(estacion1, estacion2);
			}
			return largo;
		}


	}

	public int getIteraciones(){
		return this.iteraciones;
	}

}