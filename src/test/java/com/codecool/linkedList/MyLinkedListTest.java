package com.codecool.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {

    private MyLinkedList myLinkedList;

    @BeforeEach
    void prepare() {
        myLinkedList = new MyLinkedList();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
    }

    @Test
    void testAdd() {
        String result = "0 1 2 3 4";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void testRemoveFromMiddle() {
        String result = "0 1 2 4";
        myLinkedList.remove(3);
        assertEquals(result, myLinkedList.toString());
    }

}
