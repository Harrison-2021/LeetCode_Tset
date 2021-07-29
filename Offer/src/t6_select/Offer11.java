package t6_select;

public class Offer11 {
	// 最小值两个特定：1.比左边值小，
	// 2，在最小值右侧元素，一定<=right,最小值左边元素，一定>=right
	public int minArray(int[] numbers) {
		int left = 0, right = numbers.length -1;
		
		while(left < right) { // 不能相等，否则一直死循环
			int mid = (left + right) >> 1;
		
			if(numbers[mid] > numbers[right]) { // 排除左边
				left = mid + 1;
			} else  if(numbers[mid] < numbers[right]){ // 排除右边
				right = mid;
			} else {
				right --;
			}
		}
		
		return numbers[left];
    }
}
