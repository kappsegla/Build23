package org.example.tdd;

import java.util.ArrayList;
import java.util.List;

public class CustomList {
    List<String> value = new ArrayList<String>();

    public int size() {
        return value.size();
    }

    public void add(String s) {
        value.add(s);
    }

    public String get(int index) {
        return this.value.get(index);
    }
}
