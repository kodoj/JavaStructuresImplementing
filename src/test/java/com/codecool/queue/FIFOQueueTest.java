package com.codecool.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FIFOQueueTest {

    @Test
    void createQueueWithOneElement() {
        FIFOQueue fifoQueue = new FIFOQueue();
        fifoQueue.enqueue("hello");
        assertNotNull(fifoQueue);
    }
}
