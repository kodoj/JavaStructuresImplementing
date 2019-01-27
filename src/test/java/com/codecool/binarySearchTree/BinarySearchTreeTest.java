package com.codecool.binarySearchTree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    void notNullBinarySearchTreeWithOneValueAsRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        assertNotNull(binarySearchTree);
    }

    @Test
    void checkIfBinaryTreeContainsRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        assertTrue(binarySearchTree.contains(10));
    }

    @Test
    void insertOneValueAndTrueIfBSTContainsIt() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        binarySearchTree.insert(8);
        assertTrue(binarySearchTree.contains(8));
    }
}
