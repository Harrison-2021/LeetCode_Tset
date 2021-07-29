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
        if (outputS.isEmpty()) {
            while (!inputS.isEmpty()) {
                outputS.push(inputS.pop());
            }
        } 
        if (outputS.isEmpty()) {
            return -1;
        } else {
            int deleteItem = outputS.pop();
            return deleteItem;
        }
    }
}
