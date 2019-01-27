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


    public void deleteRecursive(Node current, int data) {
        if(current.value == data) {
            if (current.count > 1) {
                current.count--;
            } else {
                if (current.left == null && current.right == null) {
                    if(current.parent.left.equals(current)) {
                        current.parent.left = null;
                    } else {
                        current.parent.right = null;
                    }
                } else {
                    if (current.parent.left.equals(current)) {
                        if(current.right != null) {
                            current.parent.left = current.right;
                            current.right.parent = current.parent;
                        } else {
                            current.parent.left = current.left;
                            current.left.parent = current.parent;
                        }
                    } else {
                        if(current.left != null) {
                            current.parent.right = current.left;
                            current.left.parent = current.parent;
                        } else {
                            current.parent.right = current.right;
                            current.right.parent = current.parent;
                        }
                    }
                }
            }
        } else if (current.value > data) {
                deleteRecursive(current.left, data);
        } else {
                deleteRecursive(current.right, data);
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
