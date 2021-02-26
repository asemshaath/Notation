import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationStackTest {
	public NotationStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public NotationStack<Double> doubleS;
	
	// STUDENT: add variables as needed for your student tests
	public double class2017 = 0; 
	public double class2018 = 2;
	public double class2019 = 6; 
	public double class2020 = 7; 
	public double class2021 = 2; 
	
	@Before
	public void setUp() throws Exception {
		stringS = new NotationStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		
		doubleS = new NotationStack<Double>(4); 
		doubleS.push(class2017); 
		doubleS.push(class2018);
		
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		
		try 
		{
			assertEquals(class2018, doubleS.pop(), 0.0000001);
			assertEquals(class2017, doubleS.pop(), 0.0000001); 
			
			doubleS.pop(); 
			assertTrue(false); 
		} 
		catch (StackUnderflowException e) 
		{
			assertTrue(true); 
		} 
		catch (Exception e)
		{
			assertTrue(false); 
		}
	}
	
	@Test
	public void testTop() throws StackOverflowException, StackUnderflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	public void testSize() throws StackUnderflowException, StackOverflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		
		
		try 
		{
			assertEquals(2,doubleS.size()); 
			assertEquals(true,doubleS.push(class2019));
			
			assertEquals(3,doubleS.size()); 
			assertEquals(true, doubleS.push(class2020)); 
			
			assertEquals(4, doubleS.size()); 
			assertEquals(false, doubleS.push(class2021)); 
			
		} 
		catch (StackOverflowException e) 
		{
			
		} 
		
	}
	
	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	@Test
	public void testToStringStudent() throws StackOverflowException {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		
		assertEquals("0.02.0", doubleS.toString());
		System.out.println(doubleS.toString());
		
		doubleS.push(class2019); 
		assertEquals("0.02.06.0", doubleS.toString());
		
	}
	
	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new NotationStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		
		
		
		assertEquals(3,stringS.size());
		
		System.out.println("In Test Fill");
		
		System.out.println(stringS);
		System.out.println(stringS.top());
		assertEquals("carrot", stringS.pop());
		
		System.out.println(stringS.top());
		assertEquals("banana", stringS.pop());
		
		System.out.println(stringS.top());
		assertEquals("apple", stringS.pop());		
	}

}