package t5_stack;

import java.util.Stack;

public class Offer09 {
	Stack<Integer> inputS;
	Stack<Integer> outputS;
	int size;
	
	public Offer09() {
		inputS = new Stack<Integer>();
		outputS = new Stack<Integer>();
		size = 0;
    }

    public void appendTail(int value) {
    	inputS.push(value);
    	size ++;
    }
    
    public int deleteHead() {
    	if(this.size != 0) {
			if(outputS.size() == 0) {
	    		while(inputS.size() > 0) {
		    		outputS.push(inputS.pop());
		    	}
	    		size --;
	    		return outputS.pop();
			} 
			else {
				size --;
	    		return outputS.pop();
	    	} 
    	} else {
    		return -1;
    	}
    }
}
