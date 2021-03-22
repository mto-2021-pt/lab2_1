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
    void exception_test_with_no_elements() {
        int[] input = { };
        int key = 2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(key, input);
        });
    }
    @Test
    void successful_search_with_one_element() {
        int[] input = { 2 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void unsuccessful_search_with_one_element() {
        int[] input = { 2 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, input);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
    @Test
    void successful_search_with_multiple_elements_and_element_at_the_start() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void successful_search_with_multiple_elements_and_element_at_the_end() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 6;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void successful_search_with_multiple_elements_and_element_in_the_middle() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 4;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void unsuccessful_search_with_multiple_elements() {
        int[] input = { 2, 3, 4, 5, 6 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, input);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
    @Test
    void successful_search_with_duplicates_at_the_edges() {
        int[] input = { 2, 3, 4, 5, 2 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void successful_search_with_only_duplicates() {
        int[] input = { 2, 2, 2, 2, 2 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void successful_search_with_duplicates_in_the_middle() {
        int[] input = { 1, 2, 2, 2, 6 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertTrue(result.isFound());
        assertEquals(input[result.getPosition()], key);
    }
    @Test
    void unsuccessful_search_with_descending_input() {
        int[] input = { 6, 5, 4, 3, 2 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, input);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
}
