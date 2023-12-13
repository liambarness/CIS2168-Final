
import java.util.NoSuchElementException;
/** Implementation of the interface StackInt using a resize-able array.
 * Code not in the 4th Edition of the textbook.
 * 
 * @param <E> The type of elements
 * @author Koffman & Wolfgang
 */
public class ArrayStack<E> implements StackInt<E> {

    // Data Fields
    /** Storage for stack. */
    E[] theData;
    /** Index to top of stack, which is the last element in the array theData. */
    int topOfStack = -1; // Initially empty stack.
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Construct an empty stack with the default initial capacity.
     */
    public ArrayStack() {
        theData = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Insert a new item on top of the stack.
     * @post The new item is the top item on the stack.
     *       All other items are one position lower.
     * @param obj The item to be inserted
     * @return The item that was inserted
     */
    @Override
    public E push(E obj) {
        if (topOfStack == theData.length - 1) { //array is filled to current capacity
            reallocate();       //enlarge the array
        }
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }

    /**
     * Remove and return the top item on the stack.
     * @pre The stack is not empty.
     * @post The top item on the stack has been
     *       removed and the stack is one item smaller.
     * @return The top item on the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        //Get the top stack element, decrement topOfStack, 
        //  and return the top stack element.
        return theData[topOfStack--];
    }
    
    /**
     * Return the top item on the stack
     * Pre: The stack is not empty
     * Post: The stack remains unchanged
     * @return The top item on the stack
     * @throws NoSuchElementException If the stack
     *         is empty
     */
    @Override
    public E peek() {
        //to be completed by you as an exercise
        return null;
    }

    /**
     * Return true if the stack is empty
     * @return True if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        //to be completed by you as an exercise
        return false;
    }

    /**
     * Method to reallocate the array containing the stack data
     * @post The size of the data array has been doubled
     *       and all of the data has been copied to the new array
     */
    private void reallocate() {
        //to be completed by you as an exercise
    }

}
