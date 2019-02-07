package com.codecool.spellchecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class SpellCheckerTest {

    private SpellChecker spellChecker;

    @Mock
    private HashTable hashTable;

    @BeforeEach
    void prepare() {
        MockitoAnnotations.initMocks(this);
        spellChecker = new SpellChecker(hashTable);
    }


    @Test
    void swappingReturnsOneSugestion() {
        List<String> input = new ArrayList<>();
        input.add("assetrion");
        when(hashTable.exist("assertion")).thenReturn(true);
        List<String> expectedResultList = new ArrayList<>();
        expectedResultList.add("assertion");
        assertEquals(expectedResultList, spellChecker.swappingEachAdjacentPairOfCharacters(input));
    }

    @Test
    void swappingReturnsFewSuggestionsOutOfManyPossibilities() {
        List<String> input = new ArrayList<>();
        input.add("assetrion");
        input.add("emntor");
        when(hashTable.exist("mentor")).thenReturn(true);
        when(hashTable.exist("emtnor")).thenReturn(false);
        when(hashTable.exist("assetiron")).thenReturn(false);
        when(hashTable.exist("assertion")).thenReturn(true);
        List<String> expectedResultList = new ArrayList<>();
        expectedResultList.add("assertion");
        expectedResultList.add("mentor");
        assertEquals(expectedResultList, spellChecker.swappingEachAdjacentPairOfCharacters(input));
    }

    @Test
    void iteratingOverAlphabetReturnsOneSugestion() {
        List<String> input = new ArrayList<>();
        input.add("assertin");
        when(hashTable.exist("assertion")).thenReturn(true);
        List<String> expectedResultList = new ArrayList<>();
        expectedResultList.add("assertion");
        assertEquals(expectedResultList, spellChecker.iterateAlphabetToEveryCharacter(input));
    }

    @Test
    void iteratingOverAlphabetReturnsFewSuggestions() {
        List<String> input = new ArrayList<>();
        input.add("assrtion");
        input.add("entor");
        when(hashTable.exist("mentor")).thenReturn(true);
        when(hashTable.exist("assertion")).thenReturn(true);
        List<String> expectedResultList = new ArrayList<>();
        expectedResultList.add("assertion");
        expectedResultList.add("mentor");
        assertEquals(expectedResultList, spellChecker.iterateAlphabetToEveryCharacter(input));
    }
}
