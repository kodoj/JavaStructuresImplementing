package com.codecool.spellchecker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashTableTest {

    @Test
    void putStringsToExpectedIndexInArray() {
        HashTable hashTable = new HashTable(30);
        String word = "a";
        String word2 = "b";
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add(word);
        listOfStrings.add(word2);
        List<String>[] array = (ArrayList<String>[]) new ArrayList[30];
        hashTable.putListOfStringsToHashTable(listOfStrings, array);

        assertEquals(word2, array[8].get(0));
    }
}
