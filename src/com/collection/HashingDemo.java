package com.collection;

public class HashingDemo {
    public static void main(String[] args) {
        String s1 = new String("pavan");
        String s2 = new String("napav");
        System.out.println(hash(s1).equals(hash(s2)));
    }

    private static Integer hash(String name) {
        int h1 = 0;
        for (char c : name.toCharArray()) {
            h1 += (int) c;
        }
        return h1;
    }
}
/*
whenever we have to implements the method over 
hash function will work on the basis of the
 */