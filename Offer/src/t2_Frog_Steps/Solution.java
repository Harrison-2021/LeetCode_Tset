package t2_Frog_Steps;

class Solution {
	int prime = 1000000007;
    public int numWays(int n) {
    	if(n == 0) return 1;
    	if(n == 1) return 1;
    	
    	if(n > 1) {
    		int a = 1;
    		int b = 1;
    		int ret = 0;
    		for(int i = 1; i < n; i ++) {
    			ret = (a + b) % prime;
    			a = b;
    			b = ret;
    		}
    		return ret;
    	} else {
    		return -1;
    	}
    }
}