import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

	Map<Vertice, List<Vertice>> la = new HashMap<Vertice, List<Vertice>>();
	
	//Atributos usados na função encontrarMenorCaminho
    
    //Lista que guarda os vértices pertencentes ao menor caminho encontrado
    List<Vertice> menorCaminho = new ArrayList<Vertice>();
    
    //Variável que recebe os vértices pertencentes ao menor caminho
    Vertice verticeCaminho = new Vertice ("caminho");
    
    //Variável que guarda o vértice que está sendo visitado 
    Vertice atual = new Vertice ("atual");
    
    //Variável que marca o vizinho do vértice atualmente visitado 
    Vertice vizinho = new Vertice ("vizinho");
    
    //Corte de vértices que já tiveram suas distâncias marcadas e cujos vizinhos não foram visitados
    List<Vertice> fronteira = new ArrayList<Vertice>();
    
    //Guarda o número de vértices não visitados
    int verticesNaoVisitados;


	public static Map<Vertice, List<Vertice>> lerGrafo(String nomeArquivo) {
		File f = new File(nomeArquivo);
		Map<Vertice, List<Vertice>> la = new HashMap<Vertice, List<Vertice>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String linha;

			while ((linha = br.readLine()) != null) {
				Vertice v = new Vertice();
				String[] token = linha.split("(:)|(,)");
				List<Vertice> adj = new ArrayList<Vertice>();
				for (int i = 1; i < token.length; i++) {
					adj.add(v);
					adj.get(i).setDescricao(token[i]);
				}
				Vertice vInicial = new Vertice();
				vInicial.setDescricao(token[0]);
				la.put(vInicial, adj);
			}
			// catch do BufferedReader
		} catch (FileNotFoundException e) {
			System.out.println("Nao encontrou o arquivo");
			e.printStackTrace();
		}
		// catch do readLine
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return la;
	}

	public static void main(String args[]) {

		Grafo g = new Grafo();

		g.la = lerGrafo("teste.txt");

		System.out.println(g.la);

	}

	// Algoritmo de Dijkstra
	public List<Vertice> encontrarMenorCaminhoDijkstra(Vertice v1, Vertice v2) {

		// No início, todos os vértices do grafo não foram visitados
		verticesNaoVisitados = this.la.size();

		// O primeiro nó a ser visitado é o da origem do caminho
		atual = v1;
		// Adiciona o primeiro nó no corte
		fronteira.add(atual);
		// Adiciona a origem na lista do menor caminho
		menorCaminho.add(atual);

		// Colocando a distancias iniciais
		for (int i = 0; i < this.la.size(); i++) {

			// Nó atual tem distância zero, e todos os outros, 9999(infinita)
			if (this.la.containsValue(atual.getDescricao())) {
				
			 ((Vertice) this.la.get(i)).getDescricao();
				//this.vertices.get(i).setDistancia(0);

			} else {

				((Vertice) this.la.get(i)).setDistancia(9999);

			}
		}

		// O algoritmo continua até que todos os vértices sejam visitados
		while (verticesNaoVisitados != 0) {

			// Toma-se sempre o vértice com menor distância, que é o primeiro da
			// lista do corte
			atual = this.fronteira.get(0);
			/*
			 * Para cada vizinho (cada aresta), calcula-se a sua possível
			 * distância, somando a distância do vértice atual com a da aresta
			 * correspondente. Se essa distância for menor que a distância do
			 * vizinho, esta é atualizada.
			 */
			for (int i = 0; i < la.size(); i++) {

				vizinho = atual.getArestas().get(i).getDestino();
				if (!vizinho.verificarVisita()) {

					vizinho.setPai(atual);

					// Comparando a distância do vizinho com a possível
					// distância
					if (vizinho.getDistancia() > (atual.getDistancia() + atual
							.getArestas().get(i).getPeso())) {

						vizinho.setDistancia(atual.getDistancia()
								+ atual.getArestas().get(i).getPeso());

						/*
						 * Se o vizinho é o vértice procurado, e foi feita uma
						 * mudança na distância, a lista com o menor caminho
						 * anterior é apagada, pois existe um caminho menor
						 * ainda. Cria-se a nova lista do menor caminho, com os
						 * vértices pais, até o vértice origem.
						 */
						if (vizinho == v2) {
							menorCaminho.clear();
							verticeCaminho = vizinho;
							menorCaminho.add(vizinho);
							while (verticeCaminho.getPai() != null) {

								menorCaminho.add(verticeCaminho.getPai());
								verticeCaminho = verticeCaminho.getPai();

							}
							// Ordena a lista do menor caminho, para que ele
							// seja exibido da origem ao destino.
							Collections.sort(menorCaminho);

						}
					}
					// Cada vizinho, depois de visitado, é adicionado ao corte
					this.fronteira.add(vizinho);
				}

			}
			// Marca o vértice atual como visitado e o retira do corte
			atual.visitar();
			verticesNaoVisitados--;
			this.fronteira.remove(atual);
			/*
			 * Ordena a lista do corte, para que o vértice com menor distância
			 * fique na primeira posição
			 */

			Collections.sort(fronteira);

		}

		return menorCaminho;
	}

}
