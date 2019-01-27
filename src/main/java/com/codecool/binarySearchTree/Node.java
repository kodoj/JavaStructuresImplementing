package com.codecool.binarySearchTree;

public class Node {
    Node left, right, parent;
    int value;
    int count;

    public Node(int value) {
        this.value = value;
    }


    public void insertion(int data) {
        if(value == data) {
            this.count++;
        } else if (data < value) {
            if (left == null) {
                left = new Node(data);
                left.parent = this;
            } else {
                left.insertion(data);
            }
        } else {
            if (right == null) {
                right = new Node(data);
                right.parent = this;
            } else {
                right.insertion(data);
            }
        }
    }


    public static boolean searchRecursive(Node current, int data) {
        if(current.value == data) {
            return true;
        } else if (current.value > data) {
            if (current.left == null) {
                return false;
            } else {
                return searchRecursive(current.left, data);
            }
        } else {
            if (current.right == null) {
                return false;
            } else {
                return searchRecursive(current.right, data);
            }
        }
    }
}
