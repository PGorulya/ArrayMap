package org.example;

import com.github.javafaker.Faker;

import java.util.*;

// Performance test ArrayMap vs. LinkedHashMap

public class PerformanceTest {
    public static void main(String[] args) {
        int maxElements = 1000000;
        Faker faker = new Faker();
        Random rnd = new Random();
        // arrayMap is Map with Keys = "phone" and Values = "Person"
        ArrayMap<String, Person> arrayMap = new ArrayMap<>(maxElements);
        // HashMap is Map with Keys = "phone" and Values = "Person"
        HashMap<String,Person> hashMap = new HashMap<>(maxElements);

        //Create arrayMap elements with random dates
        int indexRnd = rnd.nextInt(0, maxElements);
        System.out.println("indexRnd = " + indexRnd);
        String phoneRnd = "";
        String phone;
        String lastname;
        int age;
        for (int i = 0; i < maxElements; i++) {
            phone = faker.phoneNumber().cellPhone();
            if (i == indexRnd) phoneRnd = phone;
            lastname = faker.name().lastName();
            age = rnd.nextInt(10, 90);
            // arrayMap is Map of Keys = "phone" and values = "Person"
            arrayMap.put(phone, (new Person(lastname, age)));

            // hashMap is Map of Keys = "phone" and values = "Person"
            hashMap.put(phone, (new Person(lastname, age)));
        }

        System.out.println("Size of arrayMap = " + arrayMap.size());
        System.out.println("Size of hashMap = " + hashMap.size());
        System.out.println("=========================================================");

        // Example1 for arrayMap:
        // Search the element with max Age and index of that element
        long start = System.currentTimeMillis();
        Person perMaxAge = arrayMap.get(phoneRnd);
        for (Person pers : arrayMap) {
            if (perMaxAge.getAge() <= pers.getAge()) {
                perMaxAge = pers;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time of searching for arrayMap = " + (end -start));
        System.out.println("Element with max Age (in arrayMap): " + perMaxAge);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("=========================================================");

        // Example1 for HashMap
        // Search the element with max Age and index of that element

        start = System.currentTimeMillis();
        Person perMaxAge1 = hashMap.get(phoneRnd);
        List<Person> listPers = new ArrayList<>(hashMap.values());
        for(Person person: listPers) {
            if ( perMaxAge1.getAge() <= person.getAge()) {
                perMaxAge1 = person;
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time of searching for hashMap = " + (end - start));
        System.out.println("Element with max Age (in hashMap): " + perMaxAge1);

    }
}
