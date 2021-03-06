package com.codecool.hashMap;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

    @Test
    void insertOneValueToHashMapAndCheckifItExists() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hey", "whats up");
        String expectedResult = "[hey: whats up], ";
        assertEquals(expectedResult, hashMap.toString());
    }

    @Test
    void hashedAShouldReturn1() {
        HashMap<String, String> hashMap = new HashMap<>();
        int expectedResult = 1;
        assertEquals(expectedResult, hashMap.getHashCode("A"));
    }

    @Test
    void indexFromHashed1ShouldReturn0() {
        HashMap<String, String> hashMap = new HashMap<>();
        int expectedResult = 0;
        assertEquals(expectedResult, hashMap.convertHashToIndex(1));
    }

    @Test
    void getPreviouslyInsertedElement() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hey", "whats up");
        String expectedResult = "whats up";
        assertEquals(expectedResult, hashMap.get("hey"));
    }

    @Test
    void updatePreviouslyInsertedElement() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hey", "whats up");
        hashMap.update("hey", "what's up man?");
        String expectedResult = "what's up man?";
        assertEquals(expectedResult, hashMap.get("hey"));
    }

    @Test
    void deletePreviouslyInsertedElement() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hey", "whats up");
        hashMap.delete("hey");
        assertNull(hashMap.get("hey"));
    }

    @Test
    void iterateOverHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hey", "whats up");
        hashMap.put("halo", "wut?");
        hashMap.put("Kris", "Kris here");
        String expectedResult = "whats up, wut?, Kris here, ";
        LinkedList<String> hashMapValues = hashMap.values();
        String output = "";
        for (String value : hashMapValues) {
            output += value + ", ";
        }
        assertEquals(expectedResult, output);
    }
}
