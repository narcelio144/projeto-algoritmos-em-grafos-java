package estruturas;

import java.util.ArrayList;
import java.util.List;

public class MySet<T> {
	
	private List<T> elements = new ArrayList<T>();
	
	public void addElement(T element){
		if(!elements.contains(element))
			this.elements.add(element);
	}
	public List<T> getElements(){
		return this.elements;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(T e: elements)
			s+="\n"+e.toString();
		return s;
	}

}
