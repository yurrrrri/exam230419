package com.ll.exam1;

public class MyArrayList<T> {

    private String[] data = new String[2];
    private int size = 0;

    public int size() {
        return 0;
    }

    public boolean add(String element) {
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
        String[] newData = new String[data.length * 2];

        for(int i=0; i<data.length; i++){
            newData[i] = data[i];
        }

        data = newData;
    }

    private boolean isFull() {
        return size >= data.length;
    }

    public String get(int index) {
        return data[index];
    }

    public String remove(int index) {
        return "return";
    }

    public boolean contains(String element) {
        return true;
    }

    public int indexOf(String element) {
        return -1;
    }
}
