package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    int[] emptySequence = {};
    int[] oneElementSequence = {1};
    int[] fiveElementSequence = {2, 4, 6, 8, 10};
    int[] sequenceOfAllFives = {5, 5, 5, 5, 5};
    int[] threeSameNumbersInTheMiddle = {2, 4, 4, 4, 10};
    SearchResult searchResult;

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void searchShouldFindOneElementInSequence() {
        searchResult = BinarySearch.search(1, oneElementSequence);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
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

    @Test
    void emptySequence() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(5, emptySequence);
        });
    }

    @Test
    void nullSequence() {
        assertThrows(NullPointerException.class, () -> {
            BinarySearch.search(5, null);
        });
    }

    @Test
    void sequenceHaveAllNumbersTheSame() {
        searchResult = BinarySearch.search(5, sequenceOfAllFives);
        assertTrue(searchResult.isFound());
    }

    @Test
    void sameNumbersInTheMiddle() {
        searchResult = BinarySearch.search(4, threeSameNumbersInTheMiddle);
        assertTrue(searchResult.isFound());
    }
}
