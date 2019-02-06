package com.codecool.trie;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {

    TrieNode root;


    public AutoComplete() {
        root = new TrieNode('*');
    }

    public void addWord(String wordToAdd) {
        int length = wordToAdd.length();
        TrieNode current = root;

        for (int i = 0; i < length; i++) {
            char temp = wordToAdd.charAt(i);
            if(containsLetter(current.children, temp)) {
                for (int j = 0; j < current.childCount; j++) {
                    if(current.children.get(i).getData() == temp) {
                        current = current.children.get(i);
                    }
                }
            } else {
                TrieNode newNode = new TrieNode(temp);
                current.children.add(newNode);
                current.childCount++;
                current = newNode;
            }
            int iteration = i + 1;
            if(iteration == length) {
                current.setTerminating(true);
            }
        }
    }


    public List<String> autoComplete(String baseChars) {
        List<String> words = new ArrayList<>();

        return words;
    }


    public boolean removeWord(String wordToRemove) {

        return false;
    }


    private boolean containsLetter(final List<TrieNode> list, final char letter) {
        return list.stream().anyMatch(o -> o.getData() == letter);
    }
}
