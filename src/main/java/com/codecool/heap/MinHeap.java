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

        int currentIndex = size - 1;
        while (shuffled) {
            int parentIndex = (currentIndex - 1) / 2;

            if (array[currentIndex] < array[parentIndex]) {
                int temp = array[parentIndex];
                array[parentIndex] = array[currentIndex];
                array[currentIndex] = temp;
                currentIndex = parentIndex;
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

            if (node1Index >= size && node2Index >= size) {
                shuffled = false;
            } else if (node1Index < size && node2Index < size) {
                int lowerValueIndex = array[node1Index] < array[node2Index]? node1Index : node2Index;
                if (array[currentIndex] > array[lowerValueIndex]) {
                    swap(currentIndex, lowerValueIndex);
                    currentIndex = lowerValueIndex;
                }
            } else {
                if (array[currentIndex] > array[node1Index]) {
                    swap(currentIndex, node1Index);
                }
                shuffled = false;
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
