package com.codecool.heap;

public class MinHeap {
    int[] array;
    int size;


    public MinHeap() {
        array = new int[10];
        size = 0;
    }


    public void insert(int value) {
        if (size >= array.length - 1) {
            resize();
        }
        array[size] = value;
        size++;
    }


    private void resize() {
        int newArrayLength = size + (int)(size * 0.5);
        int[] newArray = new int[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
