package com.codecool.spellchecker;

import com.codecool.trie.AutoComplete;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App {

    HashTable hashTable;
    SpellChecker spellChecker;

    public static void main(String[] args) {
        App app = new App();
        String userInput = "hello hwo aae you";
        List<String> input = new ArrayList<>(Arrays.asList(userInput.split(" ")));
        System.out.println(app.prepareSuggestions(input));
    }


    public App() {
        hashTable = fillHashTable();
        spellChecker = new SpellChecker(hashTable);
    }


    public HashTable fillHashTable() {
        HashTable hashTable = new HashTable(40000);
        List<String> wordList = null;

        try {
            Path wordListPath = Paths.get(getClass().getClassLoader()
                    .getResource("wordlist.txt").toURI());
            wordList = Files.readAllLines(wordListPath);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < wordList.size(); i++) {
            hashTable.add(wordList.get(i));
        }

        return hashTable;
    }


    public Set<String> prepareSuggestions(List<String> input) {
        Set<String> result = new HashSet<>();
        result.addAll(spellChecker.deleteCharactersFromWord(input));
        result.addAll(spellChecker.iterateAlphabetToEveryCharacter(input));
        result.addAll(spellChecker.replacingEachCharacterInWordWithAlphabetCharacters(input));
        result.addAll(spellChecker.splitWordsAndCheckBothOfThem(input));
        result.addAll(spellChecker.swappingEachAdjacentPairOfCharacters(input));

        return result;
    }
}
