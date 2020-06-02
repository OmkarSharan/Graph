package coding.graph;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
	
	//Recursive solution
	public static int editDistance(String text1, String text2, int m, int n) {
		if(m == 0)
			return n;
		if(n == 0)
			return m;
		if(text1.charAt(m) == text2.charAt(n))
			return editDistance(text1, text2, m-1, n-1);
		return 1 + Math.min(editDistance(text1, text2, m-1, n-1),
				Math.min(editDistance(text1, text2, m-1, n), editDistance(text1, text2, m, n-1)));
		
	}
	
	//DP solutions
	
	public static int editDistanceDP(String text1, String text2, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1,  map.getOrDefault(1, 0)+1);
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0)
					dp[i][j] = j;
				else if(j == 0)
					dp[i][j] = i;
				else if(text1.charAt(i-1) == text2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
			}
		}
//		for(int i=0; i<=n; i++) {
//			for(int j=0; j<=m; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println("\n");
//		}
		return dp[m][n];
	}
	public static void main(String []args) {
		String text1 = "sunday", text2 = "saturday";
		System.out.println(editDistanceDP(text1, text2, text1.length()-1, text2.length()-1));
	}
}
