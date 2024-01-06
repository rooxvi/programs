package io.ravi.pattern.singleton;

public class SingletonV1 {

    private static volatile SingletonV1 INSTANCE;

    private SingletonV1(){}

    public static SingletonV1 getInstance(){
        if (INSTANCE == null){
            synchronized (SingletonV1.class){
                if (INSTANCE == null){
                    INSTANCE = new SingletonV1();
                }
            }
        }
        return INSTANCE;
    }

}
