
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class SetUseCodingPracticeQA {

    public static void main(String[] args) {
        
        //Question:
        //Suppose that the following lists are the items purchased by Alice and Bob:
        // Alice: {"apple", "icecream", "milk", "donut"}
        // Bob: {"cucumber", "chicken wing", "donut"}
        //
        //Write a program using the Set data structure in Java API to print 
        //  a. items bought by both Alice and Bob
        //  b. items bought by only Alice
        //  c. items bought by either person or both of them.

        
        //Answer Using TreeSet<E>.
        // to use HashSete<E>, replace all instances of TreeSet by HashSet.
        String[] listAlice = {"apple", "icecream", "milk", "donut"}; 
        String[] listBob = {"cucumber", "chicken wing", "donut"};        

        //create a set for items purchased by Alice
        Set<String> setAlice = new TreeSet<>();
        for (String item : listAlice) {
            setAlice.add(item);
        }
        System.out.println(setAlice);
        
         //create a set for items purchased by Bob
        Set<String> setBob = new TreeSet<>();
        for (String item : listBob) {
            setBob.add(item);
        }
        System.out.println(setBob);      
        
        //  a. items bought by both Alice and Bob
        //create a set that is the copy of setAlice
        Set<String> setBoth = new TreeSet<>(setAlice);
        setBoth.retainAll(setBob);
        System.out.println(setBoth);          
        
        //  b. items bought by only Alice
        Set<String> setAliceOnly = new TreeSet<>(setAlice);        
        setAliceOnly.removeAll(setBob);
        System.out.println(setAliceOnly);
        
        //  c. items bought by either person or both of them.     
        Set<String> setAllItems = new TreeSet<>(setAlice);        
        setAllItems.addAll(setBob);
        System.out.println(setAllItems);        

    }
    
}
