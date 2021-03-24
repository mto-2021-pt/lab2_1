package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void isInSequence() {
        int key = 10;
        int[] seq = new int[]{10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(key, seq[searchResult.getPosition()]);
    }

    @Test
    void isNotInSequence() {
        int key = 5;
        int[] seq = new int[]{10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void isFirstElementOfSequence() {
        int key = 1;
        int[] seq = new int[]{1,2,3,4,5};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void isLastElementOfSequence() {
        int key = 5;
        int[] seq = new int[]{1,2,3,4,5};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(4, searchResult.getPosition());
    }

    @Test
    void isMiddleElementOfSequence() {
        int key = 3;
        int[] seq = new int[]{1,2,3,4,5};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(2, searchResult.getPosition());
    }

    @Test
    void isNotInSequenceWithManyElements() {
        int key = 6;
        int[] seq = new int[]{1,2,3,4,5};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void isEmptyArray() {
        try{
            int key = 1;
            SearchResult result = BinarySearch.search(key,new int[]{});
            assertFalse(result.isFound());
            assertEquals(-1,result.getPosition());
        }
        catch(IllegalArgumentException e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }

    @Test
    void isSequenceNull() {
        int key = 1;
        try{
            SearchResult searchResult = BinarySearch.search(key,null);
            assertFalse(searchResult.isFound());
            assertEquals(-1, searchResult.getPosition());
        }
        catch(NullPointerException e) {
            assertEquals("This sequence is null", e.getMessage());
        }
    }



}
