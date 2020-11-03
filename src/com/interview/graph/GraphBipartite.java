package com.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.interview.graph.ds.GraphMap;

/**
 * 
 * @author MrudulaGazzala
 *
 */
public class GraphBipartite {

	public static <T> boolean isBiparteBFS(Map<T, List<T>> graph) {

		Set<T> redSet = new HashSet<>();
		Set<T> blueSet = new HashSet<>();

		Queue<T> queue = new LinkedList<>();

		for (T vertex : graph.keySet()) {
			if (!redSet.contains(vertex) && !blueSet.contains(vertex)) {
				queue.add(vertex);
				redSet.add(vertex);
				while (!queue.isEmpty()) {
					vertex = queue.poll();
					for (T v : graph.get(vertex)) {
						if (redSet.contains(vertex)) {
							if (redSet.contains(v)) {
								return false;
							}
							if (blueSet.contains(v)) {
								continue;
							}
							blueSet.add(v);
						} else if (blueSet.contains(vertex)) {
							if (blueSet.contains(v)) {
								return false;
							}
							if (redSet.contains(v)) {
								continue;
							}
							redSet.add(v);
						}
						queue.add(v);
					}
				}
			}
		}
		System.out.println(redSet);
		System.out.println(blueSet);
		return true;
	}

	public static <T> boolean isBiparteDFS(Map<T, List<T>> graph) {
		Set<T> redSet = new HashSet<>();
		Set<T> blueSet = new HashSet<>();
		for (T vertex : graph.keySet()) {
			if (redSet.contains(vertex) || blueSet.contains(vertex)) {
				continue;
			}
			boolean flag = isBiparteDFS(graph, vertex, redSet, blueSet, true);
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	private static <T> boolean isBiparteDFS(Map<T, List<T>> graph, T vertex, Set<T> redSet, Set<T> blueSet,
			boolean wasRed) {

		if (wasRed) {
			if (redSet.contains(vertex)) {
				return false;
			} else if (blueSet.contains(vertex)) {
				return true;
			}
			System.out.println("adding blue " + vertex);
			blueSet.add(vertex);
		}

		else if (!wasRed) {
			if (blueSet.contains(vertex)) {
				return false;
			}
			if (redSet.contains(vertex)) {
				return true;
			}
			System.out.println("adding red " + vertex);
			redSet.add(vertex);
		}

		for (T adj : graph.get(vertex)) {
			boolean flag = isBiparteDFS(graph, adj, redSet, blueSet, !wasRed);
			if (!flag) {
				return false;
			}
		}
		return true;

	}

	public static void main(String argsp[]) {
		Integer[] v = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		GraphMap<Integer> graph = new GraphMap<>(v);
		graph.addEdge(1, 2, true);
		graph.addEdge(2, 5, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(3, 4, true);
		graph.addEdge(4, 6, true);
		graph.addEdge(5, 6, true);
		graph.addEdge(7, 9, true);
		graph.addEdge(7, 8, true);
		boolean result = isBiparteDFS(graph.adjM);
		System.out.print(result);
	}

}
