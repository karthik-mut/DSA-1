package com.interview.graph.ds;

import java.util.LinkedList;

public class GraphLinkedList {

	public LinkedList<Integer> graph[];

	public GraphLinkedList(int size) {
		graph = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new LinkedList<>();
		}
	}

	public void addEdge(Integer v1, Integer v2) {
		graph[v1].add(v2);
		graph[v2].add(v1);
	}

	public void removeEdge(Integer v1, Integer v2) {
		graph[v1].remove(v2);
		graph[v2].remove(v1);
	}
}
