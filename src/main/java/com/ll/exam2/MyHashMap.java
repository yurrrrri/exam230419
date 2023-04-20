package com.ll.exam2;

public class MyHashMap<K, V> {

    private Object[] keys;
    private Object[] values;

    private int size = 0;

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int dataLength) {
        keys = new Object[dataLength];
        values = new Object[dataLength];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        keys[size] = key;
        values[size] = value;

        size++;
        return null;
    }

    public V get(K key) {
        int indexOfKey = indexOfKey(key);

        if(indexOfKey == -1) return null;

        return (V) values[indexOfKey];
    }

    private int indexOfKey(K key) {
        for(int i = 0; i < size; i++) {
            if(key.equals(keys[i])) return i;
        }
        return -1;
    }
}
