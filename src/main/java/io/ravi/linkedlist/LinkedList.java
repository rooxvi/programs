package io.ravi.linkedlist;

public class LinkedList {

    class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;

    public void traverse(){
        Node temp = head;

        while (temp.next != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node insert(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
        return head;
    }

    public Node insertAtEnd(int value){
        Node node = new Node(value);
        Node ptr = head;
        while (ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = node;
        return head;
    }

    public Node insertAtMiddle(int value,int position){
        Node node = new Node(value);

        //Move position
        Node ptr = head;
        for (int i=0;i<position;i++){
            ptr = ptr.next;
        }

        //Insert the node
        node.next = ptr.next;
        ptr.next = node;

        return head;
    }


    public Node delete(){
        //Just move the head to the next position
        head = head.next;
        return head;
    }

    public Node deleteAtEnd(){
        Node ptr = head;

        //Move to the second last node
        while (ptr.next.next != null){
            ptr = ptr.next;
        }

        //Point the next of second last node to null
        ptr.next = null;

        return head;
    }

    public Node deleteAtMiddle(int position){

        //Move to previous position of node to delete
        Node ptr = head;
        for (int i = 0; i < position-1; i++) {
            ptr = ptr.next;
        }

        //Get the node to delete
        Node nodeToDelete = ptr.next;

        //Get the address of node next to the node to be deleted
        Node nodeNext = nodeToDelete.next;

        //Point the next of ptr to nextNode
        ptr.next = nodeNext;

        return head;
    }

}
