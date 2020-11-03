package com.interview.day5;

import java.util.List;
import java.util.Stack;

import com.interview.day4.graph.ds.GraphListList;

public class TopologicalSortDFS {

	public static void main(String[] args) {
		GraphListList G = new GraphListList(9);
		G.addEdge(2, 4, true);
		G.addEdge(2, 6, true);
		G.addEdge(4, 6, true);
		G.addEdge(2, 8, true);
		G.addEdge(4, 8, true);
		topSort(G.adjList);
	}

	public static void topSort(List<List<Integer>> adjLists) {
		int size = adjLists.size();
		boolean[] visited = new boolean[adjLists.size()];
		Stack<Integer> currentstack = new Stack<>();
		for (int i = 0; i < size; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				topSortHelper(i, adjLists, visited, currentstack);
			}
		}
		int g = currentstack.pop();
	}

	public static void topSortHelper(int start, List<List<Integer>> adjLists, boolean[] visited,
			Stack<Integer> currentstack) {
		for (int i = 0; i < adjLists.size(); i++) {
			if (visited[i] == false && !adjLists.get(i).isEmpty()) {
				visited[i] = true;
				topSortHelper(i, adjLists, visited, currentstack);
			}
		}
		currentstack.push(start);
	}

}
