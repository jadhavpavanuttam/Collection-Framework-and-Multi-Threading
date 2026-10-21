package com.MultiThreading;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutiveServiceDemo {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService service = Executors.newCachedThreadPool()  -->service.execute(runnable);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future f1 = executorService.submit(new Callable() {
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });
        try {

            System.out.println("future.get() = " + f1.get());
        } catch (Exception s) {
            s.printStackTrace();
        }


        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        //invokeAll(callable)  --> how it works ?
        List<Future<String>> futures = executorService.invokeAll(callables);
        for (Future<String> future : futures) {
            try {

                System.out.println("future.get = " + future.get());
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

        executorService.shutdown();
    }
}
