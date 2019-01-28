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
    void containsReturnFalseAfterElementIsDeleted() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        binarySearchTree.insert(8);
        binarySearchTree.remove(8);
        assertFalse(binarySearchTree.contains(8));
    }

    @Test
    void arrayToBinarySearchTree() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int length = array.length;
        int binarySearchTreeStartPoint = array[length / 2];
        BinarySearchTree binarySearchTree = new BinarySearchTree(binarySearchTreeStartPoint);
        int[] newArray = new int[length - 1];
        System.arraycopy(array, 0, newArray, 0, binarySearchTreeStartPoint - 1);
        System.arraycopy(array, binarySearchTreeStartPoint + 1, newArray, binarySearchTreeStartPoint - 1, length - (binarySearchTreeStartPoint + 1));
        int newArrayLength = newArray.length;
        for (int i = 0; i < newArrayLength; i++) {
            binarySearchTree.insert(newArray[i]);
        }

        assertTrue(binarySearchTree.contains(11));
    }
}
