package io.ravi.lesson.stack;

public class App {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        stack.print();
    }
}
