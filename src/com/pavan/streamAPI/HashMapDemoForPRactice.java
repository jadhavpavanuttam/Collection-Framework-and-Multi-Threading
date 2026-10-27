package com.pavan.streamAPI;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
//import java.util.concurrent.ConcurrentMap;

public class HashMapDemoForPRactice {
    private static Map<Integer, String> map;

    public static void main(String[] args) {

        map = new HashMap<>(17, 0.5f);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.put(6, "f");
        map.put(7, "g");
        map.put(8, "h");
        map.put(9, "i");
        map.put(10, "j");
        map.put(11, "k");
        map.put(12, "l");
        map.put(13, "m");
        map.put(14, "n");
        map.put(15, "o");
        map.put(16, "p");
        System.out.println("removed ? " + map.remove(16, "p".toUpperCase(Locale.ROOT)));
//        map.put(null, "pavan");  //Throw null pointer exception whenever we're going to operates streams on null keys.
        System.out.println(map);
//        map.put(null, "vipul");//now pavan is replaced by vipul
        System.out.println(map.getOrDefault("a", "2"));
        System.out.println("removed ?   " + map.remove(1));
        map.entrySet()
                .stream()
                .filter(x -> x.getKey() % 2 == 1)
                .toList()
                .stream().filter(x -> !x.getValue().equalsIgnoreCase("e"))
                .skip(1)
                .toList()
                .iterator()
                .forEachRemaining(a -> System.out.println(a.getKey() + " : " + a.getValue()));

//        for (Map.Entry<Integer, String> entries : map.entrySet()) {
//            String upperCase = entries.setValue(entries.getValue()).toUpperCase(Locale.ROOT);
//            System.out.println(entries.getKey() + " : " + upperCase);
//        }
//        System.out.println("--------------------------");
//        for (Integer i : map.keySet()) {
//            if (i % 2 == 0)
//                System.out.println(i + " : " + map.get(i).toUpperCase().concat("ABAN"));
//        }


//        System.out.println("abc  :  " + hashFunction("abc"));
//        System.out.println("bca  :  " + hashFunction("acb"));
//        System.out.println("cab  :  " + hashFunction("cab"));
//        int c = hashFunction("cab");
//        System.out.println("key(c).stream().toList().iterator().next() = " + key(c).stream().toList().iterator().next());
    }

//    private static int hashFunction(String str) {
//        int s = 0;
//        char[] ch = str.toCharArray();
//        for (char c : ch)
//            s += (int) c;
//        return s % map.size();
//    }
//
//    private static Set<Integer> key(int i) {
//        return map.keySet();
//    }
//
//    private static Set<Integer> getKey() {
//        return key(1);
//    }
//
//    private static String value(int key) {
//        return map.get(key);
//    }
//
//    private static Map<Integer, String> bucket() {
//        int[] arr = new int[map.size()];
//        map.put(index(1), value(1));
//        return map;
//    }
//
//    private static int index(int key) {
//        int abcd = hashFunction("abcd");
//        return abcd % map.size();
//    }
}

/*
map has time complexity :- O(1)
containsKe()
containsValue()
put()
so which is to provide Optimized.

Internal Working Of HashMap:-
4 basic components :-
key
value
bucket
hash-function

same input will always produce same output.
step 1:
hashing the key:
step 2:
int index= hashCode % arraySize;

hashFunction :- will be produce same input with same output.

Collision :-
linked List will be to use the collisional items.
so it is more complex to searching a elements on a collisional scenario.
[a,100]-->[b,200]-->[c,300]---[n time]  O(n) time complexity.

Solution for that :
After java 8 it will be used balanced trees. to determined it

Balanced Binary Search Tree :-
converted linked list into (Red-Black Tree) size is incremented by Threshold
after Threshold 8 time complexity Log(n).

hashMap reHashing :-

the default array size of hashMap is : 16
load factor (0.75)
instead of (16 * 0.75) are inserted , the HashMap will resize
time complexity O(1) --> put() , get()

HasMap handles the collision
|
|
|("banana",30)
|
|("Apple",50)
|
|("Orange",80) -> ("Grape",20)  //Assumed collision occurred here :- store in a linked list
|
|if("Grape".equals("Grape"))-->key is stored at index
|
 */

/*
task :
to avoid where the keys are even and values are equals to the ("e" || "E")

 */