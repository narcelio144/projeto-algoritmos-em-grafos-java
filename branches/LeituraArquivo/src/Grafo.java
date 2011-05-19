import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Grafo {

	List<Vertice> grafo = new ArrayList<Vertice>();

	// Atributos usados na função encontrarMenorCaminho

	// Lista que guarda os vértices pertencentes ao menor caminho encontrado
	List<Vertice> menorCaminho = new ArrayList<Vertice>();

	// Variável que recebe os vértices pertencentes ao menor caminho
	Vertice verticeCaminho = new Vertice("caminho");

	// Variável que guarda o vértice que está sendo visitado
	Vertice atual = new Vertice("atual");

	// Variável que marca o vizinho do vértice atualmente visitado
	Vertice vizinho = new Vertice("vizinho");

	// Corte de vértices que já tiveram suas distâncias marcadas e cujos
	// vizinhos não foram visitados
	List<Vertice> fronteira = new ArrayList<Vertice>();

	// Guarda o número de vértices não visitados
	int verticesNaoVisitados;

	public static List<Vertice> lerGrafo(String nomeArquivo) {

		Grafo g = new Grafo();
		Vertice v;
		File f = new File(nomeArquivo);
		String vertices[];
		String linha;
		ArrayList<String[]> s1 = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			while ((linha = br.readLine()) != null) {

				if (linha.contains(",")) {
					s1.add(linha.split("/"));
					System.out.println(s1.get(0)[0]);

					// vertices = s1.get(0)[0].split(",");
					vertices = s1.get(0)[0].split(",");

					System.out.println(s1.get(0)[1]);

					v = new Vertice();
					List<Vertice> vizinhosAtual = new ArrayList<Vertice>();
					List<Aresta> arestasAtual = new ArrayList<Aresta>();
					v.setDescricao(vertices[0]);

					if (linha.contains("/")) {

						String pesoArestas[] = s1.get(0)[1].split(",");

						for (int i = 1; i < vertices.length; i++) {
							Vertice vit = new Vertice();
							System.out.println(vertices[i]);
							// System.out.println("tamanho"+ s1[0].length());
							vit.setDescricao(vertices[i]);
							vizinhosAtual.add(vit);

							v.setVizinhos(vizinhosAtual);

							Aresta ait = new Aresta(v, vit);
							ait.setPeso(Integer.parseInt(pesoArestas[i - 1]));
							arestasAtual.add(ait);

						}

						v.setArestas(arestasAtual);

					}

					System.out.println("vertice = " + v.getDescricao());
					// Teste
					for (Aresta a : arestasAtual) {

						System.out.println("peso " + a.getPeso());
					}

				}

				// Vertices finais
				else {
					v = new Vertice();
					v.setDescricao(linha);

				}

				g.grafo.add(v);
				s1.clear();
				System.out.println("desgraçado limpo:" + s1.size());
				System.out.printf("\n");
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

		return g.grafo;
	}

	public static void main(String args[]) {
		Grafo teste = new Grafo();
		
		teste.grafo = lerGrafo("teste.txt");
		int i1=0,i2 = 0;
		for(int i = 0; i < teste.grafo.size(); i++){
			if(teste.grafo.get(i).getDescricao().equals("v1")) i1 = i;
			if(teste.grafo.get(i).getDescricao().equals("v3")) i2 = i;
		}
		
		List<Vertice> resultado = new ArrayList<Vertice>();
		
		resultado = teste.encontrarMenorCaminhoDijkstra(teste, teste.grafo.get(i1), teste.grafo.get(i2));

		
			System.out.println(resultado);
	}

	// Algoritmo de Dijkstra
	public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo g, Vertice v1,
			Vertice v2) {

		// No início, todos os vértices do grafo não foram visitados
		verticesNaoVisitados = g.grafo.size();

		// O primeiro nó a ser visitado é o da origem do caminho
		atual = v1;
		// Adiciona o primeiro nó no corte
		fronteira.add(atual);
		// Adiciona a origem na lista do menor caminho
		menorCaminho.add(atual);

		// Colocando a distancias iniciais
		for (int i = 0; i < g.grafo.size(); i++) {

			// Nó atual tem distância zero, e todos os outros, 9999(infinita)
			if (g.grafo.get(i).getDescricao()
					.equals(atual.getDescricao())) {

				g.grafo.get(i).setDistancia(0);
			

			} else {

				g.grafo.get(i).setDistancia(9999);

			}
		}

		// O algoritmo continua até que todos os vértices sejam visitados
		fronteira = grafo;
		Collections.sort(fronteira);
		while (verticesNaoVisitados != 0) {

			// Toma-se sempre o vértice com menor distância, que é o primeiro da
			// lista do corte
			atual = fronteira.get(0);
			//atual = this.fronteira.get(0);
			/*
			 * Para cada vizinho (cada aresta), calcula-se a sua possível
			 * distância, somando a distância do vértice atual com a da aresta
			 * correspondente. Se essa distância for menor que a distância do
			 * vizinho, esta é atualizada.
			 */
			for (int i = 0; i < atual.getArestas().size(); i++) {

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
