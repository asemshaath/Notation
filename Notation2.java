/**
 * This class is to make the conventions and the evaluations of the postfix and infix expressions
 * 
 * @author Asem Shaath
 * 
 *
 */
public class Notation2 {

	/**
	 * This is just an empty constructor 
	 */
	public Notation2() {} 
	
	/**
	 * This method converts the given postfix expression to an infix expression
	 *  
	 * @param postfix expression
	 * @return infix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException 
	{
		
		String exp = "";
		
		NotationStack<String> s = new NotationStack<String>(postfix.length()); 
		//NotationQueue<String> q = new NotationQueue<String>(expCount(postfix)); 
		
		try 
		{
			
			for(int i = 0; i < postfix.length(); i++)
			{
				
				if(postfix.charAt(i) == ' ') 
				{
					continue; 
				}
				else if(postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9')
				{
					s.push(String.valueOf(postfix.charAt(i)));
				}
				else if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*' || postfix.charAt(i) == '/') 
				{
					
					if (s.size() < 2)
					{
						//System.out.println("InvalidNotationFormatException has been thrown in convertPostfixToInfix()");
						throw new InvalidNotationFormatException(); 
					}
					else 
					{
						String second = s.pop();
						String first = s.pop(); 
						
						exp = ""; // to clear the expression 
						
						exp += "(" + first + String.valueOf(postfix.charAt(i)) + second + ")";
						s.push(exp); 
						
					}
					
				}
				
			}
			
			// when the postfix expression is read 
			
			if(s.size() == 1) 
			{
				return s.top(); 
			}
			else 
			{
				throw new InvalidNotationFormatException(); 
			}
			
			
		}
		catch (StackOverflowException e) 
		{
			e.getMessage();
			//System.out.println("StackOverflowException handled in convertPostfixToInfix()");
		} 
		catch (StackUnderflowException e) 
		{
			e.getMessage(); 
			//System.out.println("StackUnderflowException handled in convertPostfixToInfix()");
		} 
		
		return null;
		
	}
	
	/**
	 * This method converts the infix expression to a postfix expression
	 * 
	 * @param infix expression
	 * @return postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
    {
		
		NotationStack<String> s = new NotationStack<String>(infix.length()); 
		NotationQueue<String> q = new NotationQueue<String>(infix.length()); 
		
		//System.out.println("opCount " + opCount(infix));
		//System.out.println("expCount " + expCount(infix));
		
		try {
			
			for(int i = 0; i < infix.length(); i++) 
			{
			
				if(infix.charAt(i) == ' ') 
				{
					continue; 
				}
				else if(infix.charAt(i) >= '0' && infix.charAt(i) <= '9')
				{
					q.enqueue(String.valueOf(infix.charAt(i)));
				}
				else if(infix.charAt(i) == '(')
				{
					s.push("(");
				}
				else if(infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '*' || infix.charAt(i) == '/') 
				{
					
					switch(infix.charAt(i)) 
					{
						
					case '+':
						
						if(s.isEmpty() == true)
						{
							s.push("+");
						}
						else if(s.top() == "-" || s.top() == "/" || s.top() == "*") 
						{
							q.enqueue(s.top()); 
							s.pop();
							s.push("+");
							 
						}
						else
						{
							s.push("+");
						}
						
						break; 
						
					case '-':
						
						if(s.isEmpty() == true)
						{
							s.push("-");
						}
						else if(s.top() == "+" || s.top() == "/" || s.top() == "*") 
						{
							q.enqueue(s.top()); 
							s.pop();
							s.push("-"); 
						}
						else
						{
							s.push("-");
						}
						break;
						
					case '*':
						
						if(s.isEmpty() == true)
						{
							s.push("*");
						}
						else if(s.top() == "/") 
						{
							q.enqueue(s.top()); 
							s.pop();
							s.push("*"); 
						}
						else
						{
							s.push("*");
						}
						break;
						
					case '/':
						
						if(s.isEmpty() == true)
						{
							s.push("/");
						}
						else if(s.top() == "*") 
						{
							q.enqueue(s.top()); 
							s.pop();
							s.push("/"); 
						}
						else
						{
							s.push("/");
						}
						break;
						
					}
					
				}
				else if(infix.charAt(i) == ')') 
				{
					if(s.toString().contains("(") == false)
					{
						//System.out.println("InvalidNotationFormatException handeled in convertInfixToPostfix()");
						throw new InvalidNotationFormatException(); 
					}
					else
					{
						
						int tempStackSize = s.size(); 
						
						for(int j = 0; j < tempStackSize; j++) 
						{
							
							if(s.top() == "+" || s.top() == "-" || s.top() == "*" || s.top() == "/") 
							{
								q.enqueue(s.top());
								s.pop();
							}
							else if (s.top() == "(") 
							{
								s.pop();
								break;
							}
							else 
							{
								break;
							}
							
						}
						
						
					}
				}
			}
			
			int tempSize = s.size(); 
			
			for(int i = 0; i < tempSize; i++)
			{
				q.enqueue(s.top()); 
				s.pop();
			}
		
		} 
		catch (QueueOverflowException e) 
		{
			e.getMessage();
			//System.out.println("QueueOverflowException handled in convertInfixToPostfix()");
		} 
		catch (StackOverflowException e) 
		{
			e.getMessage();
			//System.out.println("StackOverflowException handled in convertInfixToPostfix()");
		} 
		catch (StackUnderflowException e) 
		{
			e.getMessage();
			//System.out.println("StackUnderflowException handled in convertInfixToPostfix()");
		}

		return q.toString();
    }         
	
	/**
	 * This method evaluates a given postfix expression to a number
	 * 
	 * @param postfix expression
	 * @return value of the expression 
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		
		NotationStack<String> s = new NotationStack<String>(postfixExpr.length()); 
		//NotationQueue<String> q = new NotationQueue<String>(expCount(postfixExpr)); 
		
		try 
		{
		
			
			for(int i =0; i < postfixExpr.length(); i++) 
			{
				
				if(postfixExpr.charAt(i) == ' ') 
				{
					continue; 
				}
				else if(postfixExpr.charAt(i) >= '0' && postfixExpr.charAt(i) <= '9' )    // '(' has been removed 
				{
					
					s.push(String.valueOf(postfixExpr.charAt(i)));
					
				}
				else if(postfixExpr.charAt(i) == '+' || postfixExpr.charAt(i) == '-' || postfixExpr.charAt(i) == '*' || postfixExpr.charAt(i) == '/')
				{
				
					if(s.size() < 2) 
					{
						
						//System.out.println("InvalidNotationFormatException has been handled in evaluatePostfixExpression()");
						throw new InvalidNotationFormatException();
						
					}
					else 
					{
						
						String right = s.pop(); 
						double rightDouble = Double.parseDouble(right); 
						
						String left = s.pop();  
						double leftDouble = Double.parseDouble(left); 
						
						switch(postfixExpr.charAt(i)) 
						{
						
						case '+':
							
							double addition = leftDouble + rightDouble; 
							s.push(String.valueOf(addition));
							
							break;
							
						case '-':
							
							double subtraction = leftDouble - rightDouble;
							s.push(String.valueOf(subtraction));
							
							break;
							
						case '*':
							
							double multi = leftDouble * rightDouble;
							s.push(String.valueOf(multi));
							
							break;
							
						case '/':
							
							double div = leftDouble / rightDouble; 
							s.push(String.valueOf(div));
							
							break;
							
						}
						
					}
					
				}
				
			}
			
		}
		catch(StackOverflowException e) 
		{
			//System.out.println("StackOverflowException has been handled in Evaluate postfix expression method");
		} 
		catch (StackUnderflowException e) 
		{
			//System.out.println("StackUnderflowException has been handled in Evaluate postfix expression method #1");
		}
		
		
		
		try 
		{
			
			if (s.size() == 1) 
			{
				return Double.valueOf(s.top()); 
			}
			else
			{
				//System.out.println("InvalidNotationFormatException has been handled in evaluatePostfixExpression() #2");
				throw new InvalidNotationFormatException();
			}
		} 
		catch (StackUnderflowException e) 
		{
			//System.out.println("StackUnderflowException has been handled in Evaluate postfix expression method #2");
		}
		
		return 0;
		
	}
	
	/**
	 * This method evaluates a given infix expression to a number
	 * 
	 * @param infix expression
	 * @return value of the expression
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException
	{
		
		return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
		
	}
	
	
}
