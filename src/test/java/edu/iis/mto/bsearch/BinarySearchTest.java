package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    int[] sequence = new int[]{13, 15, 17, 20, 22, 156, 333, 453, 896};
    int[] shortSequence = new int[]{13};

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSequenceWithOneElement() {
        int key = 13;
        SearchResult sr = BinarySearch.search(key, shortSequence);
        assertTrue(sr.isFound());
        assertEquals(key, shortSequence[sr.getPosition()]);
    }

    @Test
    void keyIsNotInSequenceWithOneElement() {
        int key = 87;
        SearchResult sr = BinarySearch.search(key, shortSequence);
        assertFalse(sr.isFound());
        assertEquals(-1, sr.getPosition());
    }

    @Test
    void keyIsFirstElementInSequence() {
        int key = 13;
        SearchResult sr = BinarySearch.search(key, sequence);
        assertTrue(sr.isFound());
        assertEquals(key, sequence[0]);
    }

    @Test
    void keyIsLastElementInSequence() {
        int key = 896;
        SearchResult sr = BinarySearch.search(key, sequence);
        assertTrue(sr.isFound());
        assertEquals(key, sequence[sequence.length-1]);
    }

    @Test
    void keyIsMiddleElementInSequence() {
        int key = 22;
        SearchResult sr = BinarySearch.search(key, sequence);
        assertTrue(sr.isFound());
        assertEquals(key, sequence[sr.getPosition()]);
    }

    @Test
    void keyIsNotInSequence() {
        int key = 222;
        SearchResult sr = BinarySearch.search(key, sequence);
        assertFalse(sr.isFound());
        assertEquals(-1, sr.getPosition());
    }
}
