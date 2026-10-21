package com.mapClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualdMethod {
    public static void main(String[] args) {
        Person p1 = new Person("Pavan", 1);  //differ hashcode
        Person p2 = new Person("Ganesh", 2);
        Person p3 = new Person("Jagruti", 3);
        Person p4 = new Person("Pavan", 1);  //differ hadhcode due to new keyword
        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "Engineer");  //hashCode()-->index
        map.put(p2, "Designer");  //hashCode()-->index
        map.put(p3, "Manager");   //hashCode()-->index
        map.put(p4, "CEO");       //hashCode()-->index

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 92); //hashcode 1->index 1
        map1.put("Neha", 91);    //hashcode 2->index 2
        map1.put("Shubham", 97);  //hashcode 1->index 1->equals() -->replace
        System.out.println("Map 1 Size :  " + map.size() + "  ,\nMap 2 Size :  " + map1.size());
        System.out.println(map.get(p1));
        System.out.println(map.get(p3));
        System.out.println("All from 2nd map : " + map1);

    }
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name) && id == other.getId();
    }

    @Override
    public String toString() {
        return "id " + id + "Name " + name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
in future hasCode() & equals() method's make sure to implement
which is used to concepts of HashSet concepts.

 Time Complexity :
 put(key , value) --> O(1)
 get(key) -->    O(1)
 remove(key) -->     O(1)
 remove(key , value) --> O(1)
 */