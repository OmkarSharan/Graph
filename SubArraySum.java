package coding.graph;

import java.util.HashMap;
import java.util.Map;

//find all subarray Sum

public class SubArraySum {
	public static void subArrayWithGivenSum(int arr[], int k) {
		int i = 0, j = 0;
		int curr_sum = 0;
		while(j < arr.length) {
			if(curr_sum == k) {
				System.out.println(i+" "+j);
			}
			curr_sum+=arr[j];	
			if(curr_sum > k && i < arr.length) {
				curr_sum-=arr[i];
				i++;
			}else {
				j++;
			}
		}
	}
	
	public static void allSubArraySumDP(int arr[], int k) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		int dp[] = new int[sum+1];
		if(k == arr[0])
			dp[0] = 1;
		sum = arr[0];
		for(int i=1; i<arr.length; i++) {
			 sum+=arr[i];
			 dp[sum] = 1;
			 if(dp[sum - k] >= 1)
				 dp[i] = 1+ dp[sum-k];
		}
		for(int i=0; i<arr.length; i++)
			System.out.println(dp[i]);
	}
	public static int allSubArrayWithGivenSum(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int curr_sum = 0, count = 0;
		for(int i=0; i<arr.length; i++) {
			curr_sum+=arr[i];
			if(curr_sum == k) {
				count++;
				System.out.println(i);
			}
			if(map.containsKey(curr_sum - k)) {
				count+=map.get(curr_sum - k);
				System.out.println(i);
			}
			
			if(map.containsKey(curr_sum)) {
				map.put(curr_sum, map.get(curr_sum)+1);
			}else {
				map.put(curr_sum, 1);
			}
		}
		return count;
	}
	public static void main(String [] args) {
		int arr[] = new int[] {1,4,4,1, 5};
		int k = 5;
		allSubArraySumDP(arr, k);
		//subArrayWithGivenSum(arr, k);
	}
}
