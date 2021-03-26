package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void isInSequence () {
        int key = 8;
        int[] seq = {8};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void notInSequence () {
        int key = 1;
        int[] seq = {2};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void isFirstElement () {
        int key = 5;
        int[] seq = {5, 10, 15};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void isLastElement () {
        int key = 6;
        int[] seq = {1, 2, 4, 6};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length, searchResult.getPosition() + 1);
    }

    @Test
    void isMiddleElement () {
        int key = 6;
        int[] seq = {1, 2, 6, 7, 8};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(2, searchResult.getPosition());
    }

    @Test
    void notInSequence2 () {
        int key = 12;
        int[] seq = {2, 3, 4, 5};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void emptySequence () {
        int key = 12;
        try {
            int[] seq = {};
            SearchResult searchResult = BinarySearch.search(key, seq);
            assertFalse(searchResult.isFound());
            assertEquals(-1, searchResult.getPosition());
        }
        catch(IllegalArgumentException e) {
            assertEquals("Empty sequence", e.getMessage());
        }
    }

    @Test
    void nullSequence () {
        int key = 12;
        try {
            SearchResult searchResult = BinarySearch.search(key, null);
            assertFalse(searchResult.isFound());
            assertEquals(-1, searchResult.getPosition());
        }
        catch(NullPointerException e) {
      assertEquals("Cannot read the array length because \"seq\" is null", e.getMessage());
        }
    }

    @Test
    void decreasingSequence () {
        int key = 4;
        int[] seq = {5,4,3,2,1};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }

}
