package com.interview.day4.graph.ds;

import java.util.ArrayList;
import java.util.List;

//** Tuple array
public class CustomGraphArray {
	boolean isDirected;
	List<Integer>[] graph;

	CustomGraphArray(int size, int[][] t) {
		this.graph = new ArrayList[size];
		for (int i = 0; i < t.length; i++) {
			graph[t[i][0]].add(t[i][1]);
		}

	}
}
