package com.interview.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Detect Cycle of
 * Directed
 * Undirected
 * 
 * Detect Cycle using
 * Colors
 * DFS
 * BFS
 * TopologicalSort
 * UnionFind
 * Indegree / Outdegree
 * 
 * @author MrudulaGazzala
 *
 */
public class DetectCycle {

	public static void main(String[] args) {
		Map<Integer, List<Integer>> adjM = new HashMap<>();
		
		detectCycleDirectedDFS(adjM);
		detectCycleDirectedBFS(adjM);
		
		detectCycleUnDirectedDFS(adjM);
		detectCycleUndirectedBFS(adjM);
		
		detectCycleDirectedColors(adjM);
		
		

	}

	private static void detectCycleDirectedColors(Map<Integer, List<Integer>> adjM) {
		// TODO Auto-generated method stub
		
	}

	private static void detectCycleUndirectedBFS(Map<Integer, List<Integer>> adjM) {
		// TODO Auto-generated method stub
		
	}

	private static void detectCycleDirectedBFS(Map<Integer, List<Integer>> adjM) {
		// TODO Auto-generated method stub
		
	}

	private static void detectCycleUnDirectedDFS(Map<Integer, List<Integer>> adjM) {
		// TODO Auto-generated method stub
		
	}

	private static void detectCycleDirectedDFS(Map<Integer, List<Integer>> adjM) {
		// TODO Auto-generated method stub
		
	}

}
