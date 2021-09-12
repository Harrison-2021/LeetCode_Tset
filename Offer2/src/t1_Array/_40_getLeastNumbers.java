package t1_Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class _40_getLeastNumbers {
//	����topK�����⣬���������򷨣�Ҳ���������������
	// ����һ������,ע�⣬����ȫ�����У�ֻ�轫ǰk���źž��У��ÿ�������
	public int[] getLeastNumbers(int[] arr, int k) {
		if(k == 0) return new int[0];
		
		quickSort(arr, k - 1);
		return Arrays.copyOf(arr, k);
	}

	private void quickSort(int[] arr, int k) {
		Random rad = new Random();
		quickSort(arr, 0, arr.length - 1, rad, k);		
	}
	
	private void quickSort(int[] arr, int left, int right, Random rad, int k) {	
		int p = partition(arr, left, right, rad);
		
		if(p == k) return;
		if(p < k) {
			quickSort(arr, p + 1, right, rad, k);
		} else {
			quickSort(arr, left, p - 1, rad, k);
		}
		
	}

	private int partition(int[] arr, int left, int right, Random rad) {
		int index = left + rad.nextInt(right - left + 1);
		swap(arr, left, index);
		
		int i = left + 1, j = right;
		while(true) {
			while(i <= j && arr[i] < arr[left]) {
				i ++;
			}
			while(i <= j && arr[j] > arr[left]) {
				j --;
			}
			
			if(i >= j) break;
			
			if(arr[i] != arr[j]) {
				swap(arr, i, j);
			}
			
			i ++;
			j --;
		}
		swap(arr, left, j);
		return j;
	}

	private void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;		
	}

	// ʹ������ʵ�ֵ����ȶ���
	// �˷������Խ������������
	public int[] getLeastNumbers2(int[] arr, int k) {
		if(arr.length == 0 || k <= 0) return new int[0];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
		for(int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		
		for(int i = k; i < arr.length; i ++) {
			if(!pq.isEmpty() && arr[i] < pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		int[] data = new int[k];
		for(int i = 0; i < k; i++) {
			data[i] = pq.remove();
		}
		return data;
	}
}
