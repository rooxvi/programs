package io.ravi.linkedlist;

public class SinglyLinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node (int value){
            this.value = value;
        }

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList(){
        this.size = 0;
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = this.head;
        this.head = node;

        if(tail == null){
            tail = head;
        }

        this.size++;
    }

    public void insertAtLast(int value){
        if(tail == null){
            insertAtFirst(value);
            return;
        }
        Node node = new Node(value);
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void insert(int value, int index){
        if(size == 0){
            insertAtFirst(value);
            return;
        }

        if(size == index){
            insertAtLast(value);
        }

        Node positionNode = head;
        while (index > 1 && positionNode.next != null){
            positionNode = positionNode.next;
            index--;
        }

        Node node = new Node(value,positionNode.next);
        positionNode.next = node;
        this.size++;
    }

    public int deleteFirst(){
         Node currentHead = head;
         head = head.next;
         return currentHead.value;
    }

    public int deleteLast(){
        Node currentNode = head;
        while (currentNode.next != null && currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        int value = currentNode.next.value;
        currentNode.next = null;
        return value;
    }


    public int delete(int index){
        Node currentNode = head;
        while (index>0){
            currentNode = currentNode.next;
            index--;
        }
        currentNode.next = currentNode.next.next;
        //return value;
        return 0;
    }
    public void push(int value){
        Node node = new Node(value);
        if(size == 0){
            this.head = node;
            this.tail = this.head;
        }
    }

    public void display(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("End");
        System.out.println();
    }

}
