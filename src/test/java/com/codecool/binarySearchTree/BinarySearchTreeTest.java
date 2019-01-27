package com.codecool.binarySearchTree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    void notNullBinarySearchTreeWithOneValueAsRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        assertNotNull(binarySearchTree);
    }
}
