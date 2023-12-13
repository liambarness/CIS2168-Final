//SimpleSetTest.java
//* simple demo of using Set interface, TreeSet/HashSet classes for a set of Integer objects
//*    create an empty set of Integers
//*    Add numbers in an array to the set, print the set content.
//*    Use set methods: add, contains, remove.
//*    Use for-each loop on a set.

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;

public class SimpleSetTest {

    public static void main(String[] args) {
        //array to be used for creating a tree set
        int[] numbers = {45, 27, 15, 21, 36, 36};
        //create an empty set of Integer objects
        //TreeSet<Integer> numberSet = new TreeSet<>();
        //Uncomment the line below for using HashSet
        HashSet<Integer> numberSet = new HashSet<>();
        //Uncomment the line beow for using Set interface and HashSet
        //Set<Integer> numberSet = new HashSet<>();

        //populate the numberSet
        for (int i = 0; i < numbers.length; i++) {
            numberSet.add(numbers[i]); //add current number in the array numbers
        }
        //display the current content in numberSet
        System.out.println(numberSet); //implicitly call toString()
        
        //can not add duplicates to a set
        numberSet.add(45);
        System.out.println(numberSet);
        
        //check membership
        System.out.println(numberSet.contains(30));
        System.out.println(numberSet.contains(27));        
        
        //remove an element
        numberSet.remove(15);
        System.out.println(numberSet);
        
        //use for-each loop
        for (Integer number : numberSet) {
            System.out.print(number + " ");
        }        
    }
}

/* Output for TreeSet
[15, 21, 27, 36, 45]
[15, 21, 27, 36, 45]
false
true
[21, 27, 36, 45]
21 27 36 45
*/

/* Output for HashSet
[36, 21, 27, 45, 15]
[36, 21, 27, 45, 15]
false
true
[36, 21, 27, 45]
36 21 27 45
*/