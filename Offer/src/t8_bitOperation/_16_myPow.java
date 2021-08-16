package t8_bitOperation;

/**
 * @author ls2690069470 Offer 16. 数值的整数次方
 */
public class _16_myPow {
	// 要考虑x为0情况，n为负数情况
	// 此种方法直接，但效率低
	public double myPow(double x, int n) {
		if (x == 0.0 && n < 0) {
			throw new IllegalArgumentException("invalidInput!");
		}

		int absN = n < 0 ? -n : n;

		double res = 1.0;
		for (int i = 0; i < absN; i++) {
			res *= x;
		}

		return n < 0 ? 1.0 / res : res;
	}

	// 递归法，二分法求解基本问题，再回溯到大问题
	// Java 代码中 int32 变量 n in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，
	// 因此当 n = -2147483648时执行 n=−n 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。

	public double myPow2(double x, int n) {
		if (x == 0.0 && n < 0) {
			throw new IllegalArgumentException("invalidInput!");
		}
		if (x == 0) {
			return 0;
		}

		long b = n;

		long absN = b < 0 ? -b : b;

		double res = recur(x, absN);

		return b < 0 ? 1.0 / res : res;
	}

	private double recur(double x, long n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		double result = recur(x, n >> 1);

		result *= result;
		if ((n & 1) == 1) {
			result *= x;
		}

		return result;
	}

	public double myPow3(double x, int n) {
		if (x == 0.0 && n < 0) {
			throw new IllegalArgumentException("invalidInput!");
		}
		if (x == 0) {
			return 0;
		}

		long b = n;
		double res = 1.0;

		if (b < 0) {
			x = 1.0 / x;
			b = -b;
		}

		while (b > 0) {
			if ((b & 1) == 1) {
				res *= x; // res记录初始时奇数中多余的x，要先判断，放在x原值改变
						  // 最后一次，b==1时，将之前的结果x赋值给res返回即可
			}
			x *= x;
			b >>= 1;
		}

		return res;
	}

	public static void main(String[] args) {
		double x = 1;
		int n = -2147483648;
		System.out.println(new _16_myPow().myPow2(x, n));
		System.out.println(Math.pow(1, -2147483648));
	}
}
