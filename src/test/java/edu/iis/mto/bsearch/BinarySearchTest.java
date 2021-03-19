package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    SearchResult searchResult;

    @Test
    void binarySearchShouldReturnTrueForAKeyFoundInASingleElementSequence() {
        int key = 5;
        int[] sequence = {5};

        searchResult = BinarySearch.search(key, sequence);
        assertTrue(searchResult.isFound());
    }

    @Test
    void binarySearchShouldReturnFalseForAKeyNotFoundInASingleElementSequence() {
        int key = 4;
        int[] sequence = {5};

        searchResult = BinarySearch.search(key, sequence);
        assertFalse(searchResult.isFound());
    }

}
