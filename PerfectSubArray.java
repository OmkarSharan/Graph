package coding.graph;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class PerfectSubArray {
	 public static void main(String args[] ) throws Exception {
	        /* Sample code to perform I/O:
	         * Use either of these methods for input

	        //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String name = br.readLine();                // Reading input from STDIN
	        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

	        //Scanner
	        Scanner s = new Scanner(System.in);
	        String name = s.nextLine();                 // Reading input from STDIN
	        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

	        */

	        // Write your code here
	        
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        for(int i=0; i<n; i++){
	            arr[i] = sc.nextInt();
	        }

	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0,1);
	        int sum = 0;
	        int count = 0;
	        int minSum = 0;
	        for(int i=0; i<n; i++){
	        	sum+=arr[i];
	        	if(sum < minSum )
	        		minSum = sum;
	            for(int j = 0; sum - j*j>=minSum; j++){
	                if(map.get(sum - j*j) != null)
	                    count+= map.get(sum-j*j);
	            }
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	            
	        }
	        System.out.println(count);

	    }
}
