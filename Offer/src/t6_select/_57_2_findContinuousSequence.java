package t6_select;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ls2690069470 Offer 57 - II. 和为s的连续正数序列
 */
public class _57_2_findContinuousSequence {
	// 难点一： 如何找到所有序列，同样需要两个指针，重点是如何维护两个指针，以及边界问题
	// 难点二： 如何记录正确的结果，返回指定的二维数组，需要用到容器类的动态数组，动态数组存的是一维数组，最后再转为二维数组即可
	public int[][] findContinuousSequence(int target) {
		if (target < 3)	return null;
		
		List<int[]> res = new ArrayList<int[]>();
		int small = 1, big = 2;
		int mid = (target + 1) / 2; // 取ceil
		int curSum = small + big; // curSum 要在循环前初始化，不能影响循环体的逻辑
		
		while(small < mid) { // 最少两个数，最小的数不能是target的一半，否则加上大的数就大于target
			if(curSum == target) {
				int[] data = new int[big - small + 1]; 
				for(int i = small; i <= big; i ++) { // 将序列中的每个元素加入数组中，可以指定初始索引
					data[i - small] = i; // 数组下标从0开始,记录好偏移量
				}
				res.add(data);
				// 寻早下一个序列，索引值需要推进
				big ++;
				curSum += big;
			} else if(curSum < target) {
				big ++;
				curSum += big;
			} else {
				curSum -= small; // 减序列，要先减，再改变small，否则减少的就不是最左边的值
				small ++;
			}
		}
		
		return res.toArray(new int[res.size()][]);
	}
}
