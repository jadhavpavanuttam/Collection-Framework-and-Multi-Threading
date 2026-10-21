package com.collection;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
// synchronized list
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        // Create an ArrayList of integers
        List<Integer> numbers = new ArrayList<>();

        // Add elements to the list
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Access elements by index
        int secondNumber = numbers.get(1); // Accessing the second element (20)

        // Update an element
        numbers.set(0, 15); // Replacing the first element (10) with 15

        // Remove an element
        numbers.remove(2); // Removing the third element (30)

        // Check if an element is in the list
        boolean containsTwenty = numbers.contains(20); // false

        // Returns the size of the list
        int size = numbers.size(); // Size is now 2

        // Create an iterator
        Iterator<Integer> iterator = numbers.iterator();

        // Print the elements of the list
        while (iterator.hasNext()) {
            int number = iterator.next();
            System.out.println(number);
        }

        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass().getName());
        List<String> strings = Arrays.asList("Monday", "Tuesday", "Tursday");
        System.out.println(strings.getClass().getName());
        List<String> list3 = new ArrayList<>(strings);
        list3.addAll(strings);

        Set<String> stringSet = new HashSet<>();
        stringSet.addAll(list3);
        System.out.println(stringSet);
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("Index :  " + i + " ,  Element : " + list3.get(i));//In Case Of : list.get(3) it will throw exception

        }
        List<Integer> list1 = List.of(1, 2, 34, 234, 324);
//        System.out.println(list1.set(1, 123)); //Immutable Object comings on : java 9
        Iterator<Integer> iterator1 = list1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());

        }
    }
}

/*
Used For Two Thinks :
1.used whenever we want ordered collection
2.Allowing to duplicate elements

Internal Working :
dynamically size is increased unlike array


 */