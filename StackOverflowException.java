/**
 * This exception occurs when something happen while the stack is full
 * 
 * @author Asem Shaath
 *
 */
public class StackOverflowException  extends Exception
{

	public StackOverflowException(String message) 
	{
		super(message); 
	}

	
	public StackOverflowException() 
	{
		super("top or pop method is called on a full stack");  
	}


}
