//class method version (midterm)
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.ArrayDeque;
import java.util.Iterator;

public class LinkedListProblems {

    // Question 1: getMax from LinkedList
    public static int getMax(LinkedList<Integer> numList) {
        if (numList.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        int max = numList.getFirst();
        for (int num : numList) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Question 2: getMax method in SimpleLinkedList class
    public static class SimpleLinkedList {
        private Node head;

        public int getMax() {
            if (head == null) {
                throw new NoSuchElementException("List is empty");
            }
            int max = head.value;
            Node current = head;
            while (current != null) {
                if (current.value > max) {
                    max = current.value;
                }
                current = current.next;
            }
            return max;
        }

        // Inner class Node for SimpleLinkedList
        private static class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        // Method to add elements for testing
        public void add(int value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    }

    // Question 3: getMax method in SingleLinkedList class
    public static class SingleLinkedList<E extends Comparable<E>> {
        private Node<E> head;

        public E getMax() {
            if (head == null) {
                throw new NoSuchElementException("List is empty");
            }
            E max = head.value;
            Node<E> current = head;
            while (current != null) {
                if (current.value.compareTo(max) > 0) {
                    max = current.value;
                }
                current = current.next;
            }
            return max;
        }

        // Inner class Node for SingleLinkedList
        private static class Node<E> {
            E value;
            Node<E> next;

            Node(E value) {
                this.value = value;
            }
        }

        // Method to add elements for testing
        public void add(E value) {
            Node<E> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
        }
    }

    // Question 4: count method
    public static int count(LinkedList<Integer> numList, int num) {
        int count = 0;
        for (int currentNum : numList) {
            if (currentNum == num) {
                count++;
            }
        }
        return count;
    }

    // Question 5: reverseWordsInList method
    public static LinkedList<String> reverseWordsInList(LinkedList<String> wordList) {
        LinkedList<String> reversedList = new LinkedList<>();
        for (String word : wordList) {
            reversedList.add(new StringBuilder(word).reverse().toString());
        }
        return reversedList;
    }

    // Question 6: merge method
    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> mergedList = new LinkedList<>();
        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();

        Integer val1 = it1.hasNext() ? it1.next() : null;
        Integer val2 = it2.hasNext() ? it2.next() : null;

        while (val1 != null || val2 != null) {
            if (val2 == null || (val1 != null && val1 <= val2)) {
                mergedList.add(val1);
                val1 = it1.hasNext() ? it1.next() : null;
            } else {
                mergedList.add(val2);
                val2 = it2.hasNext() ? it2.next() : null;
            }
        }
        return mergedList;
    }

    // Question 7: stackToListTopDwn method
    public static LinkedList<Integer> stackToListTopDwn(ArrayDeque<Integer> stack) {
        LinkedList<Integer> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    // Question 8: stackToListBottomUp method
    public static LinkedList<Integer> stackToListBottomUp(ArrayDeque<Integer> stack) {
        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Integer> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Testing can be done here for each method
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println("Max in LinkedList: " + LinkedListProblems.getMax(nums));

        LinkedListProblems.SimpleLinkedList simpleList = new LinkedListProblems.SimpleLinkedList();
        simpleList.add(2);
        simpleList.add(4);
        simpleList.add(6);
        System.out.println("Max in SimpleLinkedList: " + simpleList.getMax());

               // Test for getMax in SingleLinkedList
               LinkedListProblems.SingleLinkedList<Integer> singleList = new LinkedListProblems.SingleLinkedList<>();
               singleList.add(10);
               singleList.add(20);
               singleList.add(15);
               System.out.println("Max in SingleLinkedList: " + singleList.getMax());

                      // Test for count method
        System.out.println("Count of 5 in LinkedList: " + LinkedListProblems.count(nums, 5));

        // Test for reverseWordsInList
        LinkedList<String> wordList = new LinkedList<>();
        wordList.add("hello");
        wordList.add("world");
        System.out.println("Reversed Words: " + LinkedListProblems.reverseWordsInList(wordList));

         // Test for merge method
         LinkedList<Integer> list1 = new LinkedList<>();
         LinkedList<Integer> list2 = new LinkedList<>();
         list1.add(1);
         list1.add(3);
         list1.add(5);
         list2.add(2);
         list2.add(4);
         list2.add(6);
         System.out.println("Merged List: " + LinkedListProblems.merge(list1, list2));

            // Test for stackToListTopDwn
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack to List (Top Down): " + LinkedListProblems.stackToListTopDwn(stack));

          // Re-populate the stack for the next test
          stack.push(1);
          stack.push(2);
          stack.push(3);
  
          // Test for stackToListBottomUp
          System.out.println("Stack to List (Bottom Up): " + LinkedListProblems.stackToListBottomUp(stack));
 

    }
}
