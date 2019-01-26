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


    public void remove(int data) {
        if(head == null) {
            return;
        }

        Node current = head;
        if (head.data == data) {
            if (current.next != null) {
                head = current.next;
                return;
            } else {
                head = null;
                return;
            }
        }

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
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
