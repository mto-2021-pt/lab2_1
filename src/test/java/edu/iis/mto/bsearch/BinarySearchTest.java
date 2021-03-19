package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    final int CORRECT_KEY = 1;
    final int INCORRECT_KEY = 2;

    //input length 1
    int[] lengthOneSequence = new int[]{CORRECT_KEY};

    //input length > 1
    final int[] firstElementSequence = new int[]{CORRECT_KEY, 3, 4, 5, 6};
    final int[] lastElementSequence = new int[]{6, 5, 4, 3, CORRECT_KEY};
    final int[] middleElementSequence = new int[]{3, 4, CORRECT_KEY, 5, 6};
    final int[] noElementSequence = new int[]{3, 4, 5, 6};

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void lengthOneSequenceKeyTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, lengthOneSequence);
        assertTrue(result.isFound());
    }

    @Test
    void lengthOneSequenceNoKeyTest() {
        SearchResult result = BinarySearch.search(INCORRECT_KEY, lengthOneSequence);
        assertFalse(result.isFound());
    }

    @Test
    void firstElementSequenceTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, firstElementSequence);
        assertTrue(result.isFound());
        assertEquals(CORRECT_KEY, firstElementSequence[result.getPosition()]);
    }

    @Test
    void lastElementSequenceTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, lastElementSequence);
        assertTrue(result.isFound());
        assertEquals(CORRECT_KEY, lastElementSequence[result.getPosition()]);
    }

    @Test
    void middleElementSequenceTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, middleElementSequence);
        assertTrue(result.isFound());
        assertEquals(CORRECT_KEY, middleElementSequence[result.getPosition()]);
    }

    @Test
    void noElementSequenceKeyTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, noElementSequence);
        assertFalse(result.isFound());
    }

}
