package com.collection;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueDemo {
    static final int QUEUE_CAPACITY = 10;
    static BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {
        // Producer thread
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    taskQueue.put(i);
                    System.out.println("Task produced: " + i);
                    Thread.sleep(10); // Simulate task generation time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer threads
        Thread consumerThread1 = new Thread(() -> {
            try {
                while (true) {
                    int task = taskQueue.take();
                    processTask(task, "Consumer 1");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread2 = new Thread(() -> {
            try {
                while (true) {
                    int task = taskQueue.take();
                    processTask(task, "Consumer 2");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }

    private static void processTask(int task, String consumerName) throws InterruptedException {
        // Simulate task processing
        System.out.println("Task being processed by " + consumerName + ": " + task);
        Thread.sleep(1000);
        System.out.println("Task consumed by " + consumerName + ": " + task);
    }
}

//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
//        // thread-safe queue
//        // wait for queue to become non-empty / wait for space
//        // simplify concurrency problems like producer-consumer
//        // standard queue --> immediately
//        // empty --> remove ( no waiting )
//        // full --> add ( no waiting )
//        // Blocking queue
//        // put -->  Blocks if the queue is full until space becomes available
//        // take --> Blocks if the queue is empty until an element becomes available
//        // offer --> Waits for space to become available, up to the specified timeout
//
//        // A bounded, blocking queue backed by circular array
//        // low memory overhead
//        // uses a single lock for both enqueue and dequeue operations
//        // more threads --> problem
//        Thread producer = new Thread(new Producer(queue));
//        Thread consumer = new Thread(new Consumer(queue));
//        producer.start();
//        consumer.start();
//        BlockingQueue<Integer> queue1 =  new LinkedBlockingQueue<>();
//        // optionally bounded backed by LinkedList
//        // Uses two separate locks for enqueue and dequeue operations
//        // Higher concurrency between producers and consumers
//        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
//        // unbounded
//        // Binary Heap as array and can grow dynamically
//        // Head is based on their natural ordering or a provided Comparator like priority queue
//        // put wont block
//        queue2.add("apple");
//        queue2.add("banana");
//        queue2.add("cherry");
//        System.out.println(queue2);
//        BlockingQueue<Integer> queue3 =  new SynchronousQueue<>();
//        // each insert operation must wait for a corresponding remove operation by another thread and vice versa.
//        // it cannot store elements, capacity of at most one element
