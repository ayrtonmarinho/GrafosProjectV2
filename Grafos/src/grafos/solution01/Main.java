package grafos.solution01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	    
		String ver = lerFile("vertices.txt");
		String arst = lerFile("arestas.txt");
		ArrayList<Node> n = new ArrayList<>();
		
		//Apenas um teste 
		System.out.println(ver);
		System.out.println();
		System.out.println(arst);
		System.out.println();
		
		String[] vertices = splitTxtBN(ver);
		String[] arestas = splitTxtBN(arst);
		
		addVertAndArst(n, vertices, arestas);
		
		
		// Usar uma lista aqui
        // Constructing the graph
        Node n0 = new Node(0,"Maristal 15");
        Node n1 = new Node(1, "Zubei 9");
        Node n2 = new Node(2, "Cadilac 21");
        Node n3 = new Node(3, "Namoris 234");
        Node n4 = new Node(4, "Suzana Better, 15");
        Node n5 = new Node(5, "Marigold 922");
        
        

        n0.addEdge(n1);
        n1.addEdge(n0);
        n1.addEdge(n3);
        n1.addEdge(n2);
        n2.addEdge(n1);
        n2.addEdge(n4);
        n3.addEdge(n1);
        n3.addEdge(n4);
        n3.addEdge(n5);
        n4.addEdge(n2);
        n4.addEdge(n3);
        n5.addEdge(n3);


        // Traversal methods

        System.out.println("BFS Iterative:");
        bfs(n.get(0));
        System.out.println();

        System.out.println("DFS Iterative:");
        dfsIterative(n.get(4));
        System.out.println();

        System.out.println("DFS Recursive:");
        dfsRecursive(n.get(4), new HashSet<Integer>());
    
    }

    public static void bfs(Node startNode) {
        
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(startNode);
        visited.add(startNode.value);
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.value+" ");
            System.out.println(currentNode.texto);
            
            for (Node n : currentNode.neighbors) {
                if (!visited.contains(n.value)) {
                    queue.add(n);
                    visited.add(n.value);
                }
            }
        }
    }

    public static void dfsIterative(Node startNode) {
        Stack<Node> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            
            if (!visited.contains(currentNode.value)) {
                System.out.println(currentNode.value);
                visited.add(currentNode.value);
            }
            
            for (Node n : currentNode.neighbors) {
                if (!visited.contains(n.value)) {
                    stack.push(n);
                }
            }
        }
    }

    public static void dfsRecursive(Node startNode, Set<Integer> visited) {
        System.out.println(startNode.value);
        visited.add(startNode.value);
        
        for (Node n : startNode.neighbors) {
            if (!visited.contains(n.value)) {
                dfsRecursive(n, visited);
            }
        }
    }
    
    //Função para ler o .txt de vertices e arestas.
    public static String lerFile(String filename) {
    	String nameString = "";
    	
    	try {
			nameString = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return nameString;
    	
    }
    
    public static void addVertAndArst(ArrayList<Node> n, String[] vertices, String[] arestas) {
    	
    	for(int i=0; i<vertices.length; i++) {
    		String[] t = splitTxtComma(vertices[i]);
    		Node v = new Node(Integer.parseInt(t[0]), t[1]);
    		n.add(v);
    	}
    	for(int i=0; i<n.size(); i++) {
    		String[] a = splitTxtComma(arestas[i]);
    		
    		int[] numero = converteInt(a);
    		
    		Node u = n.get(i);
    		for(int j = 1; j<numero.length; j++) {
    			Node m;
    			int num = numero[j];
    			m = n.get(num); // modficiar para n.get(num-1) se as arestas começarem por 1
    			System.out.print(m.getValue());
    			n.get(i).addEdge(m);
    			
    		}
    		System.out.println();
    	}
    }
    
    
    
    
    
    // Retorna um array de String para cada /n
    public static String[] splitTxtBN(String s) {
    	String[] t = s.split("\n");
    	return t;
    }
    
    // Retorna um array de String para cada ,
    public static String[] splitTxtComma(String s) {
    	String[] t = s.split(",");
    	return t;
    }
    
    //Converte um vetor de string em um vetor de inteiros
    public static int[] converteInt(String[] s) {
    	int[] n = new int[s.length];
    	for(int i = 0; i<s.length; i++) {
    		String x = s[i].trim();
    		n[i] = Integer.parseInt(x);
    	}
    	return n;
    }
    

}
