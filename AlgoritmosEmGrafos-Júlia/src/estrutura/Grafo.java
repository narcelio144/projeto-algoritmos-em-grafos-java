package estrutura;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> vertices = new ArrayList<Vertice>();
    private List<Aresta> arestas = new ArrayList<Aresta>();
    
    public void setArestas(List<Aresta> arestas){
        
        this.arestas.addAll(arestas);
	}
	
	public List<Aresta> getArestas() {
	
	        return arestas;
	
	}
	
	public void setVertices(List<Vertice> vertices) {
	        
	        this.vertices.addAll(vertices);
	}
	
	public List<Vertice> getVertices() {
	        
	        return this.vertices;
	}
	
	//Método que retorna o vértice cuja descrição é igual à procurada.
    public Vertice encontrarVertice(String nome){
            
            for (int i=0;i<this.getVertices().size();i++){
                    
                    if (nome.equalsIgnoreCase(this.getVertices().get(i).getDescricao())){
                            
                            return this.getVertices().get(i);
                            
                    }
            }
            
            return null;
            
    }


    
}
