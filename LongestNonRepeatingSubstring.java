package coding.graph;

import java.util.HashSet;

public class LongestNonRepeatingSubstring {
	public static void main(String [] args){
		String str = "bcaabcbe";
		int i = 0, j = 0, maxlen = 0;
		HashSet<Character> hash = new HashSet<Character>();
		while(j < str.length()){
			if(!hash.contains(str.charAt(j))){
				hash.add(str.charAt(j));
				j++;
				maxlen = Math.max(maxlen, hash.size());
			}
			else{
				hash.remove(str.charAt(i));
				i++;
			}
		}
		System.out.println(maxlen);
	}
}
