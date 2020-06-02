package coding.graph;

import java.util.HashMap;
import java.util.Map;


//Contigous subarray
public class SubArrayZeroAndOne {
	 public static int findMaxLength(int[] nums) {
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, -1);
	        int maxlen = 0, count = 0;
	        for (int i = 0; i < nums.length; i++) {
	            count = count + (nums[i] == 1 ? 1 : -1);
	            if (map.containsKey(count)) {
	                maxlen = Math.max(maxlen, i - map.get(count));
	            } else {
	                map.put(count, i);
	            }
	        }
	        return maxlen;
	    }
	public static void main(String []args) {
		int [] arr = new int[] {1,0,0,1};
		System.out.println(findMaxLength(arr));
		int count = 0;
		int count_subArray = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for(int i=0; i<arr.length; i++) {
			count+=arr[i] == 0 ? -1 : 1;
			if(map.containsKey(count)) {
				count_subArray = Math.max(count_subArray, i - map.get(count));
			}else {
				map.put(count, i);
			}
		}
		System.out.println(count_subArray);
	}
}
