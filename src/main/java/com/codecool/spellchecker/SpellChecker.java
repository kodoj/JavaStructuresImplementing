package com.codecool.spellchecker;

import java.util.ArrayList;
import java.util.List;

public class SpellChecker {

    HashTable hashTable;

    public SpellChecker(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public List<String> swappingEachAdjacentPairOfCharacters(List<String> input) {
        int listLength = input.size();
        char firstCharacter;
        char secondCharacter;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String tempString;
        boolean wordIsDone;

        for (int i = 0; i < listLength; i++) {
            tempString = input.get(i);
            wordIsDone = false;

            while(!wordIsDone) {

            }
        }
    }
}
