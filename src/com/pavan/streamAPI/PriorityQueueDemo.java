package com.pavan.streamAPI;

import com.sun.jdi.event.ThreadStartEvent;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        System.out.println("Offer : " + queue.offer(6));
        System.out.println("Offer : " + queue.offer(3));
        System.out.println("Offer : " + queue.offer(2));
        System.out.println("Offer : " + queue.offer(5));
        System.out.println("Offer : " + queue.offer(16));
        System.out.println("Offer : " + queue.offer(9));
        System.out.println(queue.poll());  //highest element can give as output
        queue.stream().findAny().ifPresent(System.out::println);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(12);
        deque.push(10);
        deque.push(8);
        deque.push(7);
        System.out.println(deque.clone());
        System.out.println("offer : " + deque.offer(2));
        System.out.println("Offer first : " + deque.offerFirst(23));
        System.out.println("Offer last : " + deque.offerFirst(25));
        int c = 0;
        for (Integer i : deque.stream().toList()) {
            System.out.println(++c + " : " + i);
        }
        c = 0;
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext())
            System.out.println(++c + " : " + iterator.next());
        System.out.println("pop() : " + deque.pop());
        System.out.println("pollFirst() : " + deque.pollFirst());
        System.out.println("pollLast() : " + deque.pollLast());
        System.out.println("poll() : " + deque.poll());
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                integers.add(i);
            }
            for (int i = 0; i < 10000; i++) {
                integers.add(i);
            }
        });
        thread.start();
        try {
            Thread.sleep(1000L, TimeUnit.MILLISECONDS.ordinal());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                integers.add(i);
            }
            for (int i = 0; i < 10000; i++) {
                integers.add(i);
            }

        });
        thread1.start();
        try {
            synchronized (thread) {
                thread.join();
            }
            synchronized (thread1) {
                thread1.join();
            }
        } catch (Exception r) {
            r.printStackTrace();
        }
        System.out.println("size  of list is : " + integers.size());
    }
}
/*
Priority Queue is always gives output into the sorted order
min-heap
 */