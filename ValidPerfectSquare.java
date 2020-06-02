package coding.graph;

import java.util.HashMap;
import java.util.Map;

public class ValidPerfectSquare {
	public static void main(String [] args) {
		long num = 808201;
		long left = 1;
        long right = 808201, mid=0, sqrt;
        int [][] trust = new int[4][4];
        
        while(left <= right){
            mid = (left + right)/2;
            sqrt = mid * mid;
            if(sqrt == num) {
            	System.out.println(mid);
            	break;
            }
            else if(sqrt > num)
                right = mid-1;
            else
                left = mid+1;
        }
		//System.out.println(mid);  
	}
}
