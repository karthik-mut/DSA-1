package com.interview.day4.graph.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomGraph<T> {

	boolean isDirected;
	int size;
	Map<T, List<T>> allVertex = new HashMap<>();

	CustomGraph(int size, List<Tuple<T>> t) {
		this.size = size;
		for (Tuple<T> e : t) {
			allVertex.getOrDefault(e.from, new ArrayList<>()).add(e.to);
		}

	}
}

class Tuple<T> {
	public T from;
	public T to;
}
