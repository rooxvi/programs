package io.ravi.programs.linkedlist.singly;

public class CLinkedList {

    public static void main(String[] args) {
        CLinkedList linkedList = new CLinkedList();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertLast(78);
        linkedList.display();
    }
    private Node head;
    private Node tail;
    private int size;

    CLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int var){
      Node node = new Node(var);
      node.next = head;
      head = node;
      if(tail == null){
          tail = head;
      }
      size++;
    }

    public void insertLast(int var){
        if(tail == null){
            insertFirst(var);
            return;
        }
        Node node = new Node(var);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertInPosition(int var,int index){
        if(size==0){
            insertFirst(var);
            return;
        }

        if(index == size){
            insertLast(var);
            return;
        }

        Node temp = head;
        for(int i = 1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(var,temp.next);
        temp.next = node;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.var+" -> ");
            temp = temp.next;
        }
        System.out.print( " END \n");
    }

    public int getSize(){
        return size;
    }
    private class Node{
        private int var;
        private Node next;
        Node(int var){
            this.var = var;
        }
        Node (int var,Node next){
            this.var = var;
            this.next = next;
        }
    }
}
