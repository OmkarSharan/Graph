package coding.graph;

public class BustBalloons {
	
	public static int maximumCoin(int [] num, int left, int right, int sum) {
		for(int i=left; i<=right; i++) {
			if(i == 0) {
				sum+=Math.max(sum, maximumCoin(num, i+1, right, sum+num[i]*num[i+1]));
			}
		}
	}
	public static void main(String [] args) {
		int num[] = new int[] {3,1,5,8};
		int sum = 0;
		System.out.println(maximumCoin(num, 0, num.length-1, sum));
	}
}
