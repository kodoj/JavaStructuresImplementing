package com.codecool.stack;


public class Stack<E> {

    int length;
    int currentSize = 0;
    E[] array;


    public Stack(int length) {
        this.length = length;
        array = (E[]) new Object[length];
    }


    public void push(E object) {
        if (currentSize >= length) {
            throw new StackOverflow();
        }

        array[currentSize] = object;
        currentSize++;
    }


    public E pop() {
        if (currentSize < 1) {
            throw new StackUnderflow();
        } else {
            E result = array[currentSize - 1];
            array[currentSize - 1] = null;
            currentSize--;
            return result;
        }
    }


    public E peek() {
        if (currentSize < 1) {
            throw new StackUnderflow();
        } else {
            return array[currentSize - 1];
        }
    }



    public int length() {
        return length;
    }


    public int freeSpace() {
        return length - currentSize;
    }
}
