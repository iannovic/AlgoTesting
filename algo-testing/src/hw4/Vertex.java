package hw4;

import java.util.ArrayList;

public class Vertex {

	public int id;
	public int layer = 0;
	public ArrayList<Integer> adjacency_list;
	public boolean visited;
	
	public Vertex(int id) {
		this.id = id;
		adjacency_list = new ArrayList<Integer>();
	}
	
	public String toString() {
		String s = id + " {";
		for (Integer i : adjacency_list) {
			s += ", ";
			s += i;
		}
		s += "}";
		return s;
	}
}
