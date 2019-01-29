package com.codecool.hashMap;

import java.util.LinkedList;

public class HashMap<K, V> {
    LinkedList<KeyValue>[] list;
    int size = 50;


    public HashMap() {
        list = new LinkedList[size];
    }


    public void put(K key, V value) {
        int hashCode = getHashCode(key);
        int index = convertHashToIndex(hashCode);
        LinkedList<KeyValue> newList = new LinkedList<>();
        newList.add(new KeyValue(key, value));
        list[index] = newList;
    }


    public int getHashCode(K key) {
        int sum = 0;
        for (int i = 0; i < ((String) key).length(); i++) {
            sum += ((String) key).charAt(i) - 'A' + 1;
        }
        return sum;
    }


    public int convertHashToIndex(int hash) {
        int index = hash / size;
        if (index > size - 1) {
            return index % (size - 1);
        } else {
            return index;
        }
    }

    @Override
    public String toString() {
        String answer = "";
        for (int i = 0; i < list.length; i++) {
            if(list[i] != null) {
                answer += list[i] + ", ";
            }
        }
        return answer;
    }
}
