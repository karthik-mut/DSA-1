package com.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.interview.day4.graph.ds.GraphLinkedList;
import com.interview.graph.ds.GraphListList;
import com.interview.graph.ds.GraphMap;
import com.interview.graph.ds.GraphMatrix;

public class GraphTraversal {

	public static void main(String[] args) {
		
		// Matrix
		GraphMatrix m = new GraphMatrix(new int[][] { { 1, 1, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } });
		bfsMatrix(m);
		dfsMatrixRecursive(m);
		dfsMatrixIterative(m);

		// Map
		String[] v = new String[] { "A", "B", "C", "D", "E", "F" };
		GraphMap<String> dict = new GraphMap<>(v);
		dict.addEdge("A", "B");
		dict.addEdge("B", "C");
		dict.addEdge("C", "F");
		dict.addEdge("F", "E");
		dict.addEdge("E", "D");
		dict.addEdge("A", "F");
		dict.addEdge("A", "D");

		dfsMapRecursive(dict);
		dfsMapIterative(dict);
		bfsMap(dict);

		// List- List
		GraphListList l = new GraphListList(5);
		l.addEdge(1, 2);
		l.addEdge(2, 3);
		l.addEdge(3, 4);
		l.addEdge(4, 5);
		l.addEdge(2, 5);
		
		dfsListRecursive(l);
		dfsListIterative(l);
		bfsList(l);

		// Array - LinkedList
		GraphLinkedList g6 = new GraphLinkedList(7);
		g6.addEdge(1, 2);
		g6.addEdge(2, 3);
		g6.addEdge(3, 4);
		g6.addEdge(4, 6);
		g6.addEdge(1, 4);
		g6.addEdge(2, 4);
		
		dfsLinkedListRecursive(g6);
		dfsLinkedListIterative(g6);
		bfsLinkedList(g6);

		// Node

		// Proper Graph
	}
	
	///////////////MATRIX - LINKEDLIST///////////////////////
	private static void bfsLinkedList(GraphLinkedList g6) {
		// TODO Auto-generated method stub
		
	}
	private static void dfsLinkedListIterative(GraphLinkedList g6) {
		// TODO Auto-generated method stub
		
	}
	private static void dfsLinkedListRecursive(GraphLinkedList list) {
		Set<Integer> v = new HashSet<>();
		for(int i = 0 ; i< list.graph.length; i++) { //iterate from all edges
			if(!v.contains(i)) {
				System.out.println("from source " +i);
				v.add(i);
				dfsLinkedListUtil(list, v , i);
			}
		}
		
	}
	
	private static void dfsLinkedListUtil(GraphLinkedList list, Set<Integer> v, int source ) {
		for(int node: list.graph[source]) {
			System.out.println("is node visted "+node+ " - "+v.contains(node) );
			if(!v.contains(node)) {
				System.out.println(node);
				v.add(node);
				dfsLinkedListUtil(list, v, node);
			}
		}
		
	}

	//////////////LIST - LIST///////////////////////
	private static void bfsList(GraphListList l) {
		// TODO Auto-generated method stub
		
	}

	private static void dfsListIterative(GraphListList l) {
		// TODO Auto-generated method stub
		
	}

	private static void dfsListRecursive(GraphListList l) {
		// TODO Auto-generated method stub
		
	}

	////////////////MATRIX////////////////////////
	public static void bfsMatrix(GraphMatrix g) {
		boolean visited[] = new boolean[g.adjM.length];
		bfsMatrix(0, g.adjM, visited);
	}
	
	
	public static void bfsMatrix(int start, int[][] adjM,  boolean[] v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		v[start] = true;
		queue.add(start);
		while (queue.size() != 0) {
			int x = queue.remove();
			System.out.println(x + " ");
			for (int i = 1; i < v.length; i++)
				if ((adjM[x][i] == 1) && (!v[i])) {
					System.out.println(adjM[x][i] + " x - "+x +" i - " +i +"adjM[x][i] ");
					queue.add(i);
					v[i] = true;
				}
		}
	}

	private static void dfsMatrixIterative(GraphMatrix m) {

	}

	private static void dfsMatrixRecursive(GraphMatrix m) {
	}
	
	
	///////////////////////MAP///////////////////////
	private static void bfsMap(GraphMap<String> dict) {
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		for (String vertex : dict.adjM.keySet()) { // disconnected
			if (!visited.contains(vertex)) {
				q.add(vertex);
				visited.add(vertex);
			}
			while (!q.isEmpty()) {
				String node = q.poll();
				System.out.println(node);
				for (String neighbor : dict.adjM.get(node)) {
					if (!visited.contains(neighbor)) {
						q.add(neighbor);
						visited.add(neighbor);
					}
				}

			}
		}
	}

	private static void dfsMapIterative(GraphMap<String> dict) {
		Set<String> visited = new HashSet<>();
		Stack<String> q = new Stack<>();
		for (String vertex : dict.adjM.keySet()) { // disconnected
			if (!visited.contains(vertex)) {
				q.add(vertex);
				visited.add(vertex);
			}
			while (!q.isEmpty()) {
				String node = q.pop();
				System.out.println(node);
				for (String neighbor : dict.adjM.get(node)) {
					if (!visited.contains(neighbor)) {
						q.add(neighbor);
						visited.add(neighbor);
					}
				}

			}
		}

	}

	private static void dfsMapRecursive(GraphMap<String> dict) {
		Set<String> v = new HashSet<>();
		for (String key : dict.adjM.keySet()) {
			if (!v.contains(key)) {
				v.add(key);
				System.out.println(key);
				dfsMapRecursiveHelper(dict, key, v);
			}
		}

	}

	private static void dfsMapRecursiveHelper(GraphMap<String> dict, String key, Set<String> v) {
		for (String node : dict.adjM.get(key)) {
			if (!v.contains(node)) {
				System.out.println(node);
				v.add(node);
				dfsMapRecursiveHelper(dict, node, v);
			}
		}

	}

}
