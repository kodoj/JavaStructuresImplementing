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
        bubbleUp();
    }


    private void resize() {
        int newArrayLength = size + (int)(size * 0.5);
        int[] newArray = new int[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }


    private void bubbleUp() {
        boolean shuffled = false;

        if (size > 1) {
            shuffled = true;
        }

        while (shuffled) {
            int parentIndex = (size - 1) / 2;
            int actualIndex = size - 1;

            if (array[actualIndex] < array[parentIndex]) {
                int temp = array[parentIndex];
                array[parentIndex] = array[actualIndex];
                array[actualIndex] = temp;
            } else {
                shuffled = false;
            }
        }
    }
}
