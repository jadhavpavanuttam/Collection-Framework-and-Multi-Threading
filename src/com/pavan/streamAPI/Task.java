package com.pavan.streamAPI;

public class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", i);
        }
    }
}
