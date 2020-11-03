package com.interview.day4.graph.ds;

public class GraphMatrix {

	public int[][] adjM;

	public GraphMatrix(int s) {
		adjM = new int[s][s];
	}
	
	public GraphMatrix(int[][] adjM) {
		this.adjM = adjM;
	}

	public void addEdge(int v1, int v2) {
		adjM[v1][v2] = 1;
		adjM[v2][v1] = 1;
	}

}