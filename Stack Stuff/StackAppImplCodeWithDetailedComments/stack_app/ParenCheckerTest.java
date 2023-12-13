//ParenCheckerTest.java
//* The client class of class ParenChecker or ParenChecker2.
//* Use new Java feature for stack: ArrayDeque or legacy Stack class.

package stack_app;

/** The client class of class ParenChecker or ParenChecker2.
 *  @author Cindy
 **/
public class ParenCheckerTest {

    /**
     * main method. 
     * Call the ParenChecker to see whether the parentheses in an expression are balanced.
     * @param args Not used
     */
    public static void main(String args[]) {      
        String expression = "(a + b) * (c - d)";
        
        if (ParenChecker.isBalanced(expression)) { //use Deque interface        
        //if (ParenChecker2.isBalanced(expression)) { //use legacy Stack class
            System.out.println(expression + " is balanced");
        } else {
            System.out.println(expression + " is not balanced");
        }
    }
}
