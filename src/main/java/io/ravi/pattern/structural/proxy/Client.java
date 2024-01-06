package io.ravi.pattern.structural.proxy;

public class Client {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpeg");
        Image image2 = new ProxyImage("image2.jpeg");

        System.out.println(image1.display());
        System.out.println(image2.display());

        // Already loaded image
        System.out.println("--------------");
        System.out.println(image1.display());
    }
}
