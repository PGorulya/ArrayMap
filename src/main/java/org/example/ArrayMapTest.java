package org.example;

import com.github.javafaker.Faker;

import java.util.Random;

public class ArrayMapTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rnd = new Random();
        ArrayMap<Person,String> arrayMap = new ArrayMap<>();


        for (int i = 0; i < 20; i++) {
            String phone = faker.phoneNumber().cellPhone();
            arrayMap.add((new Person(phone, faker.name().lastName(), rnd.nextInt(15, 80))),phone);
        }

        Person perMaxAge = arrayMap.get(0);
        for(Person per: arrayMap) {
            if (perMaxAge.getAge() <= per.getAge()) perMaxAge = per;
        }

        System.out.println("Element with max Age: " + perMaxAge);
        System.out.println("Index of this element: " + arrayMap.indexKey(perMaxAge.getPhoneNumber()));

        System.out.println(arrayMap);

    }
}

