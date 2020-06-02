package coding.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int v;
	private LinkedList<Integer>adjacencyList[];
	boolean[] visited;
	Graph(int v) {
		this.v = v;
		visited = new boolean[v];
		adjacencyList = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adjacencyList[i] = new LinkedList();
		}
	}
	
	public void addEdge(int u, int v) {
		adjacencyList[u].add(v);
	}
	
	public void dfs(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		Iterator<Integer> it = adjacencyList[start].listIterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n])
				dfs(n);
			else return;
		}
	}
	
	public void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
			System.out.println(node);
			Iterator<Integer> it = adjacencyList[node].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String [] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		System.out.print("DFS : ");
		graph.bfs(0);
		System.exit(0);
	}
}
