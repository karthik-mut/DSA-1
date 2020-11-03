package com.interview.graph.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphMap<T> {

	public Map<T, List<T>> adjM = new HashMap<>();
	public int[] inDegree;
	public int[] outDegree;
	
	public GraphMap(T[] vertices) {
		for (T i : vertices) {
			adjM.put(i, new ArrayList<>());
		}
		inDegree = new int[vertices.length];
		outDegree = new int[vertices.length];
		
	}

	public void addEdge(T v1, T v2) {
		adjM.get(v1).add(v2);
		adjM.get(v2).add(v1);
	}

	public void addEdge(T v1, T v2, boolean isDirected) {
		adjM.get(v1).add(v2);
		if(isDirected)
			adjM.get(v2).add(v1);
	}
}
