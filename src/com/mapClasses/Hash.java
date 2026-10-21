package com.mapClasses;

public class Hash {

    public static void main(String[] args) {
//        System.ousou
        System.out.println("jagruti : " + simpleHash("jagruti"));
        System.out.println("ijatgru : " + simpleHash("ijatgru"));
    }

    private static int simpleHash(String key) {
        int sum = 0;
        for (char c : key.toCharArray())
            sum += (int) c;
        return sum % 10;
    }
}
/*
Collision condition :

Same Output 1: 2
Same Output 2: 2
same Output 3: 8

used in this case :

internal structure of linkedList :
class Node<K,V>
{
final int hash;
final K key;
V value;
Node<K,V> next;
S|||Y
when can go out of certain
after java 8 used balanced tree certain Threshold
or
red-black tree

Hashmap Resizing(Rehashing)
Hashmap has an internal array size by default 16
increased by 0.75
time complexity :
O(1)
basic operation
get() & put()
}

 */