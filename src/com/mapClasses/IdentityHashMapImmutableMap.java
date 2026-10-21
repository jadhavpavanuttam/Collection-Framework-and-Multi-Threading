package com.mapClasses;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.HashMap;

import java.util.Collections;

public class IdentityHashMapImmutableMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new IdentityHashMap<>();
        String key1 = new String("Akshit");
        String key2 = new String("Akshit");
        map.put(key1, 90);
        map.put(key2, 92);
        System.out.println(map);
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
//        map2.put("C", 3); throws exception
        Map<String, Integer> map3 = Map.of("Shubham", 98, "Vivek", 89);
        map3.put("Akshit", 88);
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Vivek", 99));


    }
}