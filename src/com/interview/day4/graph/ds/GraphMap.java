package com.interview.day4.graph.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphMap<T> {

	Map<T, List<T>> gm = new HashMap<>();

	GraphMap(T[] vertices) {
		for (T i : vertices) {
			gm.put(i, new ArrayList<>());
		}
	}

	public void addEdge(T v1, T v2) {
		gm.get(v1).add(v2);
		gm.get(v2).add(v1);
	}
}
