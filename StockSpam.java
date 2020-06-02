package coding.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class StockSpam {
	
	public static void calculateSpan(int[] price, int n, int []s) {
		int arr[] = new int[2];
		Stack<int []> stack= new Stack<>();
		arr[0] = price[0];
		arr[1] = 1;
		int i = 1;
		System.out.print("1 ");
		stack.push(arr);
		Queue<Integer> queue = new LinkedList();
		
		while(i < n) {
			int span = 1;
			int temp[] = new int[2];
			while(!stack.isEmpty() && stack.peek()[0] < price[i]) {
				span+=stack.pop()[1];
			}
			temp[0] = price[i];
			temp[1] = span;
			stack.push(temp);
			System.out.print(span+" ");
			i++;
		}
		
	}

	public static void main(String[] args) 
    { 
        int price[] = {10, 4, 5, 90, 120, 80}; 
        int n = price.length; 
        int S[] = new int[n]; 
  
        // Fill the span values in array S[] 
        calculateSpan(price, n, S); 
  
    } 

}
