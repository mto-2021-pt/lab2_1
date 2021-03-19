package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searching_in_empty_array() {
        int key = -1;
        boolean catched = false;
        try {
            SearchResult res = BinarySearch.search(key, new int[]{});
        }catch(IllegalArgumentException e){
            catched = true;
        }catch(Exception e){
            fail("Binary search did not threw correct exception when passed empty array.");
        }

        assertTrue(catched);
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
    void search_for_nonexisting_element_in_array_larger_than_1() {
        int key = 700;
        int index = -1;

        SearchResult res = BinarySearch.search(key, new int[]{ 5, 10, 21, 22, 56, 58});

        assertFalse(res.isFound());
        assertEquals(index, res.getPosition());
    }

}
