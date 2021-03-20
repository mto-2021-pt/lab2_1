package edu.iis.mto.bsearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class BinarySearchTest {

    int[] oneElementSequence = {1};
    int[] fiveElementSequence = {2, 4, 6, 8, 10};
    int[] sequenceOfAllFives = {5, 5, 5, 5, 5};
    SearchResult searchResult;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void searchShouldFindOneElementInSequence() {
        searchResult = BinarySearch.search(1, oneElementSequence);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());

    }

    @Test
    void searchShouldNotFindOneElementInSequence() {
        searchResult = BinarySearch.search(2, oneElementSequence);
        assertFalse(searchResult.isFound());
        assertEquals(searchResult.getPosition(), -1);
    }

    @Test
    void keyShouldBeFirstElement() {
        searchResult = BinarySearch.search(2, fiveElementSequence);
        assertEquals(searchResult.getPosition(), 0);
        assertTrue(searchResult.isFound());
    }

    @Test
    void keyShouldBeLastElement() {
        searchResult = BinarySearch.search(10, fiveElementSequence);
        assertEquals(searchResult.getPosition() + 1, fiveElementSequence.length);
        assertTrue(searchResult.isFound());
    }

    @Test
    void keyShouldBeMiddleElement() {
        searchResult = BinarySearch.search(6, fiveElementSequence);
        assertTrue(searchResult.isFound());
        assertEquals(fiveElementSequence[searchResult.getPosition()], 6);

    }

    @Test
    void keyShouldBeNotFound() {
        searchResult = BinarySearch.search(55, fiveElementSequence);
        assertEquals(searchResult.getPosition(), -1);
        assertFalse(searchResult.isFound());
    }
}
