package com.codecool.spellchecker;

import java.util.HashMap;
import java.util.List;

public class HashFunction {


    public int hashString(int arraySize, String word) {
        final int MULTIPLICANT = 27;
        int hashValue = 0;
        int asciiValue;
        int wordLength = word.length();
        char tempChar;

        for (int i = 0; i < wordLength; i++) {
            tempChar = word.charAt(i);
            asciiValue = 1 + tempChar - 1;
            hashValue += (hashValue * MULTIPLICANT + asciiValue) % arraySize;
        }

        return hashValue;
    }


    public void putListOfStringsToHashTable(List<String> wordList, String[] array) {
        int index;
        int arrayLength = array.length;
        String currentWord;
        for (int i = 0; i < wordList.size(); i++) {
            currentWord = wordList.get(i);
            index = hashString(arrayLength, currentWord);
            array[index] = currentWord;
        }
    }
}
