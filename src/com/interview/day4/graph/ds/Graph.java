package com.interview.day4.graph.ds;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
	List<GraphNode<T>> list = new ArrayList<>();

	public void addEdge(T v1, T v2) {
		for (GraphNode<T> g : list) {
			if (g.val == v1) {
				g.neighbors.add(v2);
			} else {
				list.add(new GraphNode<T>(v1, v2));
			}
		}
	}
}

class GraphNode<T> {
	T val;
	List<T> neighbors = new ArrayList<>();

	GraphNode(T val, T neighbor) {
		this.val = val;
		neighbors.add(neighbor);
	}
}
