package estrutura;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice>{
        
        private String descricao;
        private int distancia;
        private boolean visitado = false;
        private Vertice pai;
        private List<Aresta> arestas = new ArrayList<Aresta>();
        private List<Vertice> vizinhos = new ArrayList<Vertice>();
        
        
        public Vertice(String nome){
                
                this.descricao = nome;
                
        }
        
        public void setDescricao(String nome){
                
                this.descricao = nome;
        }
        
        public String getDescricao(){
                
                return descricao;
                
        }
        
        public void visitar (){
                
                this.visitado = true;
        }
        
        public boolean verificarVisita(){
                
                return visitado;
        }
        
        public void setDistancia(int distancia){
                
                this.distancia = distancia;
        }
        
        public int getDistancia(){
                
                return this.distancia;
        }
        
        public void setPai(Vertice pai){
                
                this.pai = pai;
        }
        
        public Vertice getPai(){
                
                return this.pai;
        }

        public void setVizinho(Vertice vizinho) {
                
                this.vizinhos.add(vizinho);
                                
        }
        
        public List<Vertice> getVizinhos(){
                
                return this.vizinhos;
        }
        
        public void setAresta(Aresta novaAresta){
                
                this.arestas.add(novaAresta);
                
        }
        
        public List<Aresta> getArestas() {
                
                return arestas;
        }

        @Override
        public int compareTo(Vertice vertice) {
                  if(this.getDistancia() < vertice.getDistancia()) return -1;
          else if(this.getDistancia() == vertice.getDistancia()) return 0;
          
          return 1;

                
        }
        
}


