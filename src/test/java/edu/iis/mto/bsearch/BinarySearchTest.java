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
        int[] sequence = {1, 3, 4, 5, 7, 8, 9};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertEquals(sequence.length, searchResult.getPosition());
    }

    @Test
    void searchedKeyShouldBeTheMiddleElementInASequence() {
        int key = 5;
        int[] sequence = {1, 5, 9};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertEquals(sequence.length / 2 + 1, searchResult.getPosition());
    }

    @Test
    void binarySearchShouldReturnFalseForAKeyNotFoundInASequence() {
        int key = 3;
        int[] sequence = {1, 2, 5, 8, 9, 10, 11, 12, 13, 14};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertFalse(searchResult.isFound());
    }

    @Test
    void binarySearchShouldReturnFalseIfASequenceIsEmpty() {
        int key = 7;
        int[] sequence = {};

        SearchResult searchResult = BinarySearch.search(key, sequence);
        assertFalse(searchResult.isFound());
    }

    @Test
    void searchResultShouldBeTheSameForTwoTheSameSequences() {
        int key = 3;
        int[] sequence1 = {1, 3, 4, 5, 8};
        int[] sequence2 = {1, 3, 4, 5, 8};

        SearchResult searchResult1 = BinarySearch.search(key, sequence1);
        SearchResult searchResult2 = BinarySearch.search(key, sequence2);

        assertEquals(searchResult1, searchResult2);
    }

    @Test
    void searchResultShouldBeDifferentForTwoTheSameSequencesButDifferentKeys() {
        int key1 = 3;
        int key2 = 4;
        int[] sequence1 = {1, 3, 4, 5, 8};
        int[] sequence2 = {1, 3, 4, 5, 8};

        SearchResult searchResult1 = BinarySearch.search(key1, sequence1);
        SearchResult searchResult2 = BinarySearch.search(key2, sequence2);

        assertNotEquals(searchResult1, searchResult2);
    }

}
