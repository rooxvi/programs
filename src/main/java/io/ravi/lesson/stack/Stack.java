package io.ravi.lesson.stack;

public class Stack {
    int top;
    int size;
    int[] stack;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void print() {
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i] + " ");
        }
    }
}
