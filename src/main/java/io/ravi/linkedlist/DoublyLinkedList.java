package io.ravi.linkedlist;

public class DoublyLinkedList<T> {

    int size;
    Node head;
    Node tail;

    public <T> void push(T value){
        Node node = new Node<>(value);
        if(this.size == 0){
           this.head = node;
           this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
        this.size++;
    }

    class Node<T> {
        T value;
        Node next;
        Node prev;
        public Node(T value){
            this.value = value;
        }
    }
}
