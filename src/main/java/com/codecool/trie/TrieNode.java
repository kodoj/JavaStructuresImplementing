package com.codecool.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

    private char data;
    private boolean isTerminating;
    List<TrieNode> children;
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        children = new ArrayList<>();
        childCount = 0;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public boolean isTerminating() {
        return isTerminating;
    }

    public void setTerminating(boolean terminating) {
        isTerminating = terminating;
    }
}
