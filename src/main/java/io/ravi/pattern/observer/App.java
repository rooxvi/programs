package io.ravi.pattern.observer;

public class App {
    public static void main(String[] args) {
        MessageBoard messageBoard = new MessageBoard();
        Student ra = new Student("Ra");
        Student sa = new Student("Sa");
        Student ka = new Student("Ka");

        messageBoard.addObserver(ra);
        messageBoard.addObserver(sa);
        messageBoard.addObserver(ka);

        messageBoard.changeMessage("More HomeWord!!!");
    }
}
