package t5_stack;

import java.util.Stack;

public class _31_validateStackSequences {
	 public boolean validateStackSequences(int[] pushed, int[] popped) {
		 Stack<Integer> stack = new Stack<Integer>();
		 int index = 0;
		 
		 if(pushed.length != popped.length) {
			 return false;
		 }
		 
		 // pay attention to the time of push and pop
		 for(int k : pushed) {
			 stack.push(k);
			 while(!stack.isEmpty() && stack.peek() == popped[index]) {
				 stack.pop();
				 index ++;
			 }
		 }
		 
		 return stack.isEmpty();
	 }
	 
	 public static void main(String[] args) {
		 int[] pushed = {};
		 int[] popped = {};

		 System.out.println(
				 new _31_validateStackSequences().validateStackSequences(pushed, popped));
	 }
}
