package estrutura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algoritmos.Dijkstra;

public class LerDoArquivo{
	
	public static List<Vertice> lerGrafo(String nomeArquivo){
	
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
	
				g.adicionarVertice(v);
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
	
		return g.getVertices();
	}
	
	public static void main(String args[]) {
		
		Grafo teste = new Grafo();
		
		teste.setVertices(lerGrafo("teste.txt"));
		int i1=0,i2 = 0;
		for(int i = 0; i < teste.getVertices().size(); i++){
			if(teste.getVertices().get(i).getDescricao().equals("v1")) i1 = i;
			if(teste.getVertices().get(i).getDescricao().equals("v3")) i2 = i;
		}
		
		List<Vertice> resultado = new ArrayList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		resultado = algoritmo.encontrarMenorCaminhoDijkstra(teste, teste.getVertices().get(i1), teste.getVertices().get(i2));
	
		
			System.out.println(resultado);
	}
		
	
	}
