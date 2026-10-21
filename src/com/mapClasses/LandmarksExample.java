package com.mapClasses;

import java.util.Hashtable;

public class LandmarksExample {
    public static void main(String[] args) {
        // Create a HashTable to store country-landmark pairs
        Hashtable<String, String> landmarks = new Hashtable<>();

        // Add country-landmark pairs
        landmarks.put("India", "Taj Mahal");
        landmarks.put("France", "Eiffel Tower");
        landmarks.put("China", "Great Wall of China");
        landmarks.put("USA", "Statue of Liberty");

        // Retrieve and print landmarks
        String landmarkIndia = landmarks.get("India");
        String landmarkFrance = landmarks.get("France");
        String landmarkChina = landmarks.get("China");
        String landmarkUSA = landmarks.get("USA");

        System.out.println("Famous Landmarks:");
        System.out.println("India: " + landmarkIndia);
        System.out.println("France: " + landmarkFrance);
        System.out.println("China: " + landmarkChina);
        System.out.println("USA: " + landmarkUSA);
    }
}