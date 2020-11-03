package com.interview.graph.ds;

import java.util.ArrayList;
import java.util.List;

public class GraphListList {
	public List<List<Integer>> adjList = new ArrayList<>();

	public GraphListList(int size) {
		for (int i = 0; i < size; i++) {
			adjList = new ArrayList<>();
		}
	}

	public void addEdge(int v1, int v2) {
		adjList.get(v1).add(v2);
		adjList.get(v2).add(v1);
	}
	
	public void addEdge(int v1, int v2, boolean isDirected) {
		adjList.get(v1).add(v2);
		if (!isDirected) {
			adjList.get(v2).add(v1);
		}
	}
}
