package com.codecool.spellchecker;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    List<String>[] wordlist;
    int length;
    int currentWordsCounter = 0;
    HashFunction hashFunction;

    public HashTable(int length) {
        this.length = length;
        wordlist = (ArrayList<String>[]) new ArrayList[length];
        hashFunction = new HashFunction();
    }


    public void add(String word) {
        int index = hashFunction.hashString(length, word);
        if(wordlist[index] == null) {
            wordlist[index] = new ArrayList<>();
            wordlist[index].add(word);
        } else {
            wordlist[index].add(word);
        }
        currentWordsCounter++;
        hashTableMaintenance();
    }

    private void add(String word, List<String>[] array) {
        int index = hashFunction.hashString(array.length, word);
        if(array[index] == null) {
            array[index] = new ArrayList<>();
            array[index].add(word);
        } else {
            array[index].add(word);
        }
        currentWordsCounter++;
        hashTableMaintenance();
    }


    public boolean exist(String word) {
        int index = hashFunction.hashString(length, word);
        boolean expectedString = false;
        List<String> currentList = wordlist[index];

        if(currentList != null) {
            for (int i = 0; i < currentList.size(); i++) {
                if(currentList.get(i).equals(word)) {
                    expectedString = true;
                    break;
                }
            }
        }

        return expectedString;
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
        List<String>[] newArray = (ArrayList<String>[]) new ArrayList[length];
        List<String> allCurrentWords = new ArrayList<>();

        for (List<String> list : wordlist) {
            if(list.size() != 0) {
                allCurrentWords.addAll(list);
            }
        }
        putListOfStringsToHashTable(allCurrentWords, newArray);
        wordlist = newArray;
    }


    public void putListOfStringsToHashTable(List<String> listOfAllWords, List<String>[] array) {
        for (int i = 0; i < listOfAllWords.size(); i++) {
            add(listOfAllWords.get(i), array);
        }
    }
}
