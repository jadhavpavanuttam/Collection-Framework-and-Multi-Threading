package com.mapClasses;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"Amol");
        map.put(2,"Shubham");
        map.put(3,"Jagruti");
        map.put(null,"Pavan");
        map.put(2,"Arjun");
        for (Integer i : map.keySet()) {
            System.out.println(i);
        }
        for (String value : map.values()) {
            System.out.println(value);
        }

        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
//            System.out.println(integerStringEntry.setValue(integerStringEntry.getValue().toUpperCase()));
        integerStringEntry.setValue(integerStringEntry.getValue().toUpperCase());
        }
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println(integerStringEntry);
        }

        map.remove(1);

      int x=  map.size();
        System.out.println("Size is : "+x);
        System.out.println("Getting from map : "+map.get("pavan".equalsIgnoreCase(map.get(null))));
        Object cln=map.clone();
        System.out.println("Cloning is : "+cln);
        System.out.println("Regular map : "+map);


    }
}

/*
Internal structure of HashMap :

1.Key

2.Value

3.bucket

4.Hash function
perform same input => output


:: Index = HashCode % ArraySize

collision : more than one input get same output
 */
