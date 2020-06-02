package coding.graph;

import java.util.Stack;

public class ValidParenthesis {
	
	public static boolean validParenthesis(String str) {
		Stack<Integer> openBracket = new Stack<Integer>();
		Stack<Integer> star = new Stack<Integer>();
		int i = 0;
		while(i < str.length()) {
			if(str.charAt(i) == '(')
				openBracket.push(i);
			if(str.charAt(i) == '*')
				star.push(i);
			if(str.charAt(i) == ')') {
				if(!openBracket.empty())
					openBracket.pop();
				else if(!star.empty() && star.pop() < i) {
					i++;
					continue;
				}
				else 
					return false;
			}
			i++;
		}
		if(openBracket.empty()) return true;
		if ((!openBracket.empty() && star.isEmpty()) 
				|| openBracket.size() > star.size())
			return false;
		
		while(!openBracket.isEmpty() && !star.isEmpty()) {
			int openBracketIndex = openBracket.pop();
			int starIndex = star.pop();
			if(!star.isEmpty())
				if(openBracketIndex > starIndex)
					return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		String str = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
		System.out.println(validParenthesis(str));
	}

}
