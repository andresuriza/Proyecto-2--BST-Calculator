import java.util.Stack;

public class ExpressionTree {

	public ExpressionTree(String expression){
		String infix = expression;
		Infix_to_Postfix inToPost = new Infix_to_Postfix(infix);
		String postfix = inToPost.doTrans();
		System.out.println(postfix);
		String[] test = convertion(postfix);
		System.out.println(test);
		Node tree = treeConstruction(test);
		System.out.println(tree.getData());
		int result = evaluateTree(tree);
		System.out.println(result);
	}

	public String[] convertion(String expression) {
		char[] expressionList = expression.toCharArray();
		String operand = "";
		String operator = "";
		int i = 0;
		String[] result = new String[expression.length()];
		int count = 0;
		
		while (i < expressionList.length) {
			if (expressionList[i] == '1'  || expressionList[i] == '2'|| expressionList[i] == '3' || expressionList[i] == '4' 
			 || expressionList[i] == '5' || expressionList[i] == '6' || expressionList[i] == '7' || expressionList[i] == '8'
			 || expressionList[i] == '9' || expressionList[i] == '0') {
				
				operand += expressionList[i];
				i++;
			}

			if (expressionList[i] == ' ') {
				if (operand == "") {
					i++;
				}
				if (operand != "") {
					result[count] = operand;
					count++;
					i++;
					operand = "";

				}
			}

			if (expressionList[i] == '+' || expressionList[i] == '-' || expressionList[i] == '*' || expressionList[i] == '/'
			|| expressionList[i] == '%') {

				operator += expressionList[i];
				result[count] = operator;
				operator = "";
				count++;
				i++;
			}
		}
		return result;
	}

	public Node treeConstruction(String[] expression) {
		Stack<Node> buildStack = new Stack<Node>();
		Node top;
		Node right;
		Node left;
		int i = 0;
		Node root;
		System.out.println(expression.length);

		while (i < expression.length) {
			if (!isOperator(expression[i])) {
				top = new Node(expression[i]);
				buildStack.push(top);
				i++;
			} else {
				top = new Node(expression[i]);
				right = buildStack.pop();
				left = buildStack.pop();

				top.setRight(right);
				top.setLeft(left);

				buildStack.push(top);
				i++;
			}
		}

		root = buildStack.peek();
		buildStack.pop();
		return root;
	}

	public boolean isOperator(String data) {
		return (data == "+" || data == "-" || data == "*" || data == "/" || data == "%");
	}

	public int evaluateTree(Node root) {
		int result = 0;
		if (root == null) {
			return result;
		}

		int left = evaluateTree(root.left);
		int right = evaluateTree(root.right);

		switch(root.data) {
			case "+":
				result =  left + right;
			case "-":
				result = left - right;
			case "*":
				result = left * right;
			case "/":
				result = left / right;
			case "%":
				result = left % right;

		}
		return result;

	}

	public static void main(String Args[]) {
		String hello = "10 + 9";
		ExpressionTree test = new ExpressionTree(hello);

	}
}