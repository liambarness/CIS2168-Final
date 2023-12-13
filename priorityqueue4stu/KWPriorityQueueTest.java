/* KWPriorityQueueTest.java
 * Integers represent the number of pages in print jobs.
 * The less number of pages the higher the priority of a print job
 * Print-out is at the bottom.
 */

package priorityqueue4stu;

import java.util.PriorityQueue;

//NOTE - because swap method in KWPriorityQueue<E> class is not implemented
//     (an exercise for you to complete). 
//     offer() method does not create a min-heap.
/** Use KWPriorityQueue<E> class and PriorityQueue<E> class in Java API.
 *  
 * @author cindy
 */
public class KWPriorityQueueTest {
    public static void main(String[] args) {         
       //KWPriorityQueue<Integer> printerQueue = new KWPriorityQueue<>();
       
       //Use the priority queue data structure provided by Java API.
       PriorityQueue<Integer> printerQueue = new PriorityQueue<>();
        
       printerQueue.offer(50);                      //add 50-page print job
       printerQueue.offer(30);                      //add 30-page print job
       System.out.println(printerQueue.toString()); //print contents of printerQueue
       printerQueue.offer(40);
       System.out.println(printerQueue.toString());   
       
       printerQueue.poll();     //remove current highest-priority job
       System.out.println(printerQueue.toString());
       
       printerQueue.offer(30);       
       System.out.println(printerQueue.toString());   
       
       printerQueue.offer(20);  //add a 20-page print job
       System.out.println(printerQueue.toString());  
       
       printerQueue.offer(20);  //add another 20-page print job, which is the second 20 in the print out.
       System.out.println(printerQueue.toString());  
    }   
}

/* Print out:
[30, 50]
[30, 50, 40]
[40, 50]
[30, 50, 40]
[20, 30, 40, 50]
[20, 20, 40, 50, 30]
*/
