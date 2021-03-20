package edu.iis.mto.bsearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void searchShouldFindOneElementInSequence() {
        int key = 1;
        int[] seq = {1};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(key, searchResult.getPosition());

    }

    @Test
    void searchShouldNotFindOneElementInSequence() {
        int key = 1;
        int[] seq = {2};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(searchResult.getPosition(), -1);
    }

    @Test
    void keyShouldBeFirstElement() {
        int key = 2;
        int[] seq = {2, 4, 6, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition(), 0);
        assertTrue(searchResult.isFound());
    }

    @Test
    void keyShouldBeLastElement() {
        int key = 10;
        int[] seq = {2, 4, 6, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition() + 1, seq.length);
        assertTrue(searchResult.isFound());
    }

    @Test
    void keyShouldBeMiddleElement() {
        int key = 6;
        int[] seq = {2, 4, 6, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);

    }

    @Test
    void keyShouldBeNotFound() {
        int key = 55;
        int[] seq = {2, 4, 6, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition(), -1);
        assertFalse(searchResult.isFound());
    }
}
