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
        char temp;
        TrieNode current = root;

        for (int i = 0; i < length; i++) {
            temp = wordToAdd.charAt(i);
            if(containsLetter(current.children, temp)) {
                for (int j = 0; j < current.childCount; j++) {
                    if(current.children.get(j).getData() == temp) {
                        current = current.children.get(j);
                        break;
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
        char temp;
        TrieNode currentNode = root;

        for (int i = 0; i < baseChars.length(); i++) {
            temp = baseChars.charAt(i);
            if(containsLetter(currentNode.children, temp)) {
                for (int j = 0; j < currentNode.childCount; j++) {
                    if(currentNode.children.get(j).getData() == temp) {
                        currentNode = currentNode.children.get(j);
                        break;
                    }
                }
            } else {
                return words;
            }
        }
        if(currentNode.isTerminating()) {
            words.add(baseChars);
        }
        recurrentWordSeeker(currentNode, baseChars, words);


        return words;
    }

    private void recurrentWordSeeker(TrieNode currentNode, String currentWord, List<String> words) {
        int length = currentNode.children.size();
        String wordWithNextLetter;
        for (int i = 0; i < length; i++) {
            wordWithNextLetter = currentWord + currentNode.children.get(i).getData();
            if(currentNode.children.get(i).isTerminating()) {
                words.add(wordWithNextLetter);
            }
            recurrentWordSeeker(currentNode.children.get(i), wordWithNextLetter, words);
        }
    }


    public boolean removeWord(String wordToRemove) {

        return false;
    }


    private boolean containsLetter(final List<TrieNode> list, final char letter) {
        return list.stream().anyMatch(o -> o.getData() == letter);
    }
}
