/**
 * This exception occurs when the postfix or infix expression has something wrong with it
 * 
 * @author Asem Shaath
 *
 */
public class InvalidNotationFormatException extends Exception
{

	public InvalidNotationFormatException(String message) 
	{
		super(message); 
	}

	
	public InvalidNotationFormatException() 
	{
		super("Notation format is incorrect");  
	}


}
