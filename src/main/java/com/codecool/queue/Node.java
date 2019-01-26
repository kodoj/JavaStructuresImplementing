package com.codecool.queue;

public class Node {
    Node next;
    Node previous;
    String data;
    int priority;

    public Node(String data) {
        this.data = data;
        priority = 1;
    }

    public Node(String data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public String toString() {
        return data;
    }
}
