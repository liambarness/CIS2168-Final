public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    // Remove a node from the list
    public void remove(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }
                return;
            }
            current = current.next;
        }
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original List:");
        list.display();

        list.remove(3);
        System.out.println("List after removing 3:");
        list.display();

        list.remove(1);
        System.out.println("List after removing 1:");
        list.display();

        list.add(5);
        System.out.println("List after adding 5:");
        list.display();
    }
}
