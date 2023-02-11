package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

// Performance test ArrayMap vs. LinkedHashMap

public class PerformanceTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rnd = new Random();
        // arrayMap is Map with Keys = "phone" and Values = "Person"
        ArrayMap<String, Person> arrayMap = new ArrayMap<>();
        // LinkedHashMap is Map with Keys = "phone" and Values = "Person"
        LinkedHashMap<String,Person> linkedHashMap = new LinkedHashMap<>();

        //Create arrayMap elements with random dates
        int maxElements = 100000;
        int indexRnd = rnd.nextInt(0, maxElements);
        System.out.println("indexRnd = " + indexRnd);
        String phoneRnd = "";
        String phone;
        for (int i = 0; i < maxElements; i++) {
            phone = faker.phoneNumber().cellPhone();
            if (i == indexRnd) phoneRnd = phone;
            // arrayMap is Map of Keys = "phone" and values = "Person"
            arrayMap.put(phone, (new Person(faker.name().lastName(), rnd.nextInt(15, 80))));

            // linkedHashMap is Map of Keys = "phone" and values = "Person"
            linkedHashMap.put(phone, (new Person(faker.name().lastName(), rnd.nextInt(15, 80))));
        }

        System.out.println("Size of arrayMap = " + arrayMap.size());
        System.out.println("=========================================================");

        // Example1 for arrayMap:
        // Search the element with max Age and index of that element
        long start = System.currentTimeMillis();
        Person perMaxAge = arrayMap.get(phoneRnd);
        for (Person pers : arrayMap) {
            if (perMaxAge.getAge() <= pers.getAge()) perMaxAge = pers;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time of searching for arrayMap = " + (end -start));
        System.out.println("Element with max Age (in arrayMap): " + perMaxAge);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("=========================================================");
        System.out.println("Size of linkedHashMap = " + linkedHashMap.size());

        // Example1 for LinkedHashMap
        // Search the element with max Age and index of that element
        start = System.currentTimeMillis();
        Person perMaxAge1 = linkedHashMap.get(phoneRnd);
        List<String> listPhones = new ArrayList<>(linkedHashMap.keySet());
        for(String phon: listPhones) {
            if( perMaxAge1.getAge() <= linkedHashMap.get(phon).getAge()) {
                perMaxAge1 = linkedHashMap.get(phon);
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time of searching for linkedHashMap = " + (end - start));
        System.out.println("Element with max Age (in linkedHashMap): " + perMaxAge1);

    }
}
