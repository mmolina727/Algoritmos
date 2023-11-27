package Algoritmos;


public class Main {

	public static void main(String[] args) {
		
		String path = "Dataset/dataset1.txt";
		CSVReader reader = new CSVReader(path);

		Grafo grafo = new Grafo();
		
		reader.read(grafo);

		System.out.println("Backtracking");
		RedSubteBacktracking redSubte = new RedSubteBacktracking(grafo);
		redSubte.construirRedSubte();
		
		for(Tubo tubo : redSubte.getSolucion()) {
			System.out.println(tubo);
		}
		System.out.println("Distancia: " + redSubte.getTotalLargoTunel());
		System.out.println("Métrica: " + redSubte.getIteraciones());

		System.out.println();

		System.out.println("Greedy");
		RedSubteGreedy redSubteGreedy = new RedSubteGreedy(grafo);
		redSubteGreedy.construirRedSubte();

		for(Tubo tubo : redSubteGreedy.getSolucion()) {
			System.out.println(tubo);
		}
		System.out.println("Distancia: " + redSubteGreedy.getTotalLargoTunel());
		System.out.println("Métrica: " + redSubteGreedy.getIteraciones());
		
	}

}
