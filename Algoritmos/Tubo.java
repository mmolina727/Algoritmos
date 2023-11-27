package Algoritmos;

public class Tubo {
	
	private String estacion1;
	private String estacion2;
    private int distancia;

    public Tubo(String estacion1, String estacion2, int distancia) {
        this.estacion1 = estacion1;
    	this.estacion2 = estacion2;
        this.distancia = distancia;
    }
    
    public String getEstacion1() {
		return estacion1;
	}

	public String getEstacion2() {
        return estacion2;
    }

    public int getDistancia() {
        return distancia;
    }
    
    public String toString() {
    	return estacion1 + ", " + estacion2 + ", " + distancia;
    }

}
