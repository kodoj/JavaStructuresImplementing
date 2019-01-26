package com.codecool.stack;

public class StackUnderflow extends RuntimeException {

    private String message = "No more space in Stack";

    public StackUnderflow() {
        System.out.println(message);
    }
}
