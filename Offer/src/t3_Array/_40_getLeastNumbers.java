package t3_Array;

import java.util.*;

/**
 * @author ls2690069470 Offer 40. 最小的k个数
 */
public class _40_getLeastNumbers {
	public int[] getLeastNumbers(int[] arr, int k) {
		if (k == 0) {
			return new int[0];
		}

		Random rad = new Random();
		selectK(arr, 0, arr.length - 1, rad, k - 1);
		return Arrays.copyOf(arr, k);
	}

	private void selectK(int[] arr, int l, int r, Random rad, int k) {
		int p = partition(arr, l, r, rad);

		if (p == k)
			return;

		if (p < k) {
			selectK(arr, p + 1, r, rad, k);
		} else {
			selectK(arr, l, p - 1, rad, k);
		}
	}

	private int partition(int[] arr, int l, int r, Random rad) {
		int p = l + rad.nextInt(r - l + 1);
		swap(arr, l, p);

//		int i = l, j = r;
		int i = l, j = r + 1;
		while (true) {
//			while(i <= j && arr[i] < arr[l]) { // 等于区分点的数随机分配在两侧
//											   // 一定要让j越过,故i=j时，继续循环
//				i ++;
//			}
//			while(i <= j && arr[j] > arr[l]) {
//				j --;
//			}

			while (++i <= r && arr[i] < arr[l])
				; // 先自增或自减，一直循环下去
			while (--j >= l && arr[j] > arr[l])
				;

			if (i >= j)
				break; // 一定要让j越过，这样，j指向的是小于arr[p]的数，但还是i<=j,以防止初始条件i=l=j=r=0情况，防止数组越界

			swap(arr, i, j);
//			i ++; // 防止arr[i] = arr[p] = arr[l]情况，无法进入小的循环体，一直死循环
//			j --;
		}
		swap(arr, l, j);
		return j;
	}

	private void swap(int[] arr, int l, int p) {
		int temp = arr[l];
		arr[l] = arr[p];
		arr[p] = temp;

	}

	// 使用最大堆实现的优先队列
	// 此方法可以解决大容量问题
	public int[] getLeastNumbers2(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 标准库中的是最小堆
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) { // 先装进k个元素，再维护这k个元素
			pq.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (!pq.isEmpty() && arr[i] < pq.peek()) { // pq中的最大值都比要比较的元素小，那么前k个元素一定最小
				pq.remove();
				pq.add(arr[i]);
			}
		}

		int[] data = new int[k];
		for (int i = 0; i < k; i++) {
			data[i] = pq.remove();
		}
		return data;
	}

	// 简化代码
	public int[] getLeastNumbers3(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 默认是小根堆，实现大根堆需要重写一下比较器。
		Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
		for (int num : arr) {
			if (pq.size() < k) {
				pq.offer(num);
			} else if (num < pq.peek()) {
				pq.poll();
				pq.offer(num);
			}
		}

		// 返回堆中的元素
		int[] res = new int[pq.size()];
		int idx = 0;
		for (int num : pq) {
			res[idx++] = num;
		}
		return res;
	}
}
