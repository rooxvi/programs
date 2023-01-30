package io.ravi.programs;

public class ThreadOne {
    public static void main(String[] args) {
        ThreadEx one = new ThreadEx();
        ThreadEx two = new ThreadEx();
        Thread a = new Thread(one);
        Thread b = new Thread(two);
        a.setDaemon(true);
        a.start();

       // b.start();
        System.out.println("Main out..");
    }
}

class ThreadEx implements Runnable{

    @Override
    public void run() {
        int i = 12;
        while (i>0){
            //System.out.println(""+i);
        }
        System.out.println("Exit...");
    }
}
