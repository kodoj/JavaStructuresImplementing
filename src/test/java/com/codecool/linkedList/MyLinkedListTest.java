package com.codecool.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {

    private MyLinkedListTest myLinkedListTest;

    @BeforeEach
    void prepare() {
        myLinkedListTest = new MyLinkedListTest();
        myLinkedListTest.add(0);
        myLinkedListTest.add(1);
        myLinkedListTest.add(2);
        myLinkedListTest.add(3);
        myLinkedListTest.add(4);
    }

    @Test
    void testAdd() {
        String result = "0 1 2 3 4";
        assertEquals(result, myLinkedListTest.toString());
    }

}
