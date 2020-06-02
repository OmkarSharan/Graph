package coding.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PrintBalanceParenthesis {
    static Set<String> totalSet = new HashSet<String>();
	public static boolean checkBalaceParenthesis(String str) {
		Stack<Character> stack = new Stack();
		for(Character c: str.toCharArray()) {
			if(c == '(')
				stack.push(c);
			else if(c == ')' && stack.empty()) return false;
			else if(c == ')')
				stack.pop();
		}
		return stack.isEmpty() == false ? false: true;
	}
	public static void printParenethesis(String str, int opening, int closing, int n) {
		if(str.length() >= 1 && str.charAt(0) == ')') return ;
		if(opening + closing > 2*n) return;
		if(opening + closing == 2*n) {
			if(checkBalaceParenthesis(str))
				totalSet.add(str);
			return;
		}
		printParenethesis(str+"(", opening+1, closing, n);
		printParenethesis(str+")", opening, closing+1, n);
		return;
	}
	public static void main(String[] args) {
		int n = 3;
		printParenethesis("", 0, 0, n);
		System.out.println(totalSet);
	}

}
