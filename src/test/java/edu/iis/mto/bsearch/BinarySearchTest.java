package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void OneElementSequence_KeyElementIsInSequence(){
        int key=1234;
        int[]seq=new int[]{1234};
        SearchResult res=BinarySearch.search(key,seq);
        assertTrue(res.isFound());
        assertEquals(seq[res.getPosition()],key);
    }

    @Test
    void OneElementSequence_KeyElementIsNotInSequence(){
        int key=1234;
        int[]seq=new int[]{12345};
        SearchResult res=BinarySearch.search(key,seq);
        assertFalse(res.isFound());
    }

    @Test
    void MultipleElementSequence_KeyElementIsFirstInSequence(){
        int key=1234;
        int[]seq=new int[]{1234,1235,1588,1891,2032,4056};
        SearchResult res=BinarySearch.search(key,seq);
        assertTrue(res.isFound());
        assertEquals(seq[0],key);
    }

    @Test
    void MultipleElementSequence_KeyElementIsLastInSequence(){
        int key=4056;
        int[]seq=new int[]{1234,1235,1588,1891,2032,4056};
        SearchResult res=BinarySearch.search(key,seq);
        assertTrue(res.isFound());
        assertEquals(seq[seq.length-1],key);
    }

    @Test
    void MultipleElementSequence_KeyElementInTheMiddleOfSequence(){
        int key=1588;
        int[]seq=new int[]{1234,1235,1588,1891,2032,4056};
        SearchResult res=BinarySearch.search(key,seq);
        assertTrue(res.isFound());
        assertEquals(seq[(seq.length-1)/2],key);
    }

    @Test
    void MultipleElementSequence_KeyElementIsNotInSequence(){
        int key=1589;
        int[]seq=new int[]{1234,1235,1588,1891,2032,4056};
        SearchResult res=BinarySearch.search(key,seq);
        assertFalse(res.isFound());
    }

    @Test
    void MultipleElementSequence_IdenticalElements(){
        int key=1234;
        int[]seq=new int[]{1234,1234,1234,1234,1234,1234};
        assertThrows(IllegalArgumentException.class,()-> BinarySearch.search(key,seq));
    }

    @Test
    void MultipleElementSequence_ElementsInDescendingOrder(){
        int key=1234;
        int[]seq=new int[]{1234,1233,1232,1231,1230,1229};
        assertThrows(IllegalArgumentException.class,()-> BinarySearch.search(key,seq));
    }
}
