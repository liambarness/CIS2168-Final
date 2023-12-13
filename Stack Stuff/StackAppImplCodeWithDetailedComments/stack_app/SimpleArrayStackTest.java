package stack_app;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

//for using legacy class Stack
import java.util.Stack;
import java.util.EmptyStackException;

/**
 * Class to show how to use Deque, ArrayDeque, LinkedList in Java API as a Stack
 * Code not in the book.
 * @author Cindy
 */
public class SimpleArrayStackTest {

    public static void main(String[] args) {
        
        //------Use ArrayDeque -------//        
        //create an empty stack of String objects using ArrayDeque 
        // and make the reference variable named studentStack reference this stack.
        ArrayDeque<String> studentStack = new ArrayDeque<>();
        //This is also ok:
        //Deque<String> studentStack = new ArrayDeque<>();
        
        
        //---If Use LinkedList as a stack, uncomment the code below ---//
        //Deque<String> studentStack = new LinkedList<>();
        //DO NOT USE this:
        //LinkedList<String> studentStack = new LinkedList<>();
        
        //---If Use legacy class Stack, uncomment the code below ---//
        //Stack<String> studentStack = new Stack<>();        
        
        //--Code below is the same regardless of choice of ArrayDeque/LinkedList/Stack---//
        
        //push 4 String items to this new stack
        studentStack.push("James");
        studentStack.push("Tom");
        studentStack.push("Jane");
        studentStack.push("steve");
        //print all data contents in the stack studentStack
        System.out.println(studentStack);
        
        //print the String at the top of the stack without removing this String.
        System.out.println("top of stack: " + studentStack.peek());
        
        //remove the String at the top of the stack and print its value
        System.out.println("top of stack (removed): " + studentStack.pop());
        //print all data contents in the stack studentStack after the pop
        System.out.println(studentStack);       
    }

}
/*---Program Output:
[steve, Jane, Tom, James]
top of stack: steve
top of stack (removed): steve
[Jane, Tom, James]
*/
