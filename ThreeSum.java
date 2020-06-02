/**
 * 
 */
package coding.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author acer
 *
 */
public class ThreeSum {
		public static void main(String [] args) {
			int [] arr = new int[] {-1, 0, 1, 2, -1, -4};
			
			Set<List<Integer>> outList = new HashSet<List<Integer>>();
			List<List<Integer>> outListAs = new ArrayList<List<Integer>>();
			Map<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<arr.length; i++) {
				map.put(arr[i], i);
			}
			for(int i=0; i<arr.length-1; i++) {
				for(int j = i+1; j <arr.length; j++) {
					List<Integer> innerList = new ArrayList();
					if(map.containsKey(-(arr[i] + arr[j]))){
						int index = map.get(-(arr[i] + arr[j]));
						if(index != i && index != j) {
							innerList.add(arr[i]);
							innerList.add(arr[j]);
							innerList.add(-(arr[i]+arr[j]));
							innerList.sort(null);
							outList.add(innerList);
						}
					}
				}
				
			}
			outListAs.addAll(outList);
			System.out.print(outList);
		}
}
