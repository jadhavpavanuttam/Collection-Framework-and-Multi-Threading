package com.mapClasses;
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        // Create a TreeMap to store age-name pairs
        TreeMap<Integer, String> ageNameMap = new TreeMap<>();

        // Add age-name pairs to the TreeMap
        ageNameMap.put(25, "John");
        ageNameMap.put(30, "Alice");
        ageNameMap.put(22, "Bob");
        ageNameMap.put(28, "Eve");

        // Retrieve and print the names of people by their ages
        System.out.println("Name of person with age 25: " + ageNameMap.get(25));
        System.out.println("Name of person with age 30: " + ageNameMap.get(30));

        // Iterate through the TreeMap and print all age-name pairs in ascending order of age
        System.out.println("All Age-Name Pairs:");
        for (Map.Entry<Integer, String> entry : ageNameMap.entrySet()) {
            int age = entry.getKey();
            String name = entry.getValue();
            System.out.println("Age: " + age + ", Name: " + name);
        }
    }
}