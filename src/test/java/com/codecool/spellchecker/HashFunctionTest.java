package com.codecool.spellchecker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashFunctionTest {


    @Test
    void return7forALetterWithArraySize30() {
        HashFunction hashFunction = new HashFunction();
        String word = "a";
        int expectedResult = 7;
        assertEquals(expectedResult, hashFunction.hashString(30, word));
    }

    @Test
    void putStringsToExpectedIndexInArray() {
        HashFunction hashFunction = new HashFunction();
        String word = "a";
        String word2 = "b";
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add(word);
        listOfStrings.add(word2);
        String[] array = new String[30];
        hashFunction.putListOfStringsToHashTable(listOfStrings, array);

        assertEquals(word2, array[8]);
    }
}
