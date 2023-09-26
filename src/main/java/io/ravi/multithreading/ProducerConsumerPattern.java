package io.ravi.multithreading;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        ArrayBlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        final Runnable producer = ()->{
          while (true){
              queue.add(new Item());
          }
        };

        final Runnable consumer = ()->{
            while (true){
                //Item item = queue.take();

            }
        };
    }


}

class Item{

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("A");
        queue.add("C");
        queue.add("B");

        for (String string: queue){
            System.out.print(string+" ");
        }


    }

}
