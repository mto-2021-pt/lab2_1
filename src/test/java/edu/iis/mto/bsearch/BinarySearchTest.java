package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    @BeforeEach
    void setUp() throws Exception {

    }
    @Test
    void test_0() {
        int[] input = { };
        int key = 2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(key, input);
        });
    }
    @Test
    void test_1() {
        int[] input = { 2 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void test_2() {
        int[] input = { 2 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, input);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
    @Test
    void test_3() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void test_4() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 6;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void test_5() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 4;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void test_6() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, input);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
}
