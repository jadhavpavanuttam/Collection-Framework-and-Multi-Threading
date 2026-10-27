package com.collection;

import java.util.*;
import java.util.function.Consumer;


class ComparableExample {
    public ComparableExample() {
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("pavan");
        list.add("Amol");
        list.addFirst("Nandani");
        list.addLast("Jagruti");
        list.add(2, "Bhagyashri");
        System.out.println("The List Is Types Casting Into Set is  " + " : " + new HashSet<>(list).add("Banty.."));
        ; //true

        Collections.sort(list);
        System.out.println("Sorte List Is : " + list);
        Set<String> set = new HashSet<>(list);
        System.out.println(set.getClass().getName() + " : " + list.getClass().getName() + " :  " + set);
        Queue<String> queue = new LinkedList<>(set);
        System.out.println("Poll Means Remove First : " + queue.poll());
        System.out.println("Is It True Or False : " + new HashSet<>(queue).addAll(list));  //true
        queue.addAll(list);
        System.out.println(queue.peek());
        Consumer<String> printName = name -> System.out.println(list);
        List<String> names = Arrays.asList("sdf", "Asdfd", "SDfsdf", "sdfd", "Wtretrt", "Wertre", "Uytutyu");
        names.stream().peek(name -> System.out.println("Processing...." + names)).forEach(System.out::println);
    }
}