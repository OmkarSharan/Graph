package coding.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargeSubArray {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
	      int t = sc.nextInt();
	      while(t-->0){
	          String[] nmk = sc.nextLine().split(" ");
	          int n = Integer.parseInt(nmk[0]);
	          int m = Integer.parseInt(nmk[1]);
	          int k = Integer.parseInt(nmk[2]);
	          int arr[] = new int[n];
	          int B[] = new int[n*m];
	          int j = 0;
	          for(int i=0; i<n; i++){
	              arr[i] = sc.nextInt();
	              B[j] = arr[i%n];
	              j++;
	          }
	          int sum = 0;
	          int count = 0;
	          Map<Integer, Integer> map = new HashMap<>();
	          map.put(0, 1);
	          for(int i=0; i<m*n; i++) {
	        	  sum+=B[i];
	        	  if(map.containsKey(sum - k))
	        		  count+=map.get(sum-k);
	        	  else if(sum <= 2*k)
	        		  
	          }
	          
	      }
	}
}
