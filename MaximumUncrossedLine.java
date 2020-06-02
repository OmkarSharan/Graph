package coding.graph;

public class MaximumUncrossedLine {
	public static void main(String [] args) {
		int [] A = new int[] {1,1,3,5,3,3,5,5,1,1};
		int [] B = new int[] {2,3,2,1,3,5,3,2,2,1};
		int dp[][] = new int[A.length+1][B.length+1];
		for(int i=0; i<=A.length; i++) {
			for(int j=0; j<=B.length; j++) {
				if(i==0 || j == 0)
					dp[i][j] = 0;
				else if(A[i-1] ==B[j-1])
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				System.out.print(dp[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println(dp[A.length][B.length]);
	}
}
