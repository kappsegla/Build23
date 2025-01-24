package org.example.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomListTest {
    private CustomList customList = new CustomList();

    //Create new CustomList
    //Check size
    //Add a string
    //Get
    //Remove

    @Test
    void createCustomListObject() {
        CustomList customList = new CustomList();
    }

    @Test
    void newCustomListIsEmpty() {
        assertThat(customList.size()).isEqualTo(0);
    }

    @Test
    void addStringMakesSizeReturnOne() {
        customList.add("");
        assertThat(customList.size()).isEqualTo(1);
    }

    @Test
    void getReturnsAddedString() {
        customList.add("Hello");
        assertThat(customList.get()).isEqualTo("Hello");
    }

    @Test
    void getReturnsAnnotherAddedString() {
        customList.add("World");
        assertThat(customList.get()).isEqualTo("World");
    }




}
