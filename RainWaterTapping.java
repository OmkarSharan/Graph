package coding.graph;

public class RainWaterTapping {
	
	public static int trapRainWater(int[][] heightMap) {
        int totalAmount = 0;
        int n = heightMap.length;
        int m = heightMap[0].length;
        for(int i=1; i<n-1; i++) {
        	for(int j=0; j<)
        }
        for(int i = 1; i<heightMap.length-1; i++){
            int leftMax = heightMap[i][1];
            int rightMax = heightMap[i][heightMap[0].length-1];
            int tatalMax = 0;
            for(int j=1; j<heightMap[0].length-1; j++){
                for(int k = j; k>=0; k--)
                    if(leftMax < heightMap[i][k])
                        leftMax = heightMap[i][k];
                for(int k=j; k<heightMap[0].length; k++)
                    if(rightMax < heightMap[i][k])
                        rightMax = heightMap[i][k];
                tatalMax = Math.min(Math.min(Math.min(leftMax, rightMax), heightMap[i-1][j]),  heightMap[i+1][j]);
                if(tatalMax > heightMap[i][j])
                    totalAmount+= tatalMax - heightMap[i][j];
            }
        }
        return totalAmount;
    }
	public static int getTotalVolumeWater(int [] buildings) {
		int n = buildings.length;
		int totalWaterVolume  = 0;
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		leftMax[0] = buildings[0];
		rightMax[n-1] = buildings[n-1];
		for(int i=1; i<n; i++) {
			leftMax[i] = Math.max(leftMax[i-1], buildings[i]);
		}
		for(int i=n-2; i>=0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], buildings[i]);
		}
		for(int k=1; k<n-1; k++) {
			totalWaterVolume+=Math.min(Math.max(buildings[k], leftMax[k-1]), Math.max(buildings[k], rightMax[k+1]))-buildings[k];
		}
		return totalWaterVolume;
	}
	public static void main(String[] args) {
		int [] buildings = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		int [][] building = new int[][] {{12,13,1,12},
										 {13,4,13,12},
										 {13,8,10,12},
										 {12,13,12,12},
										 {13,13,13,13}};
		
		System.out.println(trapRainWater(building));
		//System.out.println(getTotalVolumeWater(buildings));
	}
}
