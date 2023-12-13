import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Solutions to stack practice coding questions.

public class StackCodingPracticeTest {

    public static void main(String[] args) {       
        String[] fruits = {"apple", "orange", "grape", "banana", "mango"};
        
        //a.
        //use a loop to store the elements in fruits array
        //    to an empty stack: fStack1
        //Note: use Deque<E> interface and ArrayDeque<E> class as a stack
        //use toString() to print the contents of the stack.
     
        Deque<String> fStack1 = new ArrayDeque<>();
        for (String f : fruits) {
            fStack1.push(f);
        }
        System.out.println(fStack1);

        //b.
        //use a loop to remove each item from the stack until it's empty
        //  and print the removed item while looping as follows:
        //      ----------------------------------------
        //Top: mango | banana | grape | orange | apple | ] Bottom
        //      ----------------------------------------
        
        System.out.println("      ----------------------------------------");
        System.out.print("Top: ");           
        //solution 1: use a while loop to traverse the entire stack
        //better than solution 2
        while (!fStack1.isEmpty()) {
            System.out.print(fStack1.pop() + " | ");
        }
        //solution 2: use a for-each loop to traverse the entire stack
//        for (String f : fStack1) {
//            System.out.print(fStack1.pop() + " | ");
//        }        
        
        System.out.println(" ] Bottom ");
        System.out.println("      ----------------------------------------");
        
        //c.
        //comment your code in b. so that the first stack is not empty at this point.
        //create another empty stack of the same type: fStack2.
        //use a loop to remove each item from the first stack
        //   and add it to the second stack until the first stack is empty.
        //use toString() to print the contents of the second stack;

        Deque<String> fStack2 = new ArrayDeque<>();        
        while (!fStack1.isEmpty()) {
            String f = fStack1.pop();
            fStack2.push(f);
        }        
        System.out.println(fStack2);
        
        //d.
        //use a loop to remove each item from the second stack
        //   and print the item until the stack is empty
        //print all items in one line.
        
        System.out.println("Stack 2:");
        while (!fStack2.isEmpty()) {
            System.out.print(fStack2.pop() + " | ");
        }        
        System.out.println("");
        
        //e.
        //use Deque<E> interface and LinkedList<E> class as a stack repeat the tasks above
        
        //Solution: replace ArrayDeque<> by LinkedList<> in all the code above.
        //For example, for a., the answer is 
        //  NOTE: variable name fStack1 is changed to fStack3 to avoid syntax error.
        
        Deque<String> fStack3 = new LinkedList<>();
        for (String f : fruits) {
            fStack3.push(f);
        }
        System.out.println(fStack3);                
        
    }

}
