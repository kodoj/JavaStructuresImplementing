package com.codecool.linkedList;

public class MyLinkedList {
    Node head;

    public void add(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public String toString() {
        String result = "";
        if(head == null) {
            return result;
        }

        Node current = head;
        result += current;
        while (current.next != null) {
            current = current.next;
            result += (" " + current);
        }
        return result;
    }

}
