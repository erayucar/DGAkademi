	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Stack;  
public class queue {

	 

	
	    public static void main(String[] args) {

	    
	   
	      
	        Queue<String> queue = new LinkedList<String>();
	 
	        queue.add("E"); 
	        queue.add("R");    
	        queue.add("A");  
	        queue.add("Y");    
	       
	        System.out.println("Queue  is " + queue);
	        
	        System.out.println("The front element is " + queue.peek());
	 
	        System.out.println("Removing " + queue.remove());    
	        System.out.println("Removing " + queue.remove()); 
	 
	        System.out.println("The front element is " + queue.peek());
	 
	        System.out.println("Queue  is " + queue);
	        
	        System.out.println("The queue size is " + queue.size());
	 
	        // check if the queue is empty
	        if (queue.isEmpty()) {
	            System.out.println("The queue is empty");
	        }
	        else {
	            System.out.println("The queue is not empty");
	        }
	      
	    }
	
}