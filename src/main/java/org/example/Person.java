package org.example;

import java.util.UUID;

public class Person {
    private String phoneNumber;
    private String name;
    private int age;

    public Person(String phoneNumber, String name, int age) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
