import java.util.Stack;

public class ExpressionTree {

	public ExpressionTree(String expression){
		char[] infix = expression.toCharArray();
		char[] postfix = postfixer(infix);

	}

	private char[] postfixer(char[] infix_expression) {
		Stack<Character> stack = new Stack<Character>();

		char[] result = new char[infix_expression.length];

	} 
}