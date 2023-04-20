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
    @DisplayName("makeNewDataIfFull()")
    void t004() {
        MyArrayList<String> list = new MyArrayList<>();

        int dataLength1 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        IntStream.range(0, dataLength1 + 1)
                .forEach(index -> list.add("apple %d".formatted(index)));

        int dataLength2 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

    @Test
    @DisplayName("MyArrayList 생성 시 배열 크기 직접 설정")
    void t005() {
        MyArrayList<Object> list = new MyArrayList<>(100);

        int dataLength1 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength1).isEqualTo(100);
    }

    @Test
    @DisplayName("indexOf()")
    void t006() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("grape");
        assertThat(list.indexOf("apple")).isEqualTo(0);
        assertThat(list.indexOf("grape")).isEqualTo(1);
        assertThat(list.indexOf("melon")).isEqualTo(-1);
    }

    @Test
    @DisplayName("리스트에 String이 아닌 Boolean 담기")
    void t007() {
        MyArrayList<Boolean> list = new MyArrayList<>();
        list.add(true);
        list.add(false);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("boolean get()")
    void t008() {
        MyArrayList<Boolean> list = new MyArrayList<>();
        list.add(true);
        list.add(false);

        boolean e0 = (boolean)list.get(0);
        boolean e1 = (boolean)list.get(1);

        assertThat(e0).isEqualTo(true);
        assertThat(e1).isEqualTo(false);
    }

}
