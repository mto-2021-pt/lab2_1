package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSequence() {
        int key = 13;
        int[] sequence = new int[]{13};
        SearchResult sr = BinarySearch.search(key, sequence);
        assertTrue(sr.isFound());
        assertEquals(key, sequence[sr.getPosition()]);
    }
}
