package coding.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphUsingMatrix {
	private int row;
	private int col;
	private int[][] adjMatrix;
	private int set[];
	
	GraphUsingMatrix(int row, int col) {
		this.row = row;
		this.col = col;
		adjMatrix = new int[row+1][col+1];
		set = new int[row+1];
		for(int i=0; i<=row; i++)
			set[i] = -1;
	}
	
	public void addEdge(int u, int v) {
		 adjMatrix[u][v] = 1;
		 //adjMatrix[v][u] = 1;
	}
	
	public int find(int vertices) {
		if(set[vertices] == -1)
			return vertices;
		return find(set[vertices]);
	}
	
	public void union(int u, int v) {
		int x = find(u);
		int y = find(v);
		set[x] = y;
	}
	
	public int isCycle(GraphUsingMatrix graph) {
		int count = 0;
		for(int i=0; i<adjMatrix.length; i++) {
			for(int j=0; j<adjMatrix[0].length; j++) {
				if(adjMatrix[i][j] == 1) {
					int x = find(i);
					int y = find(j);
					if(x == y) {
						count++;
					}
					else 
						union(x, y);
				}
			}
		}
		return count;
	}
	
	public void dfs(int root, boolean[] visited) {
		visited[root] = true;
		System.out.print(root+" ");
		for(int i=0; i<col; i++) {
			if(adjMatrix[root][i] == 1 && !visited[i])
				dfs(i, visited);
		}
	}
	
	public void bfs(int root, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
			System.out.print(node+" ");
			for(int i=0; i<col; i++) {
				if(adjMatrix[node][i] == 1 && !visited[i])
					queue.add(i);
			}
		}
	}
	
	public static void main(String [] args) {
		int row = 6;
		int col = 6;
		GraphUsingMatrix graph = new GraphUsingMatrix(row, col);
		graph.addEdge(0, 0);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(1, 1);
		graph.addEdge(2, 2);
		
		System.out.println(graph.isCycle(graph));
//		boolean [] visited = new boolean[6];
//		System.out.print("DFS :");
//		graph.dfs(0, visited);
//		System.out.print("\nBFS: ");
//		visited = new boolean[6];
//		graph.bfs(0, visited);
		System.exit(0);
	}
	
}
