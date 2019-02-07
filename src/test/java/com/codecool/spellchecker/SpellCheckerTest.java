package com.codecool.spellchecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> expectedResultList = new HashSet<>();
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
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("assertion");
        expectedResultList.add("mentor");
        assertEquals(expectedResultList, spellChecker.swappingEachAdjacentPairOfCharacters(input));
    }

    @Test
    void iteratingOverAlphabetReturnsOneSugestion() {
        List<String> input = new ArrayList<>();
        input.add("assertin");
        when(hashTable.exist("assertion")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
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
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("assertion");
        expectedResultList.add("mentor");
        assertEquals(expectedResultList, spellChecker.iterateAlphabetToEveryCharacter(input));
    }

    @Test
    void deletingCharactersReturnsOneSugestion() {
        List<String> input = new ArrayList<>();
        input.add("assertiion");
        when(hashTable.exist("assertion")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("assertion");
        assertEquals(expectedResultList, spellChecker.deleteCharactersFromWord(input));
    }

    @Test
    void deletingCharactersReturnsFewSuggestions() {
        List<String> input = new ArrayList<>();
        input.add("assertionn");
        input.add("mmentor");
        when(hashTable.exist("mentor")).thenReturn(true);
        when(hashTable.exist("assertion")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("assertion");
        expectedResultList.add("mentor");
        assertEquals(expectedResultList, spellChecker.deleteCharactersFromWord(input));
    }
}
