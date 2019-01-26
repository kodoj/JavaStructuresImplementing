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

    @Test
    void testRemoveFromHead() {
        String result = "1 2 3 4";
        myLinkedList.remove(0);
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void removeLastElement() {
        String result = "0 1 2 3";
        myLinkedList.remove(4);
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void lastWorks() {
        String result = "4";
        assertEquals(result, myLinkedList.last.toString());
    }

    @Test
    void lengthWorks() {
        int result = 5;
        assertEquals(result, myLinkedList.length);
    }

    @Test
    void lastWorksAfterDeletingLastElement() {
        String result = "3";
        myLinkedList.remove(4);
        Node lastNode = myLinkedList.last;
        assertEquals(result, lastNode.toString());
    }

}
