package coding.graph;

public class PartitionSet {
	public static int partitonSetMinimumDifference(int arr[], int sum, int n, int totalSum) {
		if (n == 0)
			return Math.abs(sum - (totalSum - sum));
		return Math.min(partitonSetMinimumDifference(arr, sum + arr[n - 1], n - 1, totalSum),
				partitonSetMinimumDifference(arr, sum, n - 1, totalSum));
	}

	public static void main(String[] args) {
		int arr[] = new int[] {1,2,11,20};
		if(arr.length == 0) System.out.println("-1");
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++)
			totalSum += arr[i];
		System.out.println(partitonSetMinimumDifference(arr, 0, arr.length, totalSum));
	}
}
