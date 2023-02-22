package org.example;

import com.github.javafaker.Faker;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;


// Examples of some ArrayMap methods
public class App {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rnd = new Random();
        // arrayMap is array of objects "Person" with Key is "phone"
        ArrayMap<String, Person> arrayMap = new ArrayMap<>();

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
            arrayMap.put(phone, (new Person(faker.name().lastName(), rnd.nextInt(15, 80))));
        }

        System.out.println("Size of arrayMap = " + arrayMap.size());
        System.out.println(arrayMap);

        //Test of contains the elements with given key = phoneRnd
        if (arrayMap.containsKey(phoneRnd)) {
            System.out.println("Element with phone: " + phoneRnd + " exist in the array");
            System.out.println("Index of element with phone: " + phoneRnd + " is: " + arrayMap.getIndex(phoneRnd));
        } else System.out.println("Element with phone: " + phoneRnd + " is not contains in arrayMap");

        // remove element with key = phoneRnd
        System.out.println("Remove element with phone: " + phoneRnd);
//        int idx = arrayMap.getIndex(phoneRnd);
        arrayMap.remove(phoneRnd);
        System.out.println("Size after removing = " + arrayMap.size());

        // Example of Using "for-each" cycle
        // Search the element of arrayMap with max Age
        Person perMaxAge = arrayMap.get(0);
        for (Person pers : arrayMap) {
            if (perMaxAge.getAge() <= pers.getAge()) perMaxAge = pers;
        }
        System.out.println("Element with max Age: " + perMaxAge);

        // Example use to_string
        System.out.println("=========================================================");
        System.out.println(arrayMap);

        //Example use forEachRemaining
        System.out.println("Example ForEachRemainding+++++++++++++++++++++++++++");
        arrayMap.iterator().forEachRemaining(System.out::println);

        //Example use for stream
        System.out.println("Example Stream++++++++++++++++++++++++++++");
        arrayMap.values().stream().filter(a->a.getAge()>50).forEach(System.out::println);
        System.out.println("----------------------------------");
        arrayMap.entrySet().stream().filter(a->a.getValue().getAge()>50).forEach(System.out::println);

    }
}

