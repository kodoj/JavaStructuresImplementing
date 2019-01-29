package com.codecool.hashMap;

import java.util.LinkedList;

public class HashMap<K, V> {
    LinkedList<K>[]

    private void resize() {
        int newArrayLength = size + (int)(size * 0.5);
        int[] newArray = new int[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
