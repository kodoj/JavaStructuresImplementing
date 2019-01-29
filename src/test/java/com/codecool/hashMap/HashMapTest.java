package com.codecool.hashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

    @Test
    void insertOneValueToHashMapAndCheckifItExists() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hey", "whats up");
        String expectedResult = "[hey: whats up]";
        assertEquals(expectedResult, hashMap.toString());
    }

    @Test
    void hashedAShouldReturn1() {
        HashMap<String, String> hashMap = new HashMap<>();
        int expectedResult = 1;
        assertEquals(expectedResult, hashMap.getHashCode("A"));
    }
}
