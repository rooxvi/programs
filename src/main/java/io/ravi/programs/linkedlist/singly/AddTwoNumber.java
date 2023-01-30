package io.ravi.programs.linkedlist.singly;

public class AddTwoNumber {


    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result = addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node head = null;
        Node current = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }

            carry = sum / 10;
            Node next_node = new Node(sum % 10);

            if (current == null) {
                current = head = next_node;
            } else {
                current.next = next_node;
                current = current.next;
            }
        }

        if (carry > 0) {
            current.next = new Node(carry);
        }
        return head;
    }

    public static Node addTwoNumbersSimplyfied(Node l1, Node l2) {
        Node head = null;
        Node current = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null?0:l1.value;
            int val2 = l2 == null?0:l2.value;
            int sum = val1 + val2 + carry;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            carry = sum / 10;
            Node next_node = new Node(sum % 10);

            if (current == null) {
                current = head = next_node;
            } else {
                current.next = next_node;
                current = current.next;
            }
        }

        if (carry > 0) {
            current.next = new Node(carry);
        }
        return head;
    }


    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
