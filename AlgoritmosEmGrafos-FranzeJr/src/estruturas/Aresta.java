package estruturas;

public class Aresta implements Comparable<Aresta> {
	private static int qtd;
	private int id;
	private String cor = "branco";
	private int peso;
	private Vertice v1;
	private Vertice v2;

	// Construtores que podem ser utilizados de acordo com o algoritmo

	public Aresta(Vertice v1, Vertice v2, int peso) {
		this.id = qtd++;
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;

	}

	// Metodos getters e setters
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Vertice getV1() {
		return v1;
	}

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public void setV2(Vertice v2) {
		this.v2 = v2;
	}

	@Override
	public String toString() {
		String s = "";
		s+="V"+this.v1.getMyId()+"-"+this.getPeso()+"->V"+this.v2.getMyId()+" ";
		return s;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Aresta) {
			Aresta aRef = (Aresta) obj;
			if ((v1.equals(aRef.v1) || v1.equals(aRef.v2))
					&& (v2.equals(aRef.v1) || v2.equals(aRef.v2)))
				return true;
			return false;
		}

		return false;
	}
	
	@Override
	public int compareTo(Aresta aresta) {
		if (this.peso < aresta.getPeso())
			return -1;
		else if (this.peso == aresta.getPeso())
			return 0;
		return 1;
	}

}
