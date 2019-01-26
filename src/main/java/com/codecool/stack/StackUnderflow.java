package com.codecool.stack;

public class StackUnderflow extends RuntimeException {

    private String message = "Stack is Empty!";

    public StackUnderflow() {
        System.out.println(message);
    }
}
