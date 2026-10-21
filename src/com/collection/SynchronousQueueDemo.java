package com.collection;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue queue = new SynchronousQueue();
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer : ");
                queue.put("Hello from producer...");
                System.out.println("Producer has transfer the message.");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Produces has interrupted..");
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to transfer : ");
                Object take = queue.take();
                System.out.println("Consumer recived a message." + take);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Produces has interrupted..");
            }
        });
        producer.start();
        consumer.start();
    }
}
