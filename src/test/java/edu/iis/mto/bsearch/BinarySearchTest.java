package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void sequenceOfLengthOneTest(){
        int key = 12;
        int[] sequence = new int[]{12};
        SearchResult sr = BinarySearch.search(key,sequence);
        assertTrue(sr.isFound());
        assertEquals(key,sequence[sr.getPosition()]);
    }

    @Test
    void sequenceOfLengthOneWithoutKeyTest(){
        int key = 15;
        int[] sequence = new int[]{12};
        SearchResult sr = BinarySearch.search(key,sequence);
        assertFalse(sr.isFound());
        assertEquals(-1,sr.getPosition());
    }

}
