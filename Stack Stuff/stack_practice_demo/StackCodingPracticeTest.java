
package stack_practice_demo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StackCodingPracticeTest {


    public static void main(String[] args) {
        String[] fruits = {"apple", "orange", "grape", "banana", "mango"};

	//a.
        //use a loop to store the elements in fruits array
        //    to an empty stack: fStack1
        //Note: use Deque<E> interface and ArrayDeque<E> class as a stack
	//use toString() to print the contents of the stack.


	//b.
        //use a loop to remove each item from the stack until it's empty
        //  and print the removed item while looping as follows:
            //      ----------------------------------------
            //Top: mango | banana | grape | orange | apple | ] Bottom
            //      ----------------------------------------


	//c.
	//comment your code in b. so that the first stack is not empty at this point.
        //create another empty stack of the same type: fStack2.
        //use a loop to remove each item from the first stack
	//   and add it to the second stack until the first stack is empty.
	//use toString() to print the contents of the second stack;


        //d.
        //use a loop to remove each item from the second stack
	//   and print the item until the stack is empty
        //print all items in one line.


	//e.
        //use Deque<E> interface and LinkedList<E> class as a stack repeat the tasks above


    }

}
