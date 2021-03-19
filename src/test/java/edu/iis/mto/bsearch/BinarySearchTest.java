package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void passing_nulls_as_parameters() {
        try {
            SearchResult res = BinarySearch.search(-1, null);

            fail("Expected to throw NullPointerException.");
        }catch(NullPointerException e){
            // Ok.
        }
    }

    @Test
    void searching_in_empty_array() {
        try {
            SearchResult res = BinarySearch.search(-1, new int[]{});

            fail("Expected to throw IllegalArgumentException.");
        }catch(IllegalArgumentException e){
            // Ok.
        }
    }

    @Test
    void search_for_element_in_array_with_1_element() {
        int key = 1;
        int index = 0;

        SearchResult res = BinarySearch.search(key, new int[]{ 1 });

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_nonexisting_element_in_array_with_1_element() {
        int key = 2;
        int index = -1;

        SearchResult res = BinarySearch.search(key, new int[]{ 17 });

        assertFalse(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_element_at_the_beginning() {
        int key = 1;
        int index = 0;

        SearchResult res = BinarySearch.search(key, new int[]{ 1, 2, 3, 4, 17, 23});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_element_at_the_end() {
        int key = 60;
        int index = 4;

        SearchResult res = BinarySearch.search(key, new int[]{ 4, 7, 13, 20, 60});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_element_in_the_middle() {
        int key = 40;
        int index = 2;

        SearchResult res = BinarySearch.search(key, new int[]{ 5, 12, 40, 500, 1998});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }


    @Test
    void search_for_element_in_the_middle2() {
        int key = 1300;
        int index = 2;

        SearchResult res = BinarySearch.search(key, new int[]{ 7, 900, 1300, 900931});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_element_in_array_with_negative_values() {
        int key = -1;
        int index = 2;

        SearchResult res = BinarySearch.search(key, new int[]{ -500, -100, -1, 0, 2});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_zero() {
        int key = 0;
        int index = 0;

        SearchResult res = BinarySearch.search(key, new int[]{ 0});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_element_at_the_end2() {
        int key = 1;
        int index = 1;

        SearchResult res = BinarySearch.search(key, new int[]{ 0, 1});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void search_for_nonexisting_element_in_array_larger_than_1() {
        int key = 700;
        int index = -1;

        SearchResult res = BinarySearch.search(key, new int[]{ 5, 10, 21, 22, 56, 58});

        assertFalse(res.isFound());
        assertEquals(index, res.getPosition());
    }

}
