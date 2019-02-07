package com.codecool.spellchecker;

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
            hashValue = (hashValue * MULTIPLICANT + asciiValue) % arraySize;
        }

        return hashValue;
    }
}
