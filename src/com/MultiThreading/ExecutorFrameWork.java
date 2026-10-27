package com.MultiThreading;

import java.util.*;
import java.util.concurrent.*;

public class ExecutorFrameWork {
    private static final CountDownLatch latch = new CountDownLatch(4);
    int x = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });

            Future<String> database = executor.submit(() -> "D.B.");
            Future<String> auth = executor.submit(() -> "Auth ");
            Future<String> payment = executor.submit(() -> "Payment Gateway");
            Future<String> health = executor.submit(() -> "Health Check");
            Future<String> register = executor.submit(() -> "Register User");
            List<String> list = new ArrayList<>(
                    Arrays.asList(database.get(),
                            payment.get(),
                            health.get(),
                            register.get(),
                            auth.get()));

            try {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (latch.await(5, TimeUnit.MILLISECONDS)) {
                        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
                        System.out.println("CONTAINING VALUE : " + iterator.next());
                    }

                    System.out.println("LATCH : " + latch.getCount());
                }

            } catch (Exception e) {
                if (!e.equals("")) {
                    System.out.println("THREAD IS INTERRUPTED....!!");
                    Thread.currentThread().interrupt();
                }
            }
        }

        executor.shutdown();
//        try {
//            executor.awaitTermination(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Total time " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}