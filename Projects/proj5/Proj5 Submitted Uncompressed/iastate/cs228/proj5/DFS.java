package edu.iastate.cs228.proj5;
/*
 *  @author Joshua Loftus
 *  SID: 055980026
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;



public class DFS
	{
	/**
	 * This method creates a color map and a pred map (see example Graph.java under
	 * Week 13 of Lecture notes) and an empty stack of type Stack<V>. It colors each
	 * vertex "white" and sets the value of each vertex to null in the pred map (see
	 * Graph.java). Then as long as there is a "white" vertex w left, the method
	 * calls visitDFS(...) on the vertex w along with other parameters. If
	 * visitDFS(...) returns false, then this method returns null. Otherwise, it
	 * returns the stack containing the list of all vertices in a topological order,
	 * which is produced by the visitDFS(...) method. If aGraph is null, then it
	 * throws IllegalArgumentException.
	 */
	public static <V> Stack<V> depthFirstSearch(DiGraph<V> aGraph)
		{
		if (aGraph == null)
			throw new IllegalArgumentException();
		Stack<V> aStack = new Stack<V>();
		HashMap<V, String> aHashMap = new HashMap<V, String>();
		HashMap<V, V> bHashMap = new HashMap<V, V>();
		for (V aVertice : aGraph.vertices())
			{
			aHashMap.put(aVertice, "white");
			bHashMap.put(aVertice, null);
			}
		for (V bVertice : aGraph.vertices())
			{
			boolean tf = false;
			if (aHashMap.get(bVertice) == "white")
				{
				tf = visitDFS(aGraph, bVertice, aHashMap, bHashMap, aStack);
				if (tf == false)
					return null;
				}
			}
		return aStack;
		}
		
		
		
	/**
	 * 
	 * This method implements an iterative depth-first search algorithm for checking
	 * if the given graph is acyclic (has no cycles) and if so, generates a stack
	 * (named topoOrder) of all vertices in a topological order and returns true.
	 * Otherwise, it returns false. An iterative depth-first search algorithm is
	 * given in under lecture notes for an undirected graph (Week 13 of Lecture
	 * Notes). Here, you need to modify the algorithm to make it work for a directed
	 * graph. Note that the edge iterator citer (inside Graph.java under Lecture
	 * Notes) should be changed from type Iterator<V> to type Iterator<Edge<V,
	 * Integer>>, and that citer.next().getVertex(), instead of citer.next(), gives
	 * the vertex w. If the vertex w is "gray", then the graph has a cycle. So the
	 * method returns false. Whenever a vertex is colored "black", the vertex is
	 * pushed onto the stack topoOrder. If the graph has no cycles (the execution
	 * reaches the end of the method), then the method returns true.
	 */
	protected static <V> boolean visitDFS(DiGraph<V> aGraph, V s, HashMap<V, String> color, HashMap<V, V> pred, Stack<V> topoOrder)
		{
		Stack<V> aNodeStack = new Stack<V>();
		Stack<Iterator<Edge<V, Integer>>> aEdgeStackIter = new Stack<Iterator<Edge<V, Integer>>>();
		color.put(s, "gray");
		Iterator<Edge<V, Integer>> aGraphIter = aGraph.adjacentTo(s).iterator();
		aNodeStack.push(s);
		aEdgeStackIter.push(aGraphIter);
		while (aNodeStack.isEmpty() == false)
			{
			V aVertice = aNodeStack.peek();
			Iterator<Edge<V, Integer>> aEdgeIter = aEdgeStackIter.peek();
			if (aEdgeIter.hasNext() == true)
				{
				V bVertice = aEdgeIter.next().getVertex();
				if (color.get(bVertice) == "white")
					{
					color.put(bVertice, "gray");
					pred.put(bVertice, aVertice);
					Iterator<Edge<V, Integer>> bEdgeIter = aGraph.adjacentTo(bVertice).iterator();
					aEdgeStackIter.push(bEdgeIter);
					aNodeStack.push(bVertice);
					}
				else if (color.get(bVertice) == "gray")
					{
					while (topoOrder.isEmpty() == false)
						{
						topoOrder.pop();
						}
					return false;
					}
				}
			else
				{
				color.put(aVertice, "black");
				aNodeStack.pop();
				aEdgeStackIter.pop();
				topoOrder.push(aVertice);
				}
			}
		return true;
		}
	}
