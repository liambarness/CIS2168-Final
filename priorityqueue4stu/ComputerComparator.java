package priorityqueue4stu;

import java.util.Comparator;

/**
 * This class provides a comparator for comparing two Computer objects
 *   based on their brands in alphabetical order.
 * 
 * @author Cindy
 */
//declare the class to implement the interface Comparable<E>. 
// Computer is the type argument for type parameter E.
public class ComputerComparator implements Comparator<Computer>  {
 
    //override the compare(...) method in the interface Comparator<E>
    @Override
    public int compare(Computer c1, Computer c2) {           
        //reuse compareTo(..) method implemented in class String
        //   since brand data field is String type.
        return c1.getBrand().compareTo(c2.getBrand());
    }
    
    public static void main(String[] args) {
        Computer myComputer = new Computer("dell", 4, 16);
        Computer hisComputer = new Computer("lenovo", 3, 8);
        
        //call compareTo(..) method to compare two Computer objects based on
        //   computing power.
        System.out.println(myComputer.compareTo(hisComputer));    
        
        //call compare(...) method to compare two Computer objects based on
        //  brands alphabetically.
        ComputerComparator comparator = new ComputerComparator();
        System.out.println(comparator.compare(myComputer, hisComputer));
        
    }    
}