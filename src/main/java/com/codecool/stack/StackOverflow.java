package com.codecool.stack;

public class StackOverflow extends RuntimeException {

    private String message = "No more space in Stack";

    StackOverflow() {
        System.out.println(message);
    }
}
