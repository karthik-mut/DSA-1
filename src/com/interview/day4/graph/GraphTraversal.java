package com.interview.day4.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.interview.day4.graph.ds.GraphLinkedList;
import com.interview.day4.graph.ds.GraphMatrix;

public class GraphTraversal {

	public static void main(String[] args) {
		//Proper graph with Vertex object and Edge Object
		//dfsGraph();
		//bfsGraph();
		
		//Map or dictionary
		dfsMap();
		bfsMap();
		
		//Matrix
		GraphMatrix g4 = new GraphMatrix(5);
		g4.addEdge(1, 2);
		g4.addEdge(3, 4);
		g4.addEdge(1, 4);
		dfsMatrix(g4);
		bfsMatrix(g4);
		
		//LinkedList  and Array (limitation vertex should start from 0, still works ok, the size should be 
		//equal to last edge+1)
		GraphLinkedList g6 = new GraphLinkedList(7);
		g6.addEdge(1, 2);
		g6.addEdge(2, 3);
		g6.addEdge(3, 4);
		g6.addEdge(4, 6);
		g6.addEdge(1, 4);
		g6.addEdge(2, 4);
		dfsLinkedList(g6);
		bfsLinkedList(g6);
		
		//List of List - (limitation: vertex should start from 0)
		//TODO dfsList();
		//TODO bfsList();
		
		//Custom graph
		//TODO dfsCustomGraph();
		//TODO bfsCustomGraph();
	}

	private static void dfsLinkedList(GraphLinkedList list) {
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
	
	private static void bfsLinkedList(GraphLinkedList list) {
		Set<Integer> v = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		for(int i = 0 ; i < list.graph.length; i++) {
			q.add(e);
		}
		
	}

	private static void bfsMap() {
	}

	private static void dfsMap() {
	}

	
	public static void dfsMatrix(GraphMatrix g) {
		boolean visited[] = new boolean[g.adjM.length];
		dfsMatrix(0, g.adjM, visited);
	}
	
	public static void dfsMatrix(int start, int[][] allVertex,  boolean[] visited) {
		visited[start] = true;
		// For every node of the graph 
		for(int i=0 ; i < visited.length; i++ ) {
			// If some node is adjacent to the current node 
	        // and it has not already been visited 
			if(allVertex[start][i] == 1 && !visited[i]) {
				System.out.println(start+""+i +" - " +allVertex[start][i]);
				dfsMatrix(i, allVertex, visited);
			}
		}
	}
	
	public static void bfsMatrix(GraphMatrix g) {
		boolean visited[] = new boolean[g.adjM.length];
		bfsMatrix(0, g.adjM, visited);
	}
	
	
	public static void bfsMatrix(int start, int[][] adjM,  boolean[] v) {
		LinkedList<Integer> queue=new LinkedList<Integer>();
	    v[start]=true;
	    queue.add(start);
	    while(queue.size()!=0)
	    {
	        int x=queue.remove();
	        System.out.print(x+" ");
	        for (int i=1; i < v.length; i++) 
	            if((adjM[x][i] == 1) && (!v[i]))
	            {
	              queue.add(i);
	              v[i]=true;
	             }
	     }
	}
	
}
