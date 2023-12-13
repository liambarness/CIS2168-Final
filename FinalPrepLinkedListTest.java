//Not subclass version (From final study guide)
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class FinalPrepLinkedListTest {

    public static void main(String[] args) {


        //Q1 test: getMax(LinkedList<Integer>) outside class LinkedList
        LinkedList<Integer> numList = new LinkedList<>();
        //or use:
        //   var numList = new LinkedList<Integer>();
        numList.add(10);
        numList.add(20);
        numList.add(40);
        numList.add(30);
        numList.add(20);
        numList.add(30);
        numList.add(40);
        numList.add(20);
        System.out.println(getMax(numList));

        //Q2 test: count(LinkedList<Integer>, int)
        System.out.println(count(numList, 20));
        System.out.println(count(numList, 40));
        System.out.println(count(numList, 60));

        //Q3 test: reverseWordsInList(LinkedList<String>)
        LinkedList<String> sweetList = new LinkedList<>();
        //or use:
        //   var sweetList = new LinkedList<String>();
        sweetList.add("choclate");
        sweetList.add("donut");
        sweetList.add("cake");
        sweetList.add("icecream");
        sweetList.add("strawberry");
        System.out.println(sweetList);
        System.out.println(reverseWordsInList(sweetList));

        //Q4 test: merge(LinkedList<Integer>, LinkedList<Integer>)
        LinkedList<Integer> list1 = new LinkedList<>();
        //or use
        //    var list1 = new LinkedList<Integer>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        LinkedList<Integer> list2 = new LinkedList<>();
        //or use
        //    var list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(10);
        list2.add(15);
        list2.add(20);
        list2.add(35);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(merge(list1, list2));

    }

    //--Practice Q1---//
    public static int getMax(LinkedList<Integer> numList) {
        //Solution 1: O(n)
        /*
         int max = Integer.MIN_VALUE;
         for (int n : numList) {
            if (n > max) {
                max = n;
            }
         }
         return max;
         */

        //Solution 2: O(n)
        /*
        if (numList.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        Iterator<Integer> iter = numList.iterator();
        while (iter.hasNext()) {
            int currentItem = iter.next();
            if (max < currentItem)  {
                max =  currentItem;
            }
        }
        */

        //Solution 3: O(n^2)
        if (numList.size() == 0) {
            return Integer.MIN_VALUE;
        }

        int max = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            int currentItem = numList.get(i);
            if (currentItem > max) {
                max = currentItem;
            }
        }
        return max;
    }

    //--Practice Q4---//
    //Big-O: O(n), n: given list size
    //count and return how many times the given number appears in the given number list.
    public static int count(LinkedList<Integer> numList, int num) {
        int counter = 0;
        for (int n : numList) {
            if (n == num) {
                counter++;
            }
        }
        return counter;
    }

    //--Practice Q5---//
    //Big-O: O(n), assume that each word is no more than 20 characters long.
    //reverse each word in the given word list and return this new list.
    public static LinkedList<String> reverseWordsInList(LinkedList<String> wordList) {
        LinkedList<String> reversedWordList = new LinkedList<>();

        for (String word : wordList) {
            //push each character in word to the stack
            Deque<Character> charStack = new ArrayDeque<>();
            for (int i = 0; i < word.length(); i++) {
                charStack.push(word.charAt(i));
            }
            //get the word reversal by popping from stack
            StringBuilder wordReversed = new StringBuilder();
            while (!charStack.isEmpty()) {
                wordReversed.append(charStack.pop());
            }
            //append to return list
            reversedWordList.add(wordReversed.toString());
        }

        return reversedWordList;
    }

    //--Practice Q6---//
    //Big-O: O(n^2), n: longer list size
    //precondition: list1, list2 are both sorted in increasing order
    //merge two sorted lists into a new sorted list containg all in both lists, return the new list.
    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> listToReturn = new LinkedList<>();
        int i = 0; //list1 pointer
        int j = 0; //list2 pointer
        int list1Size = list1.size();
        int list2Size = list2.size();
        //while (neither source list is entirely processed), continue the loop
        while (i < list1Size && j < list2Size) {
            int currList1Data = list1.get(i);
            int currList2Data = list2.get(j);
            //add the smaller element in either list to new sorted list
            if (currList1Data < currList2Data) { //smaller element in list1
                listToReturn.add(currList1Data);
                i++;
            } else {                              //smaller element in list2
                listToReturn.add(currList2Data);
                j++;
            }
        }

        //append all remaining elements in list1 (if any) to new sorted list: listToReturn
        while (i < list1Size) {
            listToReturn.add(list1.get(i));
            i++;
        }

        //append all remaining elements in list2 (if any) to new sorted list: listToReturn
        while (j < list2Size) {
            listToReturn.add(list2.get(j));
            j++;
        }

        return listToReturn;
    }

//Note this second version is wrong.
//    public static LinkedList<Integer> merge2(LinkedList<Integer> list1,
//            LinkedList<Integer> list2) {
//        LinkedList<Integer> list3 = new LinkedList<>();
//
//        Iterator<Integer> iter1 = list1.iterator();
//        Iterator<Integer> iter2 = list2.iterator();
//
//        while (iter1.hasNext() && iter2.hasNext()) {
//            int list1Item = iter1.next();
//            int list2Item = iter2.next();
//            if (list1Item < list2Item) {
//                list3.add(list1Item);
//                iter1.next();   //still wrong even if removing this line
//            } else {
//                list3.add(list2Item);
//                iter2.next();   //still wrong even if removing this line
//            }
//        }
//
//        while (iter1.hasNext()) {
//            int list1Item = iter1.next();
//            list3.add(list1Item);
//            iter1.next();
//        }
//
//        while (iter2.hasNext()) {
//            int list2Item = iter2.next();
//            list3.add(list2Item);
//            iter2.next();
//        }
//
//        return list3;
//    }


}
