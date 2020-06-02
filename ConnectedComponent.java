package coding.graph;

public class ConnectedComponent {
	public static void dfs(int root, int[][]M, int col, boolean[] visited) {
		visited[root] = true;
		for(int i=0; i<col; i++) {
			if(M[root][i] == 1 && !visited[i])
				dfs(i, M, col, visited);
		}
	}
	public static void main(String [] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
						          { 0, 0, 1, 0, 0 }, 
						          { 0, 0, 0, 0, 0 }, 
						          { 0, 0, 0, 0, 0 }, 
						          { 1, 0, 1, 0, 0 } }; 
		int row = M.length;
		int col = M[0].length;
		boolean []visited = new boolean[row];
		int count = 0;
		for(int i=0; i<col; i++) {
			if(!visited[i]) {
				dfs(i, M, col, visited);
				count++;
			}
		}
		System.out.println(count);
	}
}
