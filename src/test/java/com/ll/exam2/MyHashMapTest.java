package com.ll.exam2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHashMapTest {

    @Test
    @DisplayName("size()")
    void t001() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("put()")
    void t002() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("S1", 22);
        map.put("S2", 23);

        assertThat(map.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get()")
    void t003() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);

        assertThat(map.get("S1")).isEqualTo(22);
        assertThat(map.get("S2")).isEqualTo(23);
    }

}