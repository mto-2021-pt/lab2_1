package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @Test
    void binarySearchShouldReturnTrueForAKeyFoundInASingleElementSequence() {
        int key = 5;
        int[] sequence = {5};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertTrue(searchResult.isFound());
    }

    @Test
    void binarySearchShouldReturnFalseForAKeyNotFoundInASingleElementSequence() {
        int key = 4;
        int[] sequence = {5};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertFalse(searchResult.isFound());
    }

    @Test
    void searchedKeyShouldBeTheFirstElementInASequence() {
        int key = 1;
        int[] sequence = {1, 2, 5, 8, 9};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertEquals(1, searchResult.getPosition());
    }

    @Test
    void searchedKeyShouldBeTheLastElementInASequence() {
        int key = 9;
        int[] sequence = {1, 2, 5, 8, 9};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertEquals(sequence.length, searchResult.getPosition());
    }

    @Test
    void searchedKeyShouldBeTheMiddleElementInASequence() {
        int key = 5;
        int[] sequence = {1, 2, 5, 8, 9};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertEquals(sequence.length / 2 + 1, searchResult.getPosition());
    }

    @Test
    void binarySearchShouldReturnFalseForAKeyNotFoundInASequence() {
        int key = 3;
        int[] sequence = {1, 2, 5, 8, 9};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertFalse(searchResult.isFound());
    }

}
