package io.ravi.pattern.singleton;

public class SingletonV2 {

    private SingletonV2(){}

    private static class SingletonHolder{
        public static final SingletonV2 INSTANCE = new SingletonV2();
    }

    public static SingletonV2 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
