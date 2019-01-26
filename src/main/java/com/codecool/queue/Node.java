package com.codecool.queue;

public class Node {
    Node next;
    Node previous;
    String data;

    public Node(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}
