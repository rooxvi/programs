package io.ravi.pattern.structural.proxy;

public class ProxyImage implements Image{
    private String imageName;
    private RealImage realImage;
    public ProxyImage(String imageName){
        this.imageName = imageName;
    }
    @Override
    public String display() {
        if (realImage == null){
            realImage = new RealImage(imageName);
        }
        return realImage.display();
    }
}
