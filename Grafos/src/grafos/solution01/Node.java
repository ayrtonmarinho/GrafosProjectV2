package grafos.solution01;

import java.util.ArrayList;
import java.util.List;

public class Node {

	int value;
	String texto;
	List<Node> neighbors;

	public Node(int value) {
		this.value = value;
		neighbors = new ArrayList<>();
	}
	
	//Construtor alternativo
	public Node(int value, String texto) {
		this.value = value;
		this.texto = texto;
		neighbors = new ArrayList<>();
	}
	
	public void addEdge(Node to) {
		neighbors.add(to);
	}
	
	public void addTexto(String texto) {
		this.texto = texto;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}
	
	
}
