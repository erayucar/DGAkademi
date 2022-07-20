
	import java.util.Stack;  
public class stack {

	public static void main(String[] args) {
	    
	    Stack<Integer> stk = new Stack<>();
	    
	    boolean result = stk.empty();  
	    System.out.println("Is the stack empty? " + result); 
	    stk.push(01);  
	    stk.push(02);  
	    stk.push(03);  
	    System.out.println("Elements in Stack: " + stk); 
	    stk.pop();
	    System.out.println("Elements in Stack: " + stk); 
	    stk.pop();
	    System.out.println("Elements in Stack: " + stk);  
	    
	    if (stk.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
	    


	}

}
