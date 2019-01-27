package com.codecool.binarySearchTree;

import static com.codecool.binarySearchTree.Node.searchRecursive;

public class BinarySearchTree {
    private Node root;


    public BinarySearchTree(int value) {
        root = new Node(value);
    }


    public void insert(int value) {
        if(value == root.value) {
            root.count++;
        } else if (value < root.value) {
            if (root.left == null) {
                root.left = new Node(value);
                root.left.parent = root;
            } else {
                root.left.insertion(value);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(value);
                root.right.parent = root;
            } else {
                root.right.insertion(value);
            }
        }
    }


    public void remove(int value) {
        if (root.value == value) {
            root = null;
        } else {
            root.deleteRecursive(root, value);  // static or by object? both doesn't look well
        }

    }


    public boolean contains(int value) {
        return searchRecursive(root, value);
    }
}
