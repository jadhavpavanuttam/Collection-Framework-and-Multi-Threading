import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

import java.util.*;

class Student {
    int rollNo;
    String name;

    public int getRollNo() {
        return rollNo;
    }

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "rollNo=" + rollNo +
//                ", name='" + name + '\'' +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name);
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void printStudent() {
        System.out.println("This is Student Of the Class : " + "Mca First Year .....");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException, NullPointerException, Exception {

        List<Student> list = Arrays.asList(
                new Student(1, "jagruti"),
                new Student(2, "pavan"),
                new Student(5, "vaishnavi"),
                new Student(4, "rushikesh"),
                new Student(3, "amol")
        );

        Class<?> aClass = Class.forName("Student");
        System.out.println("The Class Name  is : " + aClass.getName());
        Field[] field = aClass.getDeclaredFields();
        for (Field f : field) System.out.println(f);

        Method[] methods = aClass.getDeclaredMethods();
        for (Method me : methods) System.out.println(me);
        boolean student = aClass.getDeclaredConstructor().isAccessible();
        System.out.println("New Object is  Accessible Or Not ?  " + student);
        Constructor constructor = aClass.getDeclaredConstructor();
        System.out.println("The Name Of Constructor is : " + constructor.getName());
//        int i = 0;
//        for (Field fields : aClass.getDeclaredFields()) {
//            System.out.println((i++) + " : " + fields.getName().toUpperCase());


        list
                .stream()
                .filter(x -> x.equals(list.getFirst()))
                .toList()
                .forEach(s -> System.out.println(s.toString()));

}

}