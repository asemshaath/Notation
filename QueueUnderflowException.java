/**
 * This exception occurs when something happen while the queue is empty
 * 
 * @author Asem Shaath
 *
 */
public class QueueUnderflowException extends Exception{

	public QueueUnderflowException(String message) 
	{
		super(message); 
	}
	
	
	public QueueUnderflowException() 
	{
		super("dequeue method is called on an empty queue"); 
	}

	

}
