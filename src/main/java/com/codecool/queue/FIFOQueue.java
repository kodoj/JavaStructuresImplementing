package com.codecool.queue;

public class FIFOQueue {

    private Node head;
    private Node tail;
    private int length;

    public void enqueue(String data) {
        if(length == 0) {
            head = new Node(data);
            tail = head;
            length++;
        } else {
            Node current = head;

            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
            current.next.previous = current;
            length++;
        }
    }


    public String dequeue() {
        String response = "";
        if(length == 0) {
            return response;
        } else if (length == 1){
            response = head.toString();
            head = null;
        } else {
            response = head.toString();
            head.next.previous = null;
            head = head.next;
            length--;
        }
        return response;
    }


    public String peek() {
        String response = "";
        if (length == 0) {
            return response;
        } else {
            response = head.toString();
        }
        return response;
    }


    public int queueSize() {
        return length;
    }

}
