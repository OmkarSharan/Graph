package coding.graph;

public class LongestPathInMatrix {
	
	public static boolean isSafe(int [][]mat, int i, int j) {
		if(i >=0 && i < mat.length && j >=0 && j < mat[0].length) 
			return true;
		return false;
	}
	
	public static int longestPathInMatrixDynamic(int [][] mat, int [][]dp, int i, int j) {
		if(i < 0 || i >= mat.length || j < 0 && j >= mat.length)
			return 0;
		if(dp[i][j] != 0)
			return dp[i][j];
		if(isSafe(mat, i+1, j) && mat[i][j] + 1 == mat[i+1][j])
			dp[i][j] = Math.max(dp[i][j], 1+longestPathInMatrixDynamic(mat, dp, i+1, j));
		if(isSafe(mat, i-1, j) && mat[i][j] + 1 == mat[i-1][j])
			dp[i][j] = Math.max(dp[i][j], 1+longestPathInMatrixDynamic(mat, dp, i-1, j));
		if(isSafe(mat, i, j+1) && mat[i][j] + 1 == mat[i][j+1])
			dp[i][j] = Math.max(dp[i][j], 1+longestPathInMatrixDynamic(mat, dp, i, j+1));
		if(isSafe(mat, i, j-1) && mat[i][j] + 1 == mat[i][j-1])
			dp[i][j] = Math.max(dp[i][j], 1+longestPathInMatrixDynamic(mat, dp, i, j-1));
		return dp[i][j];
		
	}
	public static int longestPathInMatrix(int[][] mat, int i, int j) {
		int [] x = new int[] {0, 0, -1, 1};
		int [] y = new int[] {1, -1, 0, 0};
		if(i > mat.length || j > mat[0].length )
			return 0;
		if(i < 0 || j < 0) return 0;
		for(int p=0; p<4; p++) {
			if(isSafe(mat, i+x[p], j+y[p]) && mat[i][j] +1 == mat[i+x[p]][j+y[p]])
				return 1 + longestPathInMatrix(mat, i+x[p], j+y[p]);
		}
		return 1;
	}
	
	public static void main(String [] args) {
		int[][] mat = new int[][] {{1,2,3},{4,3,4},{7,6,5}};
		int [][] dp = new int[mat.length][mat[0].length];
		//System.out.println(longestPathInMatrixDynamic(mat, dp, mat.length-1, mat[0].length-1));
		int min = Integer.MIN_VALUE;
//		for(int i=0; i<mat.length; i++) {
//			for(int j = 0; j<mat[0].length; j++) {
//				min = Math.max(min, longestPathInMatrix(mat, i, j));
//			}
//		}
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(dp[i][j] == 0)
					ans = Math.max(ans, longestPathInMatrixDynamic(mat, dp, i, j));
				
			}
		}
		System.out.println(ans+1);
	}
}
