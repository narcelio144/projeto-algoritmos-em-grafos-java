package algoritmos;

import imported.BinaryHeap;

import java.util.ArrayList;
import java.util.List;

import estruturas.Aresta;
import estruturas.Grafo;
import estruturas.MySet;
import estruturas.OrderedVector;
import estruturas.Vertice;

public class MainGrafo {
	
	public static void main(String args[]){
		
		Grafo grafo = new Grafo();
		for(int i=0;i<6;i++)
			grafo.addVertice(new Vertice());
		
		List<Vertice> vertices = grafo.getVertices().getElements();
	
		Aresta a1 = new Aresta(vertices.get(0),vertices.get(1),4);
		Aresta a2 = new Aresta(vertices.get(0),vertices.get(2),3);
		Aresta a3 = new Aresta(vertices.get(1),vertices.get(2),2);
		Aresta a4 = new Aresta(vertices.get(1),vertices.get(4),7);
		Aresta a5 = new Aresta(vertices.get(2),vertices.get(3),8);
		Aresta a6 = new Aresta(vertices.get(3),vertices.get(4),1);
		Aresta a7 = new Aresta(vertices.get(3),vertices.get(5),5);
		Aresta a8 = new Aresta(vertices.get(4),vertices.get(5),2);
		
		grafo.addAresta(a1);
		grafo.addAresta(a2);
		grafo.addAresta(a3);
		grafo.addAresta(a4);
		grafo.addAresta(a5);
		grafo.addAresta(a6);
		grafo.addAresta(a7);
		grafo.addAresta(a8);
		System.out.println(grafo);
		
		//TESTANDO O PRIM
		Prim prim = new Prim();
		MySet<Aresta> primRes = prim.primVetorOrdenado(grafo);
		
		System.out.println(primRes);
		
		
	}

}
