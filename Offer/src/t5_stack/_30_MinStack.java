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
    	if(link.isEmpty() || link.peek() >= x) { // 注意一定包括=，防止重复最小值被弹出
    		link.push(x); // equals addFirst
    	}
    }
    
    public void pop() {
    	if(link.peek().equals(stack.peek())) {
    		link.pop(); // equals removeFirst().
    	}
    	stack.pop();
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

