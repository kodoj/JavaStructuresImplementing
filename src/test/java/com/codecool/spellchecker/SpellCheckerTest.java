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
    void swappingReturnsOneSuggestion() {
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
    void iteratingOverAlphabetReturnsOneSuggestion() {
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
    void deletingCharactersReturnsOneSuggestion() {
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

    @Test
    void swapCharactersWithAlphabetCharactersReturnsOneSuggestion() {
        List<String> input = new ArrayList<>();
        input.add("asseltion");
        when(hashTable.exist("assertion")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("assertion");
        assertEquals(expectedResultList, spellChecker.replacingEachCharacterInWordWithAlphabetCharacters(input));
    }

    @Test
    void swapCharactersWithAlphabetCharactersReturnsFewSuggestions() {
        List<String> input = new ArrayList<>();
        input.add("zssertion");
        input.add("mentop");
        when(hashTable.exist("mentor")).thenReturn(true);
        when(hashTable.exist("assertion")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("assertion");
        expectedResultList.add("mentor");
        assertEquals(expectedResultList, spellChecker.replacingEachCharacterInWordWithAlphabetCharacters(input));
    }

    @Test
    void splitWordsReturnsTwoSuggestions() {
        List<String> input = new ArrayList<>();
        input.add("hellothere");
        when(hashTable.exist("hello")).thenReturn(true);
        when(hashTable.exist("there")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("hello");
        expectedResultList.add("there");
        assertEquals(expectedResultList, spellChecker.splitWordsAndCheckBothOfThem(input));
    }

    @Test
    void splitWordsReturnsFewSuggestions() {
        List<String> input = new ArrayList<>();
        input.add("Whatsup");
        input.add("howdo");
        when(hashTable.exist("Whats")).thenReturn(true);
        when(hashTable.exist("up")).thenReturn(true);
        when(hashTable.exist("how")).thenReturn(true);
        when(hashTable.exist("do")).thenReturn(true);
        Set<String> expectedResultList = new HashSet<>();
        expectedResultList.add("Whats");
        expectedResultList.add("up");
        expectedResultList.add("how");
        expectedResultList.add("do");
        assertEquals(expectedResultList, spellChecker.splitWordsAndCheckBothOfThem(input));
    }
}
