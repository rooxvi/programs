package io.ravi.pattern.structural.proxy;

public class RealImage implements Image{
    private String imageName;

    public RealImage(String imageName){
        this.imageName = imageName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk(){
        System.out.println("Image loaded.... :"+imageName);
    }

    @Override
    public String display() {
        return "You accessed image: "+imageName;
    }
}
