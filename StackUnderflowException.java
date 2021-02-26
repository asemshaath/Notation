/**
 * This exception occurs when something happen while the stack is empty
 * 
 * @author Asem Shaath
 *
 */
public class StackUnderflowException extends Exception
{

	public StackUnderflowException(String message) 
	{
		super(message);
	}
	
	public StackUnderflowException() 
	{
		super("occurs when a push method is called on an empty stack");
	}


}
