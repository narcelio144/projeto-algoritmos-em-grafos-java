import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Grafo {
	
	Map<Integer, List<Integer>> la = new HashMap<Integer, List<Integer>>();
	
	
	public static Map<Integer,List<Integer>> lerGrafo(String nomeArquivo){
		File f = new File(nomeArquivo);
		Map<Integer, List<Integer>> la = new HashMap<Integer, List<Integer>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String linha;
			
				while( (linha = br.readLine()) != null){
					String[] token = linha.split("(:)|(,)");
					List<Integer> adj = new ArrayList<Integer>();
					for(int i = 1; i < token.length; i++){
						adj.add(Integer.parseInt(token[i]));
					}
					la.put(Integer.parseInt(token[0]),adj);
				}
		//catch do BufferedReader	
		} catch (FileNotFoundException e) {
			System.out.println("Nao encontrou o arquivo");
			e.printStackTrace();
		}
		//catch do readLine
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return la;
	}
	
	public static void main(String args[]){
		
		Grafo g = new Grafo();
		
		g.la = lerGrafo("teste.txt");
		
		System.out.println(g.la);
		
		
	}
	

}
