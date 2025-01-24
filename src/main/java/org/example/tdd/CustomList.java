package org.example.tdd;

public class CustomList {
    int size = 0;
    String value;

    public int size() {
        return size;
    }

    public void add(String s) {
        value = s;
        size++;
    }

    public String get() {
        return this.value;
    }
}
