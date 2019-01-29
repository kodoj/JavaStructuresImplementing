package com.codecool.hashMap;

import java.util.LinkedList;

public class HashMap<K, V> {
    LinkedList<KeyValue>[] list;


    public HashMap() {
        list = new LinkedList[20];
    }


    public void put(K key, V value) {
        int hashCode = getHashCode(key);
    }


    public int getHashCode(K key) {
        int sum = 0;
        for (int i = 0; i < ((String) key).length(); i++) {
            sum += ((String) key).charAt(i) - 'A' + 1;
        }
        return sum;
    }

//    private void resize() {
//        int newArrayLength = size + (int)(size * 0.5);
//        int[] newArray = new int[newArrayLength];
//        System.arraycopy(array, 0, newArray, 0, size);
//        array = newArray;
//    }
}
