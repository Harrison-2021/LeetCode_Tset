package t5_stack;

import java.util.Stack;

public class Offer09 {
	Stack<Integer> inputS;
	Stack<Integer> outputS;

    public Offer09() {
        inputS = new Stack<Integer>();
        outputS = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        inputS.push(value);
    }
    
    public int deleteHead() {
        if (!outputS.isEmpty()) {
        	return outputS.pop();
        } 
        // 不能单独用inputS来判定队列是否为空，当两个栈都为空时，队列为空
        // 注意判断的顺序性
        else {
            while (!inputS.isEmpty()) {
                outputS.push(inputS.pop());
            }
            return outputS.isEmpty() ? -1 : outputS.pop();
        } 
    }
}
