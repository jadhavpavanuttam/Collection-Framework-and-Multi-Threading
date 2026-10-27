package com.pavan.streamAPI;

import java.util.function.Predicate;

import static javax.management.Query.and;

public class Java8Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(new TaskPerform(), "TASK PERFORMANCE EXECUTION STARTED..!! ");
        MathOperation mathOperation = (a, b) -> a + b;
        MathOperation mathOperation1 = (a, b) -> a - b;
        MathOperation mathOperation2 = (a, b) -> a * b;
        MathOperation mathOperation3 = (a, b) -> a / b;
        int res = mathOperation.operation(5, 2);
        int res1 = mathOperation1.operation(5, 2);
        int res2 = mathOperation2.operation(5, 2);
        int res3 = mathOperation3.operation(5, 2);
        System.out.println("Add : " + res);
        System.out.println("Sub : " + res1);
        System.out.println("Mul : " + res2);
        System.out.println("Div : " + res3);
        //predicate holds the condition and return boolean valued functio
        //Predicate -->boolean values function
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Value Return : " + isEven.test(4));
        Predicate<String> isStartWithA = x -> x.toLowerCase().startsWith("A");
        System.out.println("Result is : " + isStartWithA.test("amol"));//false
        Predicate<String> isWordEnding = p -> p.toLowerCase().endsWith("n");
        Predicate<String> and = isWordEnding.and(isStartWithA);
        System.out.println("Both Conditions Are True : " + and.test("aman"));
        //true
        System.out.println("Result is :" + isWordEnding.test("pavan"));  //false
    }
}

class TaskPerform implements Runnable, Predicate<Integer> {
    @Override
    public void run() {
        int pavan[] = {1, 2, 3, 4, 5, 56, 6, 7, 8};
        for (int x : pavan)
            System.out.print(" " + x);
    }

    @Override
    public boolean test(Integer integer) {
        return false;
    }

    @Override
    public Predicate<Integer> and(Predicate<? super Integer> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<Integer> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<Integer> or(Predicate<? super Integer> other) {
        return Predicate.super.or(other);
    }
}
/**
 * Predicate --> test
 * Function  --> apply
 * Supplier -->
 * Consumer
 */

/*
Lambda Expression : is used to implement functional interface :
Functional Programming : we will be used function as variable
shift+shift+predicate
 */