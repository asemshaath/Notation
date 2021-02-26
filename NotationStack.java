import java.util.ArrayList;

/**
 * This class is a student made Stack class 
 * 
 * @author Asem Shaath
 *
 * @param <Thing>
 */
public class NotationStack <Thing> implements StackInterface<Thing> 
{
	
	//private int topLocation;
	
	/**
	 * the capacity of the stack
	 */
	private int maxSize; 
	
	/**
	 * the arraylist of the stack
	 */
	private ArrayList<Thing> data; 

	/**
	 * This is a constructor that takes a specific size of the stack
	 * @param size of the stack
	 */
	public NotationStack(int maxSize)
	{
		this.maxSize = maxSize;
		//this.topLocation = -1;
		this.data = new ArrayList<Thing>(maxSize); 
	}
	
	/**
	 * This is a constructor that uses a default stack size of 10 elements
	 */
	public NotationStack() 
	{
		this.maxSize = 10;
		//this.topLocation = -1;
		this.data = new ArrayList<Thing>(maxSize); 
	}

	/**
	 * This method checks if the stack is empty or not
	 *  
	 * @return true if the stack is empty and false if it's not empty 
	 *  
	 */
	@Override
	public boolean isEmpty() 
	{
		
		return data.isEmpty();

	}

	/**
	 * This method checks if the stack is full or not
	 * 
	 * @return true if the stack is full and false if the stack isn't full 
	 */
	@Override
	public boolean isFull() 
	{
		if(data.size() == maxSize ) 
		{
			//System.out.println("top element is located at index: " + topLocation);
			return true;
		}
		else 
		{
			//System.out.println("top element is located at index: " + topLocation);
			return false;
		}
	}

	/**
	 * This method remove the top element of the stack and return it 
	 * 
	 * @return the popped element 
	 * @throws StackUnderflowException
	 */
	@Override
	public Thing pop() throws StackUnderflowException 
	{
		
		Thing topElement; 
		int tempLocation; 
		
		if(isEmpty() == true) 
		{
			throw new StackUnderflowException(); 
		}
		else
		{
			
			tempLocation = data.size() - 1; 
			topElement = data.get(tempLocation); 
			data.remove(tempLocation); 
			//topLocation--; 
			
			return topElement; 
			
		}
		//return null;
	}

	/**
	 * This method return the top element of the stack, but it do not remove the element 
	 * 
	 * @return top element
	 * @throws StackUnderflowException
	 */
	@Override
	public Thing top() throws StackUnderflowException 
	{
		
		Thing topElement; 
		
		//System.out.println("From top method " + isEmpty()); 
		
		if(isEmpty() == true) 
		{
			throw new StackUnderflowException(); 
		}
		else
		{
			topElement = data.get(data.size() - 1); 		
			return topElement; 
		}
		
	}

	/**
	 * This method is to check the number of the elements in the stack
	 * 
	 * @return number of elements
	 */
	@Override
	public int size() 
	{
		return data.size();
	}

	/**
	 * This method add a new element at the top of the stack (if it's not empty)
	 * 
	 * @param element that need to be added
	 * @return true if the element is added, otherwise; throw an error
	 * @throws StackOverflowException
	 */
	@Override
	public boolean push(Thing e) throws StackOverflowException 
	{
		        
		if(isFull() == true) 
		{
			
			//System.out.println("Stack overflow");
			throw new StackOverflowException(); 
			
		}
		else
		{
			data.add(e);
			//topLocation++;
			return true; 
		}
		
	}

	/**
	 * This method puts all the elements in one string with no delimiters
	 * 
	 * @return string of elements 
	 */
	@Override
	public String toString() 
	{
		
		String printedStuff = ""; 
		
		for(int i = 0; i < data.size(); i++)
		{
			
			printedStuff += String.valueOf(data.get(i)); //data.get(i); 
			
		}
		
		return printedStuff;	
	}
	
	/**
	 * This method puts all the elements in one string with a given delimiters
	 * 
	 * @return string of elements
	 */
	@Override
	public String toString(String delimiter) 
	{

		
		String printedStuff = ""; 
		
		for(int i = 0; i < data.size(); i++)
		{
			
			if(i == data.size() - 1)
				printedStuff += data.get(i); 
			else
				printedStuff += data.get(i) + delimiter; 
			
		}
		
		return printedStuff;
	}

	/**
	 * this method fills a given arrayList in the stack
	 * @param given arrayList
	 */
	@Override
	public void fill(ArrayList<Thing> list) 
	{
		
		data = new ArrayList<Thing>(list);
		
	}

	

}
