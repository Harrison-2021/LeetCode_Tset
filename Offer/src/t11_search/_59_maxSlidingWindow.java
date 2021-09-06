package t11_search;

import java.util.*;

/**
 * @author ls2690069470 Offer 59 - I. 滑动窗口的最大值
 */
public class _59_maxSlidingWindow {
	// 使用双端队列，用deque容器，入队时就判断比较，维持队首最大，同时，维持队列元素为k个
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0 || k <= 0) return new int[0];
		
		Deque<Integer> deque = new LinkedList<Integer>();
		int[] res = new int[nums.length - k + 1];
		
		for(int i = 1 - k, j = 0; j < nums.length; i ++, j ++) {	
			// 每次窗口移动，当形成窗口时，要再双端队列中先剔除原有的首元素
			if(i > 0 && deque.peekFirst() == nums[i - 1]) {
				deque.removeFirst();
			}
			// 每次加入新的数据后，要保证因窗口移动后，删除队首元素后新的队首还是最大，需要保证双端队列递减
			while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
				deque.removeLast();
			}
			// 每次都加入新的数据前，先要处理好队列的排序问题，看是否要删除原有队列元素
			deque.addLast(nums[j]);
			// 每轮将新的排好序的队列最大值放到输出结果中即可
			if(i >= 0) {
				res[i] = deque.peekFirst();
			}
		}
		return res;
	}
}
