package com.interview.graph.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//** Tuple array - Most of graph problems in leetcode are this input

public class CustomGraph<T> {
	boolean isDirected;
	
	List<T>[] list;
	Map<Integer, List<T>> dict = new HashMap<>();

	//Input given array of tuples and size
	CustomGraph(int size, T[][] t) {
		this.list = new ArrayList[size];
		for (int i = 0; i < t.length; i++) {
			if(list[(int) t[i][0]] == null)
				list[(int) t[i][0]] = new ArrayList<>();
			list[(int) t[i][0]].add(0, t[i][1]);
		}

	}
	
	//Input given String of words
	CustomGraph(String[] words) {
		this.list = new ArrayList[words.length];
		for (int i = 0; i < words.length; i++) {
			if(list[i] == null)
				list[i] = new ArrayList<>();
			list[i].add((T) words[i]);
		}

	}
	
//	CustomGraph(List<List<String>> words) {
//		this.list = new ArrayList[words.size()];
//		for (int i = 0; i < words.size(); i++) {
//			//list[t[i][0]].add(t[i][1]);
//			dict.getOrDefault(i, (List<T>) new ArrayList<String>()).add(words.get(i).get)
//		}
//
//	}
//	
//	CustomGraph(List<List<Integer>> cost) {
//		this.graph = new ArrayList[cost.size()];
//		for (int i = 0; i < t.length; i++) {
//			graph[t[i][0]].add(t[i][1]);
//		}
//
//	}
}
