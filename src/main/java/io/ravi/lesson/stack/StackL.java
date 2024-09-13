package io.ravi.lesson.stack;

//https://medium.com/@codingwinner/data-structures-in-java-a-beginners-guide-2024-15ebc416d1eb
public class StackL {

    private Node head;

    public int push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
           newNode.next = head;
        }
        return data;
    }

    public int pop(){
        if(head == null){
            System.out.println("Stack is empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public void display(){
        Node current = head;
        while(current != null){
            System.out.println(current.data+ " ");
            current = current.next;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int peek(){
        if(head == null){
            System.out.println("Stack is empty");
        }
        return head.data;
    }

    class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

}

