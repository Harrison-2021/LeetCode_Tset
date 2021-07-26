package t1_Fibonacci;

public class Fibonacci {	
	// recursion O(2^n)
	public int fib(int n) {		
		if(n == 0) return 0;
		if(n == 1) return 1;
	
		if(n > 1) {
			return fib(n -1) + fib(n -2);
		} else {
			return -1;
		}	
    }
	
	int mod = 1000000007;
	public int fib2(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		if(n > 1) {
			int a = 0;
			int b = 1;
			int ret = 0;
			for(int i = 0; i < n -1; i ++) {
				ret = (a + b) % mod;
				a = b;
				b = ret;
			}
			return ret % mod;
		} else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Fibonacci().fib2(45));
	}
}
