package coding.graph;

public class LongestIncreasingSubsequence {
	public static void main(String []args) {
		 int arr[] = {1,3,6,7,9,4,10,5,6}; 
	     int dp[] = new int[arr.length];
	     for(int i = 0; i<arr.length-1; i++) {
	    	 for(int j =i+1; j<arr.length; j++) {
	    		 if(arr[i] < arr[j])
	    			 dp[j] = Math.max(dp[j], 1+dp[i]);
	    	 }
	     }
	     int max = Integer.MIN_VALUE;
	     for(int i=0; i<arr.length; i++) {
	    	 if(dp[i] > max)
	    		 max = dp[i];
	    	 //System.out.print(dp[i]);
	     }
	     System.out.println(max+1);
	     
	}
}
 