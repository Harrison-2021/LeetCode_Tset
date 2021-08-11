package t3_Array;

import java.util.*;

/**
 * @author ls2690069470
 *	Offer 40. 最小的k个数
 */
public class _40_getLeastNumbers {
	public int[] getLeastNumbers(int[] arr, int k) {
		if(k == 0) {
			return new int[0];
		}
		
		Random rad = new Random();
		selectK(arr, 0, arr.length - 1, rad, k - 1);
		return Arrays.copyOf(arr, k);
	}

	private void selectK(int[] arr, int l, int r, Random rad, int k) {
		int p = partition(arr, l, r, rad);
		
		if(p == k) return;
		
		if(p < k) {
			selectK(arr, p + 1, r, rad, k);
		} else {
			selectK(arr, l, p - 1, rad, k);
		}
	}

	private int partition(int[] arr, int l, int r, Random rad) {
		int p = l + rad.nextInt(r - l + 1);
		swap(arr, l, p);
		
		int i = l, j = r;
		while(true) {
			while(i <= j && arr[i] < arr[l]) { // 等于区分点的数随机分配在两侧
											   // 一定要让j越过,故i=j时，继续循环
				i ++;
			}
			while(i <= j && arr[j] > arr[l]) {
				j --;
			}
			
			if(i >= j) break; //一定要让j越过，这样，j指向的是小于arr[p]的数，但还是i<=j,以防止初始条件i=l=j=r=0情况，防止数组越界
			
			swap(arr, i, j);
			i ++;
			j --;
		}
		swap(arr, l, j);
		return j;
	}

	private void swap(int[] arr, int l, int p) {
		int temp = arr[l];
		arr[l] = arr[p];
		arr[p] = temp;
		
	}
}
