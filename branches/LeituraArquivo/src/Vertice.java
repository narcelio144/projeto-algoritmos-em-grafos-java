import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Vertice implements Comparable<Vertice> {
	
	private String descricao;
    private int distancia;
    private boolean visitado = false;
    private Vertice pai;
    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> vizinhos = new ArrayList<Vertice>();
    
    
    
    public Vertice(String s){
    	this.descricao = s;
    }
    
    public Vertice(){
    
    }
    
    public void visitar (){
        
        this.visitado = true;
    }
    
    public boolean verificarVisita(){
        
        return visitado;
    }
    
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	public Vertice getPai() {
		return pai;
	}
	public void setPai(Vertice pai) {
		this.pai = pai;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertice){
			Vertice vRef = (Vertice) obj;
			if(this.getDescricao().equals(vRef.getDescricao())) return true;
		}
		return false;
	}

	@Override
	public int compareTo(Vertice vertice) {
		if(this.getDistancia() < vertice.getDistancia()) return -1;
		else if(this.getDistancia() == vertice.getDistancia()) return 0;
		
		return 1;
	}
	
	@Override
	public String toString() {
		String s = " ";
		s+= this.getDescricao();
		return s;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setVizinhos(List<Vertice> vizinhos) {
		this.vizinhos = vizinhos;
	}

	public List<Vertice> getVizinhos() {
		return vizinhos;
	}

}
