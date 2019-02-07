package com.codecool.spellchecker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellChecker {

    HashTable hashTable;

    public SpellChecker(HashTable hashTable) {
        this.hashTable = hashTable;
    }


    public Set<String> swappingEachAdjacentPairOfCharacters(List<String> input) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int currentWordLength;


        for (String currentWord : input) {
            currentWordLength = currentWord.length();

            if (currentWordLength < 2) {
                continue;
            }

            for (int i = 0; i < currentWordLength - 1; i++) {
                sb.append(currentWord);
                sb.setCharAt(i+1, currentWord.charAt(i));
                sb.setCharAt(i, currentWord.charAt(i+1));

                existCheck(result, sb);

                sb.setLength(0);
            }
        }
        return result;
    }


    public Set<String> iterateAlphabetToEveryCharacter(List<String> input) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String currentWord : input) {

            for (int i = 0; i < currentWord.length(); i++) {

                attachAlphabetCharactersToWord(result, sb, currentWord, i);

                if (i+1 == currentWord.length()) {
                    attachAlphabetCharactersToWord(result, sb, currentWord, i + 1);
                }
            }
        }
        return result;
    }

    private void attachAlphabetCharactersToWord(Set<String> result, StringBuilder sb, String currentWord, int i) {
        for (int j = 97; j <= 122; j++) {
            sb.append(currentWord, 0, i);
            sb.append((char)j);
            sb.append(currentWord, i, currentWord.length());

            existCheck(result, sb);

            sb.setLength(0);
        }
    }


    public Set<String> deleteCharactersFromWord(List<String> input) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String currentWord : input) {

            for (int i = 0; i < currentWord.length(); i++) {

                sb.append(currentWord);
                sb.deleteCharAt(i);

                existCheck(result, sb);

                sb.setLength(0);
            }
        }
        return result;
    }


    private void existCheck(Set<String> result, StringBuilder sb) {
        if (hashTable.exist(sb.toString())) {
            result.add(sb.toString());
        }
    }
}
