package io.ravi.pattern.bridge;

public class App {
    public static void main(String[] args) {

        Shape triangle = new Triangle(new Red());
        triangle.applyColor();
        
    }
}
