package coding.graph;

import java.util.HashMap;
import java.util.Map;

public class RedundentConnection {

	static int find(int []parent, int u) {
		if(parent[u] != u)
			parent[u] = find(parent, parent[u]);
		return parent[u];
	}
	
	static void union(int []parent, int x, int y, int rank[]) {
		//int x = find(parent, u);
		//int y = find(parent, v);
		if(x == y)
			return;
		if(rank[x] < rank[y])
			parent[x] = y;
		else if(rank[x] < rank[y])
		    parent[y] = x;
		else {
			parent[x] = y;
			rank[x] = rank[x]+1;
		}
	}
	public static void main(String[] args) {
		int [][] mat = new int[][] {{1, 1, 0},{1, 1, 0},{0,0,1}};
		int n = mat.length;
		int [] parent = new int[n];
		int [] rank = new int[n];
		for(int i=0; i<parent.length; i++)
			parent[i] = i;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(mat[i][j] == 1) {
					int x = find(parent, i);
					int y = find(parent, j);
					union(parent, x, y, rank);
				}
			}
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			map.put(find(parent, parent[i]), i);
		}
		System.out.println(map.size());
	}

}
