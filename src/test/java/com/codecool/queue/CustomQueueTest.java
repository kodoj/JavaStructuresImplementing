package com.codecool.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CustomQueueTest {

    @Test
    void createQueue() {
        CustomQueue customQueue = new CustomQueue();
        assertNotNull(customQueue);
    }

    @Test
    void testDequeueWithOneElement() {
        CustomQueue customQueue = new CustomQueue();
        String word = "hello";
        customQueue.enqueue(word);
        assertEquals(word, customQueue.dequeue());
    }

    @Test
    void dequeueWithFewElements() {
        CustomQueue customQueue = new CustomQueue();
        String word = "hello";
        customQueue.enqueue(word);
        customQueue.enqueue("world");
        customQueue.enqueue("kodoj");
        customQueue.enqueue("here");
        assertEquals(word, customQueue.dequeue());
    }

    @Test
    void peekTest() {
        CustomQueue customQueue = new CustomQueue();
        String word = "hello";
        customQueue.enqueue(word);
        assertEquals(word, customQueue.peek());
    }

    @Test
    void queueSizeShouldReturnTwo() {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("hej");
        customQueue.enqueue("hmm");
        int expectedResult = 2;
        assertEquals(expectedResult, customQueue.queueSize());
    }

    @Test
    void queueSizeShouldReturnOneAfterDequeue() {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("hej");
        customQueue.enqueue("hmm");
        customQueue.dequeue();
        int expectedResult = 1;
        assertEquals(expectedResult, customQueue.queueSize());
    }

    @Test
    void trueIfEmpty() {
        CustomQueue customQueue = new CustomQueue();
        assertTrue(customQueue.isEmpty());
    }

    @Test
    void falseIfNotEmpty() {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("hmm");
        assertFalse(customQueue.isEmpty());
    }

    @Test
    void returnElementWithHighestPriority() {
        CustomQueue customQueue = new CustomQueue();
        String word = "secondItem";
        customQueue.enqueue("firstItem");
        customQueue.enqueue(word, 2);
        assertEquals(word, customQueue.dequeue());
    }

    @Test
    void peekElementWIthHighestPriority() {
        CustomQueue customQueue = new CustomQueue();
        String word = "secondItem";
        customQueue.enqueue("firstItem");
        customQueue.enqueue(word, 2);
        assertEquals(word, customQueue.peek());
    }
}
