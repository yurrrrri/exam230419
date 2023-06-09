package com.ll.exam1;

public class MyArrayList<T> {

    private Object[] data;
    private int size = 0;

    public MyArrayList() {
        this(2);
    }

    public MyArrayList(int dataLength) {
        data = new Object[dataLength];
    }

    public int size() {
        return size;
    }

    public boolean add(T element) {
        makeNewDataIfFull();

        data[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, T element) {
        makeNewDataIfFull();

        makeEmptyIndex(index);

        data[index] = element;
        size++;
        return true;
    }

    private void makeEmptyIndex(int index) {
        for(int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
    }

    private void makeNewDataIfFull() {
        if(isFull()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        Object[] newData = new Object[data.length * 2];

        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }

        data = newData;
    }

    private boolean isFull() {
        return size >= data.length;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int indexOf(T element) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(element)) return i;
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public T remove(int index) {
        T oldData = (T) data[index];

        for(int i = index + 1; i < size; i++) {
            data[i] = data[i+1];
        }

        data[size - 1] = null;
        size--;
        return oldData;
    }

    public T set(int index, T element) {
        T oldData = (T) data[index];
        data[index] = element;
        return oldData;
    }
}
