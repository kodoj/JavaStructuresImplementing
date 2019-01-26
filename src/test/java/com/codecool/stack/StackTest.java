package com.codecool.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    @Test
    void lengthCheck() {
        Stack stack = new Stack(5);
        int expectedLength = 5;
        assertEquals(expectedLength, stack.length);
    }

}
