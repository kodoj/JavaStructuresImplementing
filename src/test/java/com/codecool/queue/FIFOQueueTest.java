package com.codecool.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FIFOQueueTest {

    @Test
    void createQueue() {
        FIFOQueue fifoQueue = new FIFOQueue();
        assertNotNull(fifoQueue);
    }

    @Test
    void testDequeueWithOneElement() {
        FIFOQueue fifoQueue = new FIFOQueue();
        String word = "hello";
        fifoQueue.enqueue(word);
        assertEquals(word, fifoQueue.dequeue());
    }

    @Test
    void dequeueWithFewElements() {
        FIFOQueue fifoQueue = new FIFOQueue();
        String word = "hello";
        fifoQueue.enqueue(word);
        fifoQueue.enqueue("world");
        fifoQueue.enqueue("kodoj");
        fifoQueue.enqueue("here");
        assertEquals(word, fifoQueue.dequeue());
    }

    @Test
    void peekTest() {
        FIFOQueue fifoQueue = new FIFOQueue();
        String word = "hello";
        fifoQueue.enqueue(word);
        assertEquals(word, fifoQueue.peek());
    }

    @Test
    void queueSizeShouldReturnTwo() {
        FIFOQueue fifoQueue = new FIFOQueue();
        fifoQueue.enqueue("hej");
        fifoQueue.enqueue("hmm");
        int expectedResult = 2;
        assertEquals(expectedResult, fifoQueue.queueSize());
    }

    @Test
    void queueSizeShouldReturnOneAfterDequeue() {
        FIFOQueue fifoQueue = new FIFOQueue();
        fifoQueue.enqueue("hej");
        fifoQueue.enqueue("hmm");
        fifoQueue.dequeue();
        int expectedResult = 1;
        assertEquals(expectedResult, fifoQueue.queueSize());
    }

    @Test
    void trueIfEmpty() {
        FIFOQueue fifoQueue = new FIFOQueue();
        assertTrue(fifoQueue.isEmpty());
    }

    @Test
    void falseIfNotEmpty() {
        FIFOQueue fifoQueue = new FIFOQueue();
        fifoQueue.enqueue("hmm");
        assertFalse(fifoQueue.isEmpty());
    }
}
