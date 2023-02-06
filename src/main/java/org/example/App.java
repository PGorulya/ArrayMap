package org.example;

import com.github.javafaker.Faker;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rnd = new Random();
        // arrayMap is array of objects "Person" with Key is "phone"
        ArrayMap<Person, String> arrayMap = new ArrayMap<>();

        //Create arrayMap elements with random dates
        int maxElements = 10;
        int indexRnd = rnd.nextInt(0, maxElements);
        System.out.println("indexRnd = " + indexRnd);
        String phoneRnd = "";
        String phone;
        for (int i = 0; i < maxElements; i++) {
            phone = faker.phoneNumber().cellPhone();
            if (i == indexRnd) phoneRnd = phone;
            // arrayMap is array of objects "Person" with Key is "phone"
            arrayMap.add((new Person(faker.name().lastName(), phone, rnd.nextInt(15, 80))), phone);
        }

        System.out.println("Size of arrayMap = " + arrayMap.size());

        //Test of contains the elements with given key = phoneRnd
        if (arrayMap.contains(phoneRnd)) {
            System.out.println("Element with phone: " + phoneRnd + " exist in the array");
            System.out.println("Index of element with phone: " + phoneRnd + " is: " + arrayMap.findIndex(phoneRnd));
        } else System.out.println("Element with phone: " + phoneRnd + " is not contains in arrayMap");

        // remove element with key = phoneRnd
        System.out.println("Remove element with phone: " + phoneRnd);
        int idx = arrayMap.findIndex(phoneRnd);
        arrayMap.remove(idx,phoneRnd);
        System.out.println("Size after removing = " + arrayMap.size());

        // Example of Using foreach cycle
        // Search elements of arrayMap with max Age
        Person perMaxAge = arrayMap.get(0);
        for (Person pers : arrayMap) {
            if (perMaxAge.getAge() <= pers.getAge()) perMaxAge = pers;
        }
        System.out.println("Element with max Age: " + perMaxAge);
        System.out.println("Index of this element: " + arrayMap.findIndex(perMaxAge.getPhoneNumber()));

        System.out.println("=========================================================");
        System.out.println(arrayMap);


    }
}

