package coding.graph;

public class CheckStraightLine {
	public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 0) return false;
        if(coordinates.length == 1) return true;
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        double slope =0.0;
        if(x2-x1 == 0) 
            slope = x2-x1;
        else
            slope = (double)Math.abs(y2-y1)/Math.abs(x2-x1);
        for(int i=2; i<coordinates.length; i++){
            int x2_x1 = (coordinates[i][0] - coordinates[i-1][0]);
            int y2_y1 = (coordinates[i][1] - coordinates[i-1][1]);
            if(x2_x1 == 0 && slope != x2_x1)
                return false;
            if(x2_x1 == 0)
                slope = x2_x1;
            else if((double)Math.abs(y2_y1)/Math.abs(x2_x1) != slope)
                return false;
            else
                slope = Math.abs(y2_y1)/Math.abs(x2_x1);
        }
        return true;
    }
	
	public static void main(String []args) {
		//[[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]
		int [][]coordinated = new int[][] {{-2,12},{2,-8},{6,-28},{-10,52},{-7,37},{4,-18},{7,-33},{1,-3},{-1,7},{8,-38}};
		System.out.println(checkStraightLine(coordinated));
	}
}
