package coding.graph;

public class BitWiseAnd {
	
	public static int rangeBitwiseAnd(int m, int n) {
		 int count = 0;
	        while(m >= 0 && n >=0 && m!=n){
	            if(m == n)
	                break;
	            m = m>>1;
	            n = n>>1;
	            count++;
	        }
	        if(count == 0) return m;
	        else{
	            while(count > 0) {
	                m = m <<1;
	                count--;
	            }
	        }
	        return m;
		
	}
	public static void main(String []args) {
		int m = 16, n = 19;
		int res = rangeBitwiseAnd(m, n);
		System.out.println(res);
	}
}
