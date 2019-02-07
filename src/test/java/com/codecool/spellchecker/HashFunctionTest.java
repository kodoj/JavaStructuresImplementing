package com.codecool.spellchecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashFunctionTest {


    @Test
    void return7forALetterWithArraySize30() {
        HashFunction hashFunction = new HashFunction();
        String word = "a";
        int expectedResult = 7;
        assertEquals(expectedResult, hashFunction.hashString(30, word));
    }
}
