package com.codecool.spellchecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable {

    String[] wordlist;
    int length;
    int currentWordsCounter = 0;
    HashFunction hashFunction;

    public HashTable(int length) {
        this.length = length;
        wordlist = new String[length];
        hashFunction = new HashFunction();
    }


    public void add(String word) {
        int index = hashFunction.hashString(length, word);
        boolean added = false;
        while(!added) {
            if (wordlist[index].equals("")) {
                wordlist[index] = word;
                currentWordsCounter++;
                added = true;
            } else {
                index++;
            }
        }
        hashTableMaintenance();
    }


    private void hashTableMaintenance() {
        if(moreThan80PercentOfLength()) {
            resizeArray();
        }
    }


    private boolean moreThan80PercentOfLength() {
        final int MAX_PERCENT_OF_OCCUPIED_BUCKETS = 80;
        if((currentWordsCounter / length) * 100 > MAX_PERCENT_OF_OCCUPIED_BUCKETS) {
            return true;
        }
        else {
            return false;
        }
    }


    private void resizeArray() {
        length = length + (length / 4);
        String[] newArray = new String[length];
        List<String> currentlyStoredWords = Arrays.asList(wordlist);
        hashFunction.putListOfStringsToHashTable(currentlyStoredWords, newArray);
        wordlist = newArray;
    }
}
