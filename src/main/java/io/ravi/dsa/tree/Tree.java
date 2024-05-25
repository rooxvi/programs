package io.ravi.dsa.tree;

public class Tree {

    private Node root;

    public Node search(int data){
        Node current = root;
        System.out.print("Visiting elements: ");
        while(current.data != data){
            if(current != null)
                System.out.print(current.data + " ");
            //go to left tree
            if(current.data > data){
                current = current.leftChild;
            }//else go to right tree
            else{
                current = current.rightChild;
            }
            //not found
            if(current == null){
                return null;
            }
        }
        return current;
    }

    public class Node {
        public int data;
        public Node leftChild;
        public Node rightChild;

        public Node(){}

        public void display(){
            System.out.print("("+data+ ")");
        }
    }
}
