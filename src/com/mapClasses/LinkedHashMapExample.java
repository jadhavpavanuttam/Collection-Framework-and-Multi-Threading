package com.mapClasses;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Create a LinkedHashMap to store country-capital pairs
        LinkedHashMap<String, String> countryCapitalMap = new LinkedHashMap<>();

        // Add country-capital pairs
        countryCapitalMap.put("India", "New Delhi");
        countryCapitalMap.put("USA", "Washington, D.C.");
        countryCapitalMap.put("China", "Beijing");
        countryCapitalMap.put("France", "Paris");

        // Retrieve and print the capitals of selected countries
        String capitalOfIndia = countryCapitalMap.get("India");
        String capitalOfUSA = countryCapitalMap.get("USA");

        System.out.println("Capital of India: " + capitalOfIndia);
        System.out.println("Capital of USA: " + capitalOfUSA);

        // Iterate through the LinkedHashMap and print all country-capital pairs
        System.out.println("All Country-Capital Pairs:");
        for (Map.Entry<String, String> entry : countryCapitalMap.entrySet()) {
            String country = entry.getKey();
            String capital = entry.getValue();
            System.out.println(country + " - " + capital);
        }
    }
}