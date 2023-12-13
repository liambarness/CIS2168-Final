//UseOfSets.java
//* demo how to use HashSet to perform set operations:
//*   Union, Intersection, Difference, Subset checking
//* I revised the Code in Listing 7.1 on Page 327.


import java.util.HashSet;
import java.util.Set;

public class UseOfSets {

    public static void main(String[] args) {
        //arrays to be used for creating sets of Strings.
        String[] listA = {"Ann", "Sally", "Jill", "Sally"}; //duplicate: "Sally"
        String[] listB = {"Bob", "Bill", "Ann", "Jill"};
        
        // Create 2 empty sets of Strings.
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        // Load sets from arrays.
        for (String s : listA) {    //for each string s in listA
            setA.add(s);            //add s to setA
        }
        for (String s : listB) {
            setB.add(s);
        }
        
        //create a copy of setA using the constructor that takes in a set collection
        Set<String> setACopy = new HashSet<>(setA);       
        
        
        //print contents in the 3 sets
        System.out.println("setA: " + setA);
        System.out.println("setACopy: " + setACopy);
        System.out.println("setB: " + setB);

        //set union, returns true if setA is changed.
        setA.addAll(setB); 
        System.out.println("setA union setB: " + setA);

        //set intersection, returns true if setACopy is changed.
        setACopy.retainAll(setB); 
        System.out.println("setACopy intersect setB: " + setACopy);

        System.out.println("setA: " + setA);
        System.out.println("setB: " + setB);
        
        //set difference ( or minus), returns true if setA is changed
        setA.removeAll(setB); 
        System.out.println("setA minus setB: " + setA);

        //subset checking
        System.out.println("setA subset-of setA? " + setA.containsAll(setA));        

    }
}
/*</listing>*/

/*----Program Output--
setA: [Ann, Sally, Jill]
setACopy: [Ann, Sally, Jill]
setB: [Ann, Bob, Bill, Jill]
setA union setB: [Ann, Sally, Bob, Bill, Jill]
setACopy intersect setB: [Ann, Jill]
setA: [Ann, Sally, Bob, Bill, Jill]
setB: [Ann, Bob, Bill, Jill]
setA minus setB: [Sally]
setA subset-of setA? true
*/