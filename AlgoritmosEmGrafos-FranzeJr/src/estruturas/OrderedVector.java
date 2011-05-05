package estruturas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class OrderedVector {

	private List<Aresta>  elements = new ArrayList<Aresta>();
	
	public OrderedVector(List<Aresta> elements) {
		this.elements.addAll(elements);
		Collections.sort(this.elements);
	}
	
	public void addElement(Aresta element){
		int index = this.elements.size();
		for(int i=0;i<elements.size();i++){
			Aresta eTempi = elements.get(i);
			if(element.compareTo(eTempi)<=0){
				index = i;
				break;
			}	
		}
		elements.add(index, element);
	}
	
	public void remove(Aresta element){
		int index = this.elements.indexOf(element);
		if(index>=0)
			this.elements.remove(index);
	}
	
	public Aresta deleteFirst(){
		return this.elements.remove(0);
	}
	
	@Override
	public String toString() {
		String s = "";
		for(Aresta a:this.elements)
			s+="\n"+a.toString();
		return s;
	}
}
