package coding.graph;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<=text1.length(); i++){
            for(int j=0; j<=text2.length(); j++){
                if(i == 0 || j == 0)
                    dp[i][j]=0;
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                
            }
        }
        return dp[text1.length()][text2.length()];
    }
	
	public static int longestCommonSubsequence(String text1, String text2, int m, int n) {
		if(m == 0 || n == 0) return 0;
		if(text1.charAt(m-1) == text2.charAt(n-1))
			return 1+longestCommonSubsequence(text1, text2, m-1, n-1);
		else
			return Math.max(longestCommonSubsequence(text1, text2, m, n-1), 
					longestCommonSubsequence(text1, text2, m-1,n));
		
	}
	
	public static void main(String [] args) {
		String text1 = "AGGTAB";
		String text2 = "GXTXAYB";
		int m = text1.length();
		int n = text2.length();
		System.out.println(longestCommonSubsequence(text1, text2));
		//System.out.println(longestCommonSubsequence(text1, text2, m, n));
		System.exit(0);
		
	}
}
