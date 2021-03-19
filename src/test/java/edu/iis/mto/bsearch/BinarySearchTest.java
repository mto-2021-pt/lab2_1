package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    int key = 12;
    int wrongKey = 15;
    int[] sequence = new int[]{12};
    int[] longSequence = new int[]{12,15,55,500};

    @Test
    void sequenceOfLengthOneTest(){
        SearchResult sr = BinarySearch.search(key,sequence);
        assertTrue(sr.isFound());
        assertEquals(key,sequence[sr.getPosition()]);
    }

    @Test
    void sequenceOfLengthOneWithoutKeyTest(){
        SearchResult sr = BinarySearch.search(wrongKey,sequence);
        assertFalse(sr.isFound());
        assertEquals(-1,sr.getPosition());
    }

    @Test
    void isFirstElementOfSequenceFoundTest(){
        SearchResult sr = BinarySearch.search(key,longSequence);
        assertTrue(sr.isFound());
    }

}
