package com.codecool.queue;

public class FIFOQueue {

    private Node head;
    private Node tail;
    private int length;
    private final int DEFAULT_PRIORITY = 1;


    public void enqueue(String data, int priority) {
        if(isEmpty()) {
            head = new Node(data, priority);
            tail = head;
            length++;
        } else {
            Node current = head;

            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(data, priority);
            current.next.previous = current;
            length++;
        }
    }


    public void enqueue(String data) {
        enqueue(data, DEFAULT_PRIORITY);
    }


    public String dequeue() {
        String response = "";

        if(isEmpty()) {
            return response;
        } else if (length == 1){
            response = head.toString();
            head = null;
        } else {
            Node current = head;
            Node highestPriorityNode = current;
            int currentPriority = current.priority;

            for (int i = 1; i < length; i++) {
                current = current.next;
                if(current.priority > currentPriority) {
                    highestPriorityNode = current;
                    currentPriority = current.priority;
                }
            }

            response = highestPriorityNode.toString();
            if(highestPriorityNode.previous != null) {
                highestPriorityNode.previous.next = highestPriorityNode.next;
            }
            if(highestPriorityNode.next != null) {
                highestPriorityNode.next.previous = highestPriorityNode.previous;
            }
            length--;
        }
        return response;
    }


    public String peek() {
        String response = "";
        if (isEmpty()) {
            return response;
        } else {
            response = head.toString();
        }
        return response;
    }


    public int queueSize() {
        return length;
    }


    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

}
