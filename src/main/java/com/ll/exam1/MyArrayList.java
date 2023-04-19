package com.ll.exam1;

public class MyArrayList<T> {

    private T[] data = (T[]) new Object[10];
    private int size = 0;

    public int size() {
        return 0;
    }

    public boolean add(T element) {
        makeNewDataIfFull();

        data[size++] = element;
        return true;
    }

    private void makeNewDataIfFull() {
        if(isFull()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        T[] newData = (T[]) new Object[data.length * 2];

        for(int i=0; i<data.length; i++){
            newData[i] = data[i];
        }

        data = newData;
    }

    private boolean isFull() {
        return size >= data.length;
    }

    public T get(int index) {
        return data[index];
    }
}
