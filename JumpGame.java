package coding.graph;

public class JumpGame {
	//O(n)
	//1,3,5,8,9,2,6,7,6,8,9
	public static boolean canJumpGreedy(int nums[]) {
		int max_jump = 0;
		for(int i = 0; i<=nums.length-1; i++) {
			if(max_jump < i) return false;
			if(i + nums[i] >= nums.length - 1) return true;
			max_jump = Math.max(max_jump, i+nums[i]);
		}
		return false;
	}
	
	//O(n2) Dynamic bottom up
	public static boolean canJumpDynamic(int nums[], int start) {
		for(int i = nums.length - 2; i>=0; i--) {
			for(int j = i+1; j <= Math.min(i + nums[i], nums.length-1); j++) {
				if(memo[j] == 1) {
					memo[i]=1;
					break;
				}
			}
		}
		return memo[0] == 1 ? true:false;	
	}
	
	//O(n2) memoization top down
	public static int[] memo;
	public static boolean canJumpMemoization(int nums[], int start) {
		if(memo[start] != 0)
			return memo[start] == 1 ? true:false;
		int maxJump = Math.min(start+nums[start], nums.length-1);
		for(int nextJump = maxJump; nextJump>start; nextJump--) {
			if(canJumpMemoization(nums, nextJump)) {
				memo[start] = 1;
				return true;
			}
		}
		memo[start] = -1;
		return false;
			
	}
	
	//BackTracking O(2n)
	public static boolean canJump(int []nums, int pos) {
		if(pos >= nums.length-1) return true;
		int furtherjump = nums[pos];
		for(int nextJump = furtherjump; nextJump >pos; nextJump--) {
			if(canJump(nums, pos+nextJump) == true)
				return true;
		}
		return false;
	}
	
	//O(n2)
	public static boolean canJump(int[] nums) {
        int max = nums.length-1;
        for(int i = max; i>=0; i--){
            for(int j=i-1; j>=0; j--){
                if(i - j <= nums[j]){
                    if(max > j)
                        max = j;
                }
                
            }
            if(max == i) break;
        }
       
        return false;
    }
	public static void main(String [] args) {
		
		int nums[] = new int[] {3,2,1,0,4};
		memo = new int[nums.length];
		memo[nums.length - 1] = 1;
		System.out.println(canJumpGreedy(nums));
	}
}	
