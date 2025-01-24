package org.example.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomListTest {

    //Create new CustomList
    //Check size
    //Add a string
    //Remove
    //Get

    @Test
    void createCustomListObject() {
        CustomList customList = new CustomList();
    }

    @Test
    void newCustomListIsEmpty() {
        CustomList customList = new CustomList();
        assertThat(customList.size()).isEqualTo(0);
    }

    @Test
    void addStringMakesSizeReturnOne() {
        CustomList customList = new CustomList();
        customList.add("");
        assertThat(customList.size()).isEqualTo(1);
    }


}
