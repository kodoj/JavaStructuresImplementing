package com.codecool.linkedList;

public class MyLinkedList {
    Node head;
    Node last;
    int length;

    public void add(int data) {
        if(head == null) {
            head = new Node(data);
            last = head;
            length++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        last = current.next;
        length++;
    }


    public void remove(int data) {
        if(head == null) {
            return;
        }

        Node current = head;
        if (head.data == data) {
            if (current.next != null) {
                head = current.next;
                length--;
                return;
            } else {
                head = null;
                length = 0;
                return;
            }
        }

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                length--;
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
