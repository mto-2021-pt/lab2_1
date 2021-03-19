package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void OneElementSequence_ElementIsInSequence(){
        int key=1234;
        int[]seq=new int[]{1234};
        SearchResult res=BinarySearch.search(key,seq);
        assertTrue(res.isFound());
        assertEquals(seq[res.getPosition()],key);
    }

    @Test
    void OneElementSequence_ElementIsNotInSequence(){
        int key=1234;
        int[]seq=new int[]{12345};
        SearchResult res=BinarySearch.search(key,seq);
        assertFalse(res.isFound());
    }

    @Test
    void MultipleElementSequence_ElementIsFirstInSequence(){
        int key=1234;
        int[]seq=new int[]{1234,1235,1588,1891,2032,4056};
        SearchResult res=BinarySearch.search(key,seq);
        assertTrue(res.isFound());
        assertEquals(seq[0],key);
    }


}
