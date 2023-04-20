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

    @Test
    @DisplayName("배열 크기 자동 증가")
    void t004() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);
        map.put("S3", 24);
    }

    @Test
    @DisplayName("put()")
    void t005() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);

        assertThat(map.put("S1", 24)).isEqualTo(22);
        assertThat(map.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("remove()")
    void t006() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);

        assertThat(map.remove("S1")).isEqualTo(22);
        assertThat(map.remove("S3")).isNull();
        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("containsKey()")
    void t007() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);

        assertThat(map.containsKey("S1")).isTrue();
        assertThat(map.containsKey("S3")).isFalse();
    }

    @Test
    @DisplayName("containsValue()")
    void t008() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);

        assertThat(map.containsValue(22)).isTrue();
        assertThat(map.containsValue(24)).isFalse();
    }

    @Test
    @DisplayName("clear()")
    void t009() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("S1", 22);
        map.put("S2", 23);
        map.clear();

        assertThat(map.size()).isEqualTo(0);
        assertThat(map.isEmpty()).isTrue();
    }

}