package com.codecool.spellchecker;

import java.util.ArrayList;
import java.util.List;

public class SpellChecker {

    HashTable hashTable;

    public SpellChecker(HashTable hashTable) {
        this.hashTable = hashTable;
    }


    public List<String> swappingEachAdjacentPairOfCharacters(List<String> input) {
        List<String> result = new ArrayList<>();
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

                if(hashTable.exist(sb.toString())) {
                    result.add(sb.toString());
                }

                sb.setLength(0);
            }
        }
        return result;
    }



}
