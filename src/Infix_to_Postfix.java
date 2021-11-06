import java.util.Stack;

/**
 * @author Andres Uriza
 * @author Jose Pablo Esquetini
 *
 * This class converts an infix operation to postfix notation
 */
public class Infix_to_Postfix {
   private Stack<Character> theStack;
   private String input;
   private String output = "";

   /**
    * Constructor method
    * @param expression
    */
   public Infix_to_Postfix(String expression) {
      input = expression;
      theStack = new Stack<Character>();
   }

   /**
    *
    * @return
    */
   public String doTrans() {
      for (int j = 0; j < input.length(); j++) {
         char ch = input.charAt(j);
         switch (ch) {
            case '+': 
            case '-':
               gotOper(ch, 1); 
               break; 
            case '*': 
            case '/':
            case '%':
               gotOper(ch, 2); 
               break; 
            case '(': 
               theStack.push(ch);
               break;
            case ')': 
               gotParen(ch); 
               break;
            default: 
               output = output + ch; 
               break;
         }
      }

      while (!theStack.isEmpty()) {
         output += theStack.pop();
      }

      System.out.println(output);
      return output; 
   }

   /**
    *
    * @param opThis
    * @param prec1
    */
   public void gotOper(char opThis, int prec1) {
      while (!theStack.isEmpty()) {
         char opTop = theStack.pop();
         if (opTop == '(') {
            theStack.push(opTop);
            break;
         } else {
            int prec2;
            if (opTop == '+' || opTop == '-')
            prec2 = 1;
            else
            prec2 = 2;

            if (prec2 < prec1) { 
               theStack.push(opTop);
               break;
            } 
            else output = output + opTop;
         }
      }
      theStack.push(opThis);
   }

   /**
    *
    * @param ch
    */
   public void gotParen(char ch) { 
      while (!theStack.isEmpty()) {
         char chx = theStack.pop();
         if (chx == '(') 
         break; 
         else output = output + chx; 
      }
   }
}
