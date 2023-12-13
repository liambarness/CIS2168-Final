/*<listing chapter="4" number="4">*/


import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/** Class ListStack implements the interface StackInt 
 *  using a list as a data field component and
 *  handling the list operations indirectly as a client of List interface.
 * 
 *  @param <E> The type of the elements in the stack
 *  @author Koffman & Wolfgang
 */
public class ListStack<E> implements StackInt<E> {

    /** The List containing the data */
    private List<E> theData;

    /**
     * Construct an empty stack using an ArrayList as the
     * container.
     */
    public ListStack() {
        theData = new ArrayList<>();
    }

    /**
     * Push an object onto the stack.
     * @post The object is at the top of the stack.
     * @param obj The object to be pushed
     * @return The object pushed
     */
    @Override
    public E push(E obj) {      //method delegation: give different names for essentially the same method
        theData.add(obj);       //append
        return obj;
    }

    /**
     * Peek at the top object on the stack.
     * @return The top object on the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData.get(theData.size() - 1);     //examine last one
    }

    /**
     * Pop the top object off the stack.
     * @post The object at the top of the stack is removed.
     * @return The top object, which is removed
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData.remove(theData.size() - 1);      //remove last one
    }

    /**
     * See whether the stack is empty.
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return theData.isEmpty();
    }

}
/*</listing>*/
