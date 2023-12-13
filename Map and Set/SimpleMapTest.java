//SimpleMapTest.java
//*  demo how to use HashMap or TreeMap to do basic operations:
//*     put, get, print, remove, get all keys, get all values, get all entries

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class SimpleMapTest {

    public static void main(String[] args) {
        //create an empty map, consisting of pairs of String objects.
        //Map<String, String> aMap = new HashMap<>();        
        Map<String, String> aMap = new TreeMap<>();        
        //add 5 key-value pairs
        aMap.put("J", "Jane");
        aMap.put("B", "Bill");
        aMap.put("S", "Sam");
        aMap.put("B1", "Bob");
        aMap.put("B2", "Bill");

        //call toString() method in HashMap to get the key,value pairs and print them
        System.out.println("The map: " + aMap); //implicitly call toString()

        //get the value for key "B1"
        System.out.println("B1 maps to " + aMap.get("B1"));
        //get the value for key "B2"
        System.out.println("B2 maps to " + aMap.get("B2"));
        
        //remove an entry with the given key: "B2"
        aMap.remove("B2");
        System.out.println("--After removing the entry with key B2----");        
        System.out.println(aMap);

        //get all the keys in the map and print them
        System.out.println("--------");
        System.out.print("Keys in the map: ");
        System.out.println(aMap.keySet());
        
        //get all the values in the map and print them
        System.out.print("Values in the map: ");
        System.out.println(aMap.values());
        
        //get all the entries in the map and print them
        System.out.print("Entries in the map: ");
        System.out.println(aMap.entrySet());
    }
}

/* --Program Output---
The map: {B2=Bill, B=Bill, S=Sam, J=Jane, B1=Bob}
B1 maps to Bob
B2 maps to Bill
--After removing the entry with key B2----
{B=Bill, S=Sam, J=Jane, B1=Bob}
--------
Keys in the map: [B, S, J, B1]
Values in the map: [Bill, Sam, Jane, Bob]
Entries in the map: [B=Bill, B1=Bob, J=Jane, S=Sam]
 */
