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

    @Test
    void heapShouldAutoResizeItselfIfYouPutMoreValuesThanActualSize() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(10);
        minHeap.insert(11);
        int expectedResult = 11;
        assertEquals(expectedResult, minHeap.array[10]);
    }

    @Test
    void insertTwoValuesLowerShouldBeIndexZero() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(2);
        int expectedResult = 2;
        assertEquals(expectedResult, minHeap.array[0]);
    }

    @Test
    void retrieveFirstValue() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(2);
        int expectedValue = 2;
        assertEquals(expectedValue, minHeap.get());
    }
}
