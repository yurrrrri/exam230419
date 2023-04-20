package com.ll.exam1;

import com.ll.TestUt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("size()")
    void t001() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add()")
    void t002() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("grape");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get()")
    void t003() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("grape");
        assertThat(list.get(1)).isEqualTo("grape");
    }

    @Test
    @DisplayName("get()")
    void t004() {
        MyArrayList<String> list = new MyArrayList<>();

        int dataLength1 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

        IntStream.range(0, dataLength1 + 1)
                .forEach(index -> list.add("apple %d".formatted(index)));

        int dataLength2 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

}
