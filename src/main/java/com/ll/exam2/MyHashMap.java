package com.ll.exam2;

public class MyHashMap<K, V> {

    private Entry[] entries;

    private int size = 0;

    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int dataLength) {
        entries = new Entry[dataLength];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        int indexOfKey = indexOfKey(key);

        if(indexOfKey != -1) {
            V oldValue = (V) entries[indexOfKey].value;
            entries[indexOfKey].value = value;
            return oldValue;
        }

        makeNewArrayIfFull();

        entries[size] = new Entry<>(key, value);

        size++;
        return null;
    }

    private void makeNewArrayIfFull() {
        if(isFull()) {
            makeNewArray();
        }
    }

    private boolean isFull() {
        return size >= entries.length;
    }

    private void makeNewArray() {
        Entry[] newEntries = new Entry[entries.length * 2];

        for(int i = 0; i < entries.length; i++){
            newEntries[i] = entries[i];
        }

        entries = newEntries;
    }

    public V get(K key) {
        int indexOfKey = indexOfKey(key);

        if(indexOfKey == -1) return null;

        return (V) entries[indexOfKey].value;
    }

    private int indexOfKey(K key) {
        for(int i = 0; i < size; i++) {
            if(key.equals(entries[i].key)) return i;
        }
        return -1;
    }

    private int indexOfValue(V value) {
        for(int i = 0; i < size; i++) {
            if(value.equals(entries[i].value)) return i;
        }
        return -1;
    }

    public V remove(K key) {
        int index = indexOfKey(key);

        if(index == -1) return null;

        V oldValue = (V) entries[index].value;

        for(int i = index + 1; i < size; i++) {
            entries[i - 1] = entries[i];
        }

        entries[size - 1] = null;
        size--;
        return oldValue;
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) != -1;
    }

    public boolean containsValue(V value) {
        return indexOfValue(value) != -1;
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
            entries[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
