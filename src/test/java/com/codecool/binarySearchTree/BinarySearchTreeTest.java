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

    @Test
    void insertFewValuesAndChecksIfLastExists() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);
        binarySearchTree.insert(20);
        binarySearchTree.insert(18);
        binarySearchTree.insert(1);
        assertTrue(binarySearchTree.contains(1));
    }

    @Test
    void containsRetrnFalseAfterElementIsDeleted() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        binarySearchTree.insert(8);
        binarySearchTree.remove(8);
        assertFalse(binarySearchTree.contains(8));
    }
}
