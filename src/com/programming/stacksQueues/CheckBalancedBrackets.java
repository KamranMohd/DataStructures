package com.programming.stacksQueues;

/*
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */

import java.util.Stack;

public class CheckBalancedBrackets {

	public static void main(String[] args) {
		String exp = "{'{','(',')','}','[',']'}{}";
		boolean result = isExpBalanced(exp);
		System.out.println("Is equation balanced : " + result);
	}

	private static boolean isExpBalanced(String exp) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<exp.length();i++){
			if(exp.charAt(i)=='{' || exp.charAt(i)=='(' || exp.charAt(i)=='[')
				stack.push(exp.charAt(i));
			else{
				if(stack.isEmpty())
					return false;
				switch(exp.charAt(i)){
					case '}':
						if(stack.pop()!='{')
							return false;
						break;
					case ')':
						if((stack.pop())!='(')
							return false;
						break;
					case ']':
						if(stack.pop()!='[')
							return false;
						break;
					default:
						continue;
				}	
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}	

}
