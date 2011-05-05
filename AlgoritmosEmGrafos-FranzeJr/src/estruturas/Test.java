package estruturas;


public class Test {

	public static void main(String[] args) {
		MySet<Aresta> set = new MySet<Aresta>();
		Vertice v1 = new Vertice();
		Vertice v2 = new Vertice();
		

		Aresta a1 = new Aresta(v1, v2, 2);
		Aresta a2 = new Aresta(v2, v1, 2);
		
		set.addElement(a1);
		set.addElement(a2);
		
		System.out.println(set.getElements().size());
	}
}
