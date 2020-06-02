package coding.graph;

public class NuberOfIsland {
	
	public static boolean isSafe(int[][] M, int u, int v) {
		int row = M.length;
		int col = M[0].length;
		if(u >= 0 && u < row && v >=0 && v < col) return true;
		return false;
	}
	
	public static void dfs(int [][]M, boolean[][]visited, int u, int v) {
		if(M[u][v] == 1)
			visited[u][v] = true;
		int[] x = new int[]{1,1,1,0};
		int[] y = new int[]{-1,0,1,1};
		for(int i=0; i<4; i++) {
			if(isSafe(M, u+x[i], v+y[i]) && M[u+x[i]][v+y[i]] == 1 && !visited[u+x[i]][v+y[i]])
				dfs(M, visited, u+x[i], v+y[i]);
		}
	}
	public static void dfsUtil(int [][]M, int row) {
		boolean [][]visited = new boolean[row][row];
		int count = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<row; j++) {
				if(!visited[i][j] && M[i][j] == 1) {
					dfs(M, visited, i, j);
					count++;
				}
			}
		}
		System.out.println("Number Of Island: "+count);
	}
	public static void main(String [] args) {
		int M[][] = new int[][] {  { 1, 1, 0, 0, 0 }, 
						            { 0, 1, 0, 0, 1 }, 
						            { 1, 0, 0, 1, 1 }, 
						            { 0, 0, 0, 0, 0 }, 
						            { 1, 0, 1, 0, 1 }
						        };
		int row = M.length;
		int col = M[0].length;
		dfsUtil(M, col);
		System.exit(0);
	}
}
