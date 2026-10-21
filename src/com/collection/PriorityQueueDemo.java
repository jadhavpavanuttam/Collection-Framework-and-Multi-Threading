package com.collection;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        // part of the Queue interface
        // orders elements based on their natural ordering (for primitives lowest first)
        // custom comparator for customised ordering
        // does not allow null elements
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Enqueue elements with different priorities
        priorityQueue.add(20);
        priorityQueue.add(10);
        priorityQueue.add(30);

        // Print the priority queue
        System.out.println("Priority Queue: " + priorityQueue);

        // Dequeue elements (highest priority first)
        int dequeuedElement = priorityQueue.poll();
        System.out.println("Dequeued Element: " + dequeuedElement);
        System.out.println("Updated Priority Queue: " + priorityQueue);


        // internal working
        // PriorityQueue is implemented as a min-heap by default (for natural ordering)

    }
}
