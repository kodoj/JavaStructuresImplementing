package com.codecool.heap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void heapWithOneValueSHouldHaveThisValueOnZeroArrayIndex() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        int expectedResult = 10;
        assertEquals(expectedResult, minHeap.array[0]);
    }
}
