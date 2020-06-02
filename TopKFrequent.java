package coding.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	
	public static int[] topKFrequentElement(int [] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
	     for (int num: nums)
	        map.put(num, map.getOrDefault(num, 0) + 1);
	     PriorityQueue<Integer> maxHeap = 
	    		 new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));
	     maxHeap.addAll(map.keySet());
	     int[] output = new int[k];
	     
	     for (int i = 0; i < k; i++)
	         output[i] = maxHeap.remove();
	     
	     return output;
	}
	public static void main(String [] args) {
		int arr[] = new int[] {1,2,2,3,3,3};
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++)
			list.add(arr[i]);
		Integer a = new Integer(2);
		Integer b = new Integer(4);
		System.out.println(b.compareTo(a));
		//Collections.sort(list);
		Pair[] pair = new Pair[4];
		pair[0].setA(2);
		pair[0].setB(1);
		pair[1].setA(1);
		pair[1].setB(3);
		Collections.sort(pair, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return compare(o1, o2);
			}
		});
	
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		int k = 2;
		System.out.println(topKFrequentElement(arr, k));
	}
}
