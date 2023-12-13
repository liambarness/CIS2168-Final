package stack_app;

import java.util.ArrayDeque;        //array-based stack class
import java.util.Deque;             //double-ended queue but used as a stack
import java.util.NoSuchElementException;

/** Class to check for balanced parentheses in a Java expression.
 * Use new Java feature for stack: ArrayDeque, instead of legacy Stack class.
 * 
 *  @author Koffman & Wolfgang & Cindy
 **/
public class ParenChecker {

    // Constants
    /** Set of opening parenthesis characters. */
    private static final String OPEN = "([{";
    /** Set of closing parenthesis characters, matches OPEN. */
    private static final String CLOSE = ")]}";

    /**
     * Test the input string to see if it contains balanced parentheses. 
     * This method tests an input string to see
     * if each type of parenthesis is balanced. '(' is matched
     * with ')', '[' is matched with ']', and
     * '{' is matched with '}'.
     * @param expression A String containing the expression to be examined
     * @return true if all the parentheses match
     */
    public static boolean isBalanced(String expression) {
        // Create an empty stack.
        Deque<Character> s = new ArrayDeque<>();
        boolean balanced = true;
        try {
            int index = 0;
            //while still balanced so far and have not completed checking entire expression
            while (balanced && index < expression.length()) {
                char nextCh = expression.charAt(index);
                if (isOpen(nextCh)) { //opening brace
                    s.push(nextCh);
                } else if (isClose(nextCh)) {//closing brace
                    char topCh = s.pop();
                    // if (both characters are in the same location in the two constants,
                    //   then they are matched. Otherwise, they don't match.
                    boolean matchingResult = OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
                    balanced = matchingResult;                   
                }
                index++;
            }
        } catch (NoSuchElementException ex) { //encountered popping from an empty stack
            balanced = false;
        }
        return (balanced && s.isEmpty());
    }

    /**
     * Method to determine whether a character is one of the
     * opening parentheses.
     * @param ch Character to be tested
     * @return true if ch is one of the opening parentheses
     */
    private static boolean isOpen(char ch) {
        return OPEN.indexOf(ch) > -1;
    }

    /**
     * Method to determine whether a character is one of the
     * closing parentheses.
     * @param ch Character to be tested
     * @return true if ch is one of the closing parentheses
     */
    private static boolean isClose(char ch) {
        return CLOSE.indexOf(ch) > -1;
    }

    /**
     * main method in the ParenChecker.
     * call isBalanced to see whether the parentheses in a given expression are balanced.
     * @param args Not used
     */
    public static void main(String args[]) {
        String expression = "(a + b) * (c - d)";
        if (isBalanced(expression)) {
            System.out.println(expression + " is balanced");
        } else {
            System.out.println(expression + " is not balanced");
        }
    }
}
