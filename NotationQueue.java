import java.util.ArrayList;

/**
 * This is a student made queue class
 * 
 * @author Asem Shaath 
 *
 * @param <Thing>
 */
public class NotationQueue<Thing> implements QueueInterface<Thing> {

	/**
	 * the capacity of the queue 
	 */
	private int maxSize; 
	
	/**
	 * the queue data 
	 */
	private ArrayList <Thing> data; 
	
	/**
	 * This a constructor that sets the capacity to a specific chosen value 
	 * 
	 * @param maxSize
	 */
	public NotationQueue(int maxSize) 
	{
		
		this.maxSize = maxSize;
		this.data = new ArrayList<Thing>(maxSize); 
		
	}
	
	/**
	 * This is a constructor that sets the capacity to default value which is 10 elements 
	 */
	public NotationQueue() 
	{
		
		this.maxSize = 10;
		this.data = new ArrayList<Thing>(maxSize); 
		
	}


	/**
	 * this method checks if the queue is empty or not 
	 * 
	 * @return true if the queue is empty, and false if it's not empty 
	 */
	@Override
	public boolean isEmpty() 
	{
		
		if(data.isEmpty() == true)
			return true;
		else
			return false;
		
	}

	/**
	 * This method checks if the queue is full or not 
	 * 
	 * @return true if it's full, and false if it's not full 
	 */
	@Override
	public boolean isFull() 
	{
		
		if(data.size() == maxSize)
			return true;
		else
			return false;
		
	}

	/**
	 * This method deletes and returns the first element in the queue 
	 * 
	 * @return first element 
	 */
	@Override
	public Thing dequeue() throws QueueUnderflowException 
	{
		
		Thing firstElement; 
		
		if(isEmpty() == true) 
		{
			throw new QueueUnderflowException(); 
		}
		else
		{
			
			firstElement = data.get(0); 
			data.remove(0); 
			return firstElement; 
		}
		
	}

	/**
	 * This method checks the number of elements in the queue 
	 * 
	 * @return number of elements 
	 */
	@Override
	public int size() 
	{
		return data.size();
	}

	/**
	 * This method adds an element to the end of the queue 
	 * 
	 * @param  the given element 
	 * @return true if the element is added, otherwise; throw an error
	 */
	@Override
	public boolean enqueue(Thing e) throws QueueOverflowException 
	{
		
		if(isFull() == true)
		{
			throw new QueueOverflowException(); 
		}
		else 
		{
			
			data.add(e); 
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
			
			printedStuff += data.get(i); 
			
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
	 *  this method fills a given arrayList in the stack
	 * @param given arrayList
	 */
	@Override
	public void fill(ArrayList<Thing> list) 
	{

		data = new ArrayList<Thing>(list);
		
	}

}
