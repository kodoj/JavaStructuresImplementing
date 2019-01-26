package com.codecool.linkedList;

public class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
