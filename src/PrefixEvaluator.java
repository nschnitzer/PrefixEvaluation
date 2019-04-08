//*******************************************
// Nathan Schnitzer
// PrefixEvaluator.java
// 19.04.08
// ACSL Contest #4
//*******************************************

import java.util.ArrayList;
import java.util.Stack;

public class PrefixEvaluator 
{
	Stack<String> stk = new Stack<String>();
	ArrayList<String> list;
	public PrefixEvaluator(ArrayList<String> l)
	{
		list = l;
		evaluate();
	}
	
	private void evaluate()
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (isInteger(list.get(i)))
			{
				continue;
			}
			
			//if abs
			if (list.get(i).equals("|"))
			{
				if (isInteger(list.get(i+1)))
				{
					list.set(i, abs(list.get(i+1)));
					list.remove(i+1);
					continue;
				}
				continue;
			}
			
			//if plus
			if (list.get(i).equals("+"))
			{
				if (isInteger(list.get(i+1)) && isInteger(list.get(i+2)))
				{
					list.set(i, add(list.get(i+1), list.get(i+2)));
					list.remove(i+1);
					list.remove(i+1);
					continue;
				}
				continue;
			}
			
			//if minus
			if (list.get(i).equals("-"))
			{
				if (isInteger(list.get(i+1)) && isInteger(list.get(i+2)))
				{
					list.set(i, subtract(list.get(i+1), list.get(i+2)));
					list.remove(i+1);
					list.remove(i+1);
					continue;
				}
				continue;
			}
			
			//if mult
			if (list.get(i).equals("*"))
			{
				if (isInteger(list.get(i+1)) && isInteger(list.get(i+2)))
				{
					list.set(i, mult(list.get(i+1), list.get(i+2)));
					list.remove(i+1);
					list.remove(i+1);
					continue;
				}
				continue;
			}
			
			//if @
			if (list.get(i).contentEquals("@"))
			{
				if (isInteger(list.get(i+1)) && isInteger(list.get(i+2)) && isInteger(list.get(i+3)))
				{
					list.set(i, switcher(list.get(i+1), list.get(i+2), list.get(i+3)));
					list.remove(i+1);
					list.remove(i+1);
					list.remove(i+1);
					continue;
				}
				continue;
			}
			
			//if >
			if (list.get(i).contentEquals(">"))
			{
				if (isInteger(list.get(i+1)) && isInteger(list.get(i+2)) && isInteger(list.get(i+3)))
				{
					list.set(i, max(list.get(i+1), list.get(i+2), list.get(i+3)));
					list.remove(i+1);
					list.remove(i+1);
					list.remove(i+1);
					continue;
				}
				continue;
			}
		}
		
		if (list.size() == 1)
		{
			System.out.println(list.get(0));
		}
		else
			evaluate();
	}
	
	private String add(String x, String y)
	{
		return "" + (Integer.parseInt(x) + Integer.parseInt(y));
	}
	
	private String subtract(String x, String y)
	{
		return "" + (Integer.parseInt(x) - Integer.parseInt(y));
	}
	
	private String mult(String x, String y)
	{
		return "" + (Integer.parseInt(x) * Integer.parseInt(y));
	}
	
	private String abs(String x)
	{
		return "" + (Math.abs(Integer.parseInt(x)));
	}
	
	private String switcher(String x, String y, String z)
	{
		int a = Integer.parseInt(x);
		
		if (a > 0)
		{
			return y;
		}
		else
		{
			return z;
		}
	}
	
	private String max (String x, String y, String z)
	{
		int a = Integer.parseInt(x);
		int b = Integer.parseInt(y);
		int c = Integer.parseInt(z);
		
		if (a > b)
		{
			if (a > c)
			{
				return x;
			}
			return z;
		}
		else if (b > c)
		{
			return y;
		}
		else
		{
			return z;
		}
		
	}
	
	public boolean isInteger(String s) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),10) < 0) return false;
	    }
	    return true;
	}
	

}
