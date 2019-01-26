package com.codecool.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    @Test
    void lengthCheck() {
        Stack<String> stack = new Stack<>(5);
        int expectedLength = 5;
        assertEquals(expectedLength, stack.length());
    }

    @Test
    void pushFullStack() {
        Stack<String> stack = new Stack<>(5);
        stack.push("lol");
        stack.push("lol1");
        stack.push("lol2");
        stack.push("lol3");
        stack.push("lol4");
    }

    @Test
    void assertThrowsStackOverflowExeption() {
        Stack<String> stack = new Stack<>(5);
        stack.push("lol0");
        stack.push("lol1");
        stack.push("lol2");
        stack.push("lol3");
        stack.push("lol4");
        assertThrows(StackOverflow.class, () -> stack.push("lol6"));
    }

    @Test
    void pushOneElementPopOne() {
        Stack<String> stack = new Stack<>(5);
        String word = "test";
        stack.push(word);
        String expectedResult = "test";
        assertEquals(expectedResult, stack.pop());
    }

    @Test
    void pushThreeElementsPopTwoTimes() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.pop();
        int expectedReturn = 1;
        assertEquals(expectedReturn, stack.pop());
    }

    @Test
    void peekElement() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(0);
        stack.push(1);
        int expectedPeek = 1;
        stack.peek();
        stack.peek();
        assertEquals(expectedPeek, stack.peek());
    }

    @Test
    void ThrowStackUnderflowIfPopEmptyStack() {
        Stack<Integer> stack = new Stack<>(5);
        assertThrows(StackUnderflow.class, () -> stack.pop());
    }

}
