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


    public int get() {
        int result = array[0];
        delete();
        return result;
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

    private void delete() {
        array[0] = array[size - 1];
        array[size - 1] = 0;
        size--;
        bubbleDown();
    }

    private void bubbleDown() {
        boolean shuffled = false;

        if (size > 1) {
            shuffled = true;
        }
        int currentIndex = 0;
        while (shuffled) {
            int node1Index = (currentIndex * 2) + 1;
            int node2Index = (currentIndex * 2) + 2;

            if (array[currentIndex] > array[node1Index]) {
                if (array[node1Index] > array[node2Index]) {
                    int temp = array[currentIndex];
                    array[currentIndex] = array[node1Index];
                    array[node1Index] = temp;
                    currentIndex = node1Index;
                } else {
                    int temp = array[currentIndex];
                    array[currentIndex] = array[node2Index];
                    array[node2Index] = temp;
                    currentIndex = node2Index;
                }
            } else {
                shuffled = false;
            }
        }
    }
}
