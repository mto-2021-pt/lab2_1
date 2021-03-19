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
    final int[] lastElementSequence = new int[]{-3, -2, -1, 0, CORRECT_KEY};
    final int[] middleElementSequence = new int[]{3, 4, CORRECT_KEY, 5, 6};
    final int[] noElementSequence = new int[]{3, 4, 5, 6};

    //my inputs
    final int[] correctWithZerosSequence = new int[]{0, 0, CORRECT_KEY, 0, 0};
    final int[] onlyZerosSequence = new int[]{0, 0, 0, 0, 0};
    final int[] correctWithNegativeValuesSequence = new int[]{-1, -2, CORRECT_KEY, -3, -4};
    final int[] onlyNegativeValuesSequence = new int[]{-1, -2, -3, -4, -5};
    final int[] multipleCorrectValuesSequence = new int[]{6, CORRECT_KEY, CORRECT_KEY, CORRECT_KEY, 7};
    final int[] onlyCorrectValuesSequence = new int[]{CORRECT_KEY, CORRECT_KEY, CORRECT_KEY, CORRECT_KEY, CORRECT_KEY};

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

    @Test
    void correctWithZerosSequenceTest(){
        SearchResult result = BinarySearch.search(CORRECT_KEY, correctWithZerosSequence);
        assertTrue(result.isFound());
    }

    @Test
    void onlyZerosSequenceTest(){
        SearchResult result = BinarySearch.search(CORRECT_KEY, onlyZerosSequence);
        assertFalse(result.isFound());
    }

    @Test
    void correctWithNegativeValuesSequenceTest(){
        SearchResult result = BinarySearch.search(CORRECT_KEY, correctWithNegativeValuesSequence);
        assertTrue(result.isFound());
    }

    @Test
    void onlyNegativeValuesSequenceTest(){
        SearchResult result = BinarySearch.search(CORRECT_KEY, onlyNegativeValuesSequence);
        assertFalse(result.isFound());
    }

    @Test
    void multipleCorrectValuesSequenceTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, multipleCorrectValuesSequence);
        assertTrue(result.isFound());
    }

    @Test
    void onlyCorrectValuesSequenceTest() {
        SearchResult result = BinarySearch.search(CORRECT_KEY, onlyCorrectValuesSequence);
        assertTrue(result.isFound());
    }
}
