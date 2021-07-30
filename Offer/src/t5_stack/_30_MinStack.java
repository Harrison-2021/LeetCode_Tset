package t5_stack;

import java.util.LinkedList;
import java.util.Stack;

class _30_MinStack {
	private Stack<Integer> stack;
	private LinkedList<Integer> link;
	
    public _30_MinStack() {
    	stack = new Stack<Integer>();
    	link = new LinkedList<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(link.isEmpty()) {
    		link.addFirst(x);
    	} else if(link.peek() > x) {
    		link.addFirst(x);
    	}  else { // 注意一定要将两个容器size保持一致，否则会有空指针错误
    		link.addFirst(link.peek());
    	}
    }
    
    public void pop() {
    	stack.pop();
    	link.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int min() {
    	return link.peek();
    }
    
    public static void main(String[] args) {
    	_30_MinStack minStack = new _30_MinStack();
    	minStack.push(0);
    	minStack.push(1);
    	minStack.push(0);
    	System.out.println(minStack.min()); 	// -3
    	minStack.pop();
    	System.out.println(minStack.top());     // 0
    	System.out.println(minStack.min());		// -2

    }
}

