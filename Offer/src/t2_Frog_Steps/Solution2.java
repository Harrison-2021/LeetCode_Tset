package t2_Frog_Steps;

public class Solution2 {
	 public int jumpFloorII(int n) {
	        if(n <= 0) return 0;
	        if(n == 1) return 1;
	        
	        return (int)Math.pow((double)2, (double)(n -1)) % 1000000007;
	    }
	 
	 public int jumpFloorII2(int n) {
	        if(n <= 0) return 0;
	        if(n == 1) return 1;
	        
	        int a = 1;
	        int ret = 1;
	        for(int i = 1; i < n; i ++) {
	        	ret = (2 * a) % 1000000007;
	        	a = ret;
	        }
	        return ret;
	    }
}
