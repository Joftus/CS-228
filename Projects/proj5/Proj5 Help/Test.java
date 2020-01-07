package edu.iastate.cs228.hw5;

public class Test {

	public static void main(String[] args) 
	{
		DiGraph<String> G8 = new DiGraph<String>();
		G8.addEdge("S", "A", 6);
		G8.addEdge("S", "B", 10);
		G8.addEdge("S", "G", -5);
		G8.addEdge("A", "D", 8);
		G8.addEdge("A", "E", 5);
		G8.addEdge("B", "A", -6);
		G8.addEdge("B", "E", 10);
		G8.addEdge("C", "S", 11);
		G8.addEdge("D", "G", 7);
		G8.addEdge("E", "D", 6);
		G8.addEdge("E", "G", 5);
		G8.addEdge("F", "B", -8);
		G8.addEdge("F", "C", 2);
		LinkedStack<String> order = DFS.depthFirstSearch(G8);
		System.out.println("A topological order: ");
		while(!order.isEmpty())
		{
			System.out.println("Vertex: " + order.pop());
		}
		
		LinkedStack<String> path = new LinkedStack<String>();
		System.out.println("Distance of a max path: " + MaxPath.findMaxPath(G8, path) );
		System.out.println("Each vertex in the max path: ");
		while ( ! path.isEmpty() )
		System.out.println("Vertex: " + path.pop());
		
	}

}
