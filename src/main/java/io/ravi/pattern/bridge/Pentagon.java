package io.ravi.pattern.bridge;

public class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
      color.applyColor();
    }
}
