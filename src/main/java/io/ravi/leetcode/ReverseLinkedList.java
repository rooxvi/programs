package io.ravi.leetcode;

import java.util.Stack;

public class ReverseLinkedList {
}


class OptimizedWay{

    class Node {
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public Node reverseWithStack(Node head){
        //Either linked list is empty or having single node
        if(head == null || head.next == null){
            return head;
        }

      /*
      Required 3 nodes to do this operation previous, current and next
        Step 1: Create next node as current node next
        Step 2: Make current node next to previous node
        Step 3: Previous node is current node
        Step 4: Current node = next node
       */

        Node previosNode = null;
        Node currentNode = head;

        while(currentNode != null){
         Node nextNode = currentNode.next;
         currentNode.next = previosNode;
         previosNode = currentNode;
         currentNode = nextNode;
        }

        return head;
    }
}


//Using stack data structure LIFO: Last in First Out

class StackMethod{

    class Node {
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    public Node reverseWithStack(Node head){
        Stack<Integer> valueStack = new Stack<>();
        while (head.next != null){
            valueStack.push(head.value);
            head = head.next;
        }

        Node reverseList = new Node(Integer.MIN_VALUE);
        Node ptr = reverseList;

        while (!valueStack.isEmpty()){
            ptr.next = new Node(valueStack.pop());
            ptr = ptr.next;
        }

        return reverseList.next;
    }
}
