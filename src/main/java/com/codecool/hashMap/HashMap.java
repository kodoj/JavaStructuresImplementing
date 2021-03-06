package com.codecool.hashMap;

import java.security.Key;
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
        if (list[index] == null)  {
            LinkedList<KeyValue> newList = new LinkedList<>();
            newList.add(new KeyValue(key, value));
            list[index] = newList;
        } else {
            KeyValue keyValueobject = new KeyValue(key, value);
            for (int i = 0; i < list[index].size(); i++) {
                if(list[index].contains(keyValueobject)) {
                    return;
                } else {
                    list[index].add(keyValueobject);
                }
            }
        }
    }


    public V get(K key) {
        int hashCode = getHashCode(key);
        int index = convertHashToIndex(hashCode);
        if (list[index] == null) {
            return null;
        } else {
            for(KeyValue object : list[index]) {
                if (object.getKey().equals(key)) {
                    return (V)object.getValue();
                }
            }
            return null;
        }
    }


    public void update(K key, V value) {
        int hashCode = getHashCode(key);
        int index = convertHashToIndex(hashCode);
        if (list[index] != null) {
            for(KeyValue object : list[index]) {
                if (object.getKey().equals(key)) {
                    object.setValue(value);
                }
            }
        }
    }


    public void delete(K key) {
        int hashCode = getHashCode(key);
        int index = convertHashToIndex(hashCode);
        if (list[index] != null) {
            int tempIndex = 0;
            for(KeyValue object : list[index]) {
                if (object.getKey().equals(key)) {
                    list[index].remove(tempIndex);
                    break;
                }
                tempIndex++;
            }
        }
    }


    public LinkedList<V> values() {
        LinkedList<V> valuesList= new LinkedList<>();

        for (LinkedList<KeyValue> insideList : list) {
            if (insideList != null) {
                for (KeyValue object : insideList) {
                    valuesList.add((V)object.getValue());
                }
            }
        }
        return valuesList;
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
