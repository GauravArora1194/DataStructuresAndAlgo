package com.interview.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	static class Edge {

		int src;
		int neighbour;
		int weight;

		Edge(int src, int neighbour, int weight) {

			this.src = src;
			this.neighbour = neighbour;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {

		int vertices = 7;

		List<Edge>[] graph = new ArrayList[vertices];

		for (int i = 0; i < vertices; i++) {

			graph[i] = new ArrayList<>();
		}
	}

}
