package coding.graph;

public class BuyAndSell {

	public static void main(String[] args) {
		int prices[] = new int[] {1,4,5,7,6,3,2,9,0,0};
		int left[] = new int[prices.length] ;
		int right[] = new int[prices.length];
		int min_index = 0, max_index = 0, profit = 0;
		for(int i=0; i<prices.length; i++) {
			if(prices[i] >= prices[max_index])
				max_index = i;
			if(prices[i] < prices[min_index]) {
				min_index = i;
				if(min_index > max_index)
					max_index = min_index;
			}
			profit = Math.max(profit, prices[max_index] - prices[min_index]);
			left[i] = profit;
		}
		max_index = prices.length-1;
		min_index = prices.length-1;
		int netProfit = Integer.MIN_VALUE;
		profit = 0;
		for(int i = prices.length-1; i>=0; i--) {
			if(prices[i] >= prices[max_index]) {
				max_index = i;
				if(min_index > max_index) {
					min_index = max_index;
				}
			}
			if(prices[i] < prices[min_index]) {
				min_index = i;
			}
			if(min_index < max_index)
				profit = Math.max(profit, prices[max_index] - prices[min_index]);
			right[i] = profit;
		}
		
		for(int i=0; i<prices.length; i++) {
			netProfit = Math.max(netProfit, left[i]+right[i]);
		}
		
		System.out.println(netProfit);

	}

}

