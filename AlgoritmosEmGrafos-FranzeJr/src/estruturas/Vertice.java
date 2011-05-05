package estruturas;

import java.util.ArrayList;

public class Vertice {
	private static int count;
	private int myId;
	private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	private ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();
	private String cor;


	public Vertice(String cor) {
		this.myId = ++count;
		this.cor = cor;
	}
	
	public ArrayList<Vertice> getVizinhos() {
		return vizinhos;
	}

	public Vertice(){ 
		this.myId = ++count;
	}
	
	public void addVizinho(Vertice vizinho, int peso){
		Aresta a = new Aresta(this,vizinho,peso);
		this.vizinhos.add(vizinho);
		this.arestas.add(a);
	}

	public int getMyId() {
		return myId;
	}


	public void setMyId(int myId) {
		this.myId = myId;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setVertices(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	@Override
	public String toString() {
		String s = "";
		s+="V"+this.getMyId()+": ";
		for(Aresta a:arestas){
			//s+="V"+a.getV2().getMyId()+",P"+a.getPeso()+"-> ";
			s+=a.toString();
		}
		/*for(Vertice v:vizinhos)
			s+=" "+v.getMyId()+" ";*/
		s+=".";
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertice){
			Vertice vRef = (Vertice)obj;
			if(vRef.myId == this.myId)
				return true;
			return false;
		}return false;
	}
}
