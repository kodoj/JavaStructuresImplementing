package com.codecool.binarySearchTree;

public class BinarySearchTree {
    private Node root;


    public BinarySearchTree(int value) {
        root = new Node(value);
    }


    public void insert(int value) {

    }


    public boolean contains(int value) {
        Node current = root;
        if(current.value == value) {
            return true;
        }
        else return false;
    }
}
