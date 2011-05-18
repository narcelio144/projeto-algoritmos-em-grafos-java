
public class Vertice {
	
	private String descricao;
    private int distancia;
    private boolean visitado = false;
    private Vertice pai;
    
    public Vertice(String s){
    	this.descricao = s;
    }
    
    public Vertice(){
    	
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

}
