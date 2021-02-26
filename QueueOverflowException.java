/**
 * This exception occurs when something happen while the queue is full 
 * 
 * @author Asem Shaath 
 *
 */
public class QueueOverflowException extends Exception
{

	public QueueOverflowException(String message) 
	{
		super(message);
	}
	
	
	public QueueOverflowException() 
	{
		super("enqueue method is called on a full queue");
	}

	

}
