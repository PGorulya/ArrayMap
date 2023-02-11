package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ArrayMapTest {

    ArrayMap<String, Person> arrayMap = new ArrayMap<>();

    Person person1 = new Person("Hemmer",  32);
    Person person2 = new Person("Neitzel",  47);
    Person person3 = new Person("Schwarz", 25);

    @BeforeEach
    void setUp() {
        arrayMap.put("4917732567", person1 );
        arrayMap.put("4915756322", person2);
        arrayMap.put("4917702870", person3 );

    }

    @AfterEach
    void tearDown() {
        arrayMap.clear();
    }

    void put() {
        arrayMap.put("4915502546", new Person("Brown", 28));
        Assertions.assertEquals(4,arrayMap.size(),"Check Add");
    }

    @Test
    void putIfKeyExist() {
        arrayMap.put("4917732567", new Person("Brown", 28));
        Assertions.assertEquals(3,arrayMap.size(),"Check Add If key exist");
    }

    @Test
    void getByIndex() {
        Assertions.assertEquals(person1, arrayMap.get(0));
        Assertions.assertEquals(person3, arrayMap.get(2));
   }

    @Test
    void getByKey() {
        Assertions.assertEquals(person1, arrayMap.get("4917732567"));
        Assertions.assertEquals(person3, arrayMap.get("4917702870"));
    }

    @Test
    void getException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMap.get(-1), "Get element with Exception");
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMap.get(3), "Get element with Exception");
    }

    @Test
    void set() {
        arrayMap.set(1,new Person("Schulze", 30),"4915502525", "4915756322");
        Assertions.assertFalse(arrayMap.contains("4915756322"));
        Assertions.assertTrue(arrayMap.contains("4915502525"));
    }

    @Test
    void setException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMap.set(-1, person3, "000000", "11111111"));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMap.set(99, person3, "000000", "11111111"));
    }

    @Test
    void contains() {
        Assertions.assertTrue(arrayMap.contains("4915756322"));
        Assertions.assertFalse(arrayMap.contains("4915756323"));

    }

    @Test
    void findIndex() {
        Assertions.assertEquals(1,arrayMap.findIndex("4915756322"));
        Assertions.assertEquals(-1,arrayMap.findIndex("4915756323"));
    }

    @Test
    void size() {
        Assertions.assertEquals(3, arrayMap.size(), "Check size");
    }

    @Test
    void removeByIndex() {
        arrayMap.remove("4917702870", 2);
        Assertions.assertEquals(2, arrayMap.size(), "Check remove");
        Assertions.assertFalse(arrayMap.contains("4917702870"));
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(false);
    }

}