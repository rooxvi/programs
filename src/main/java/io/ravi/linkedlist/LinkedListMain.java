package io.ravi.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        l.insertAtFirst(1);
        l.insertAtFirst(2);
        l.insertAtFirst(3);
        l.insertAtLast(8);
        l.insertAtLast(89);
        l.insert(67,4);
        l.display();
        System.out.println("Deleted : "+l.deleteFirst());
        l.display();
        System.out.println("Deleted last : "+l.deleteLast());
        l.display();
    }
}
