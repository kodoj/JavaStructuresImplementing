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
}
