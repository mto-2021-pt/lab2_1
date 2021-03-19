package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {


    @BeforeEach
    void setUp() throws Exception {}

//    @Test
//    void test() {
//        fail("Not yet implemented");
//    }

    @Test
    public void shouldSearchElementInOneElementSequences() {
        int key = 7;
        int[] seq = {7};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    public void shouldNotSearchElementInOneElementSequences() {
        int key = 7;
        int[] seq = {9};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(false, searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void shouldSearchFirstElementInManyElementsSequences() {
        int key = 7;
        int[] seq = {7, 9, 11, 15, 30, 40, 59};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    public void shouldSearchLastElementInManyElementsSequences() {
        int key = 7;
        int[] seq = {1, 2, 4, 5, 7};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(4, searchResult.getPosition());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    public void shouldSearchMiddleElementInManyElementsSequences() {
        int key = 7;
        int[] seq = {1, 2, 7, 9, 11};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(true, searchResult.isFound());
        assertEquals(2, searchResult.getPosition());
        assertEquals(seq[searchResult.getPosition()], key);
    }
}
