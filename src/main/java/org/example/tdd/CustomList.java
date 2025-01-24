package org.example.tdd;

public class CustomList {
    int size = 0;
    public int size() {
        return size;
    }

    public void add(String s) {
        size++;
    }

    public String get() {
        return "Hello";
    }
}
