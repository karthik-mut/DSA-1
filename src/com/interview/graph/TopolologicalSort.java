package com.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.interview.graph.ds.GraphMap;

/**
 * Directed
 * Undirected - Not possible if it's not DAG
 * 
 * using
 * DFS
 * BFS
 * indegree/outdegree
 * 
 * 
 * @author MrudulaGazzala
 *
 */
public class TopolologicalSort {

	public static void main(String[] args) {
		Integer[] v = new Integer[] { 0,1,2,3,4,5 };
		GraphMap<Integer> dict = new GraphMap<>(v);
		dict.addEdge(5,0, true );
		dict.addEdge(5,2, true);
		dict.addEdge(2,3, true);
		dict.addEdge(3,1, true);
		dict.addEdge(4,0, true);
		dict.addEdge(4,1, true);
		
		Stack<Integer> result = topSortDirectedDFS(dict.adjM);
		while(!result.isEmpty()){
            System.out.println(result.pop());
        }
		
		topSortUsingDegreeKahn(dict.adjM);
		
		String[] v2 = new String[] { "D","E","B","C","A","F" };
		GraphMap<String> dict2 = new GraphMap<>(v2);
		dict2.addEdge("D","B", true );
		dict2.addEdge("D","C", true);
		dict2.addEdge("E","C", true);
		dict2.addEdge("E","F", true);
		dict2.addEdge("B","A", true);
		dict2.addEdge("A","F", true);
		
		Stack<String> result2 = topSortDirectedDFS(dict2.adjM);
		while(!result.isEmpty()){
            System.out.println(result2.pop());
        }

	}


	/////////////////////////DFS//////////////////////////////////////////////////////
	private static <T> Stack<T> topSortDirectedDFS(Map<T, List<T>> adjM) {
		Stack<T> stack = new Stack<>();
		Set<T> visited = new HashSet<> ();
		for(T vertex : adjM.keySet()) {
			if(visited.contains(vertex))
				continue;
			topSortUnDirectedDFSUtil(stack, adjM, vertex, visited);
		}
		return stack;
	}

	private static <T> void topSortUnDirectedDFSUtil(Stack<T> stack, Map<T, List<T>> adjM, T vertex, Set<T> visited) {
		visited.add(vertex);
		for(T node: adjM.get(vertex)) {
			// visited[i] == false
			if(visited.contains(node)) 
				continue;
			topSortUnDirectedDFSUtil(stack, adjM, node, visited);
		}
		stack.push(vertex);
		
	}

	public static <T> void topSortUsingDegreeKahn(Map<T, List<T>> map) {
		Queue<T> queue = new LinkedList<>();
		List<T> sortedList = new ArrayList<>();
		int[] indegree= new int[map.size()];

		// Traverse adjacency lists to fill indegrees of 
        // vertices. This step takes O(V+E) time         
        for(T vertex : map.keySet()) 
        { 
            ArrayList<Integer> temp = (ArrayList<Integer>) map.get(vertex); 
            for(int node : temp) { 
                indegree[node]++; 
            } 
        } 
        
		// The initial state of the algorithm requires the addition of indegree = 0 nodes */
		int index = 0;
		for (T vertex : map.keySet()) {
			if (indegree[index] == 0)
				queue.add(vertex);
			index++;
		}
		
		// Loop through the entire list until the indegrees of all nodes become zero
		while (!queue.isEmpty()) {

			T vertex = queue.poll();
			sortedList.add(vertex);
			List<T> neighbors = map.get(vertex);
			int i = 0;
			for (T node : neighbors) {
				indegree[index]--;
				if (indegree[i] == 0) {
					queue.add(node);
				}
				i++;
			}
		}
		// print the final sorted list
		for (int i = 0; i < sortedList.size(); i++)
			System.out.print(sortedList.get(i) + " ");

	}
}
