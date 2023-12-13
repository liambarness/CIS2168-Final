/*<listing chapter="4" number="2">*/

import java.util.ArrayDeque;    //a class used as an array-based stack
import java.util.Deque;         //an interface: double-ended queue used as a stack in this program

/** Class with methods to check whether a string is a palindrome.
 * Use new Java feature for stack: ArrayDeque, instead of legacy Stack class.
 * 
 *  @author Koffman & Wolfgang
 **/
public class PalindromeFinder {

    /** Method to fill a stack of characters from an input string.
     * @param inputString the string to be checked
     * @return a stack of characters in inputString
     */
    private static Deque<Character> fillStack(String inputString) {
        //create an empty array-based stack of Character objects, 
        //  and have the variable charStack reference the new stack.
        Deque<Character> charStack = new ArrayDeque<>();
        for (int i = 0; i < inputString.length(); i++) {
            //push the character at [i] in the input string onto the stack
            charStack.push(inputString.charAt(i));
        }
        //return a reference to the stack filled with the characters in the input string
        //   in reverse order
        return charStack;
    }

    /**
     * Method to build the reverse of a string by calling fillStack
     * to push its characters onto a stack and then popping them and 
     *   appending them to a new string.
     * @param inputString the string to be checked
     * @post The stack is empty.
     * @return The string containing the characters in the stack
     */
    private static String buildReverse(String inputString) {
        //call fillStack(...) to get a stack filled with characters in the str
        Deque<Character> charStack = fillStack(inputString);
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            // Remove top item from the stack and append it to result.
            result.append(charStack.pop());
        }
        return result.toString();
    }

    /** Calls buildReverse and compares its result to inputString
     * @param inputString the string to be checked
     * @return true if inputString is a palindrome, false if not
    */
    public static boolean isPalindrome(String inputString) {
        //compare the input string and its reverse string and return the result
        return inputString.equalsIgnoreCase(buildReverse(inputString));
    }
}
/*</listing>*/
