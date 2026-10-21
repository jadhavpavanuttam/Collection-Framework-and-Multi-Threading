package com;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;


public class MainClass {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>(new TreeMap<>(Map.of(
                1, new Student(1, 2.12f, "ajay"),
                2, new Student(8, 1.32f, "atul"),
                5, new Student(4, 0.42f, "amol"),
                4, new Student(6, 1.54f, "kalpesh"),
                6, new Student(7, 0.82f, "nilesh"),
                8, new Student(5, 2.2f, "om"),
                9, new Student(9, 0.32f, "ram"),
                10, new Student(10, 1.62f, "ramu")
        ))
        );
        System.out.println(map);

        for (Map.Entry<Integer, Student> x : map.entrySet()) {
            if (x.getValue().getMarks() < 3.21) {
                x.getValue().setMarks(x.getValue().getMarks() + 89);
            }
            System.out.println("Id: " + x.getKey() + " -->  " + x.getValue());
        }
//        NavigableMap<Integer,Student> map1=new TreeMap<>(map)
        ConcurrentHashMap<Integer, Student> concurrent = new ConcurrentHashMap<>(map);
        for (Map.Entry<Integer, Student> f : concurrent.entrySet()) {
            System.out.println(f.getKey() + " : " + f.getValue());
            map.put(12, new Student(12, 91.23f, "pavan"));
        }
        concurrent.clear();

    }

    private static class Student {
        int rollNo;
        float marks;
        String name;

        public Student(int rollNo, float marks, String name) {
            this.rollNo = rollNo;
            this.marks = marks;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return rollNo == student.rollNo && Float.compare(marks, student.marks) == 0 && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rollNo, marks, name);
        }

        public int getRolNo() {
            return rollNo;
        }

        public void setRolNo(int rolNo) {
            this.rollNo = rolNo;
        }

        public float getMarks() {
            return marks;
        }

        public void setMarks(float marks) {
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rollNo=" + rollNo +
                    ", marks=" + marks +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
