package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test1() {
        int[] seq=new int[]{1};
        SearchResult result = BinarySearch.search(1,seq );
        assertTrue(result.isFound());
        int actual=seq[result.getPosition()];
        assertEquals(1,actual);
    }

    @Test
    void test2()
    {
        int[] seq=new int[]{1};
        SearchResult result = BinarySearch.search(3, seq);
        assertFalse(result.isFound());
        assertEquals( -1,result.getPosition());
    }

    @Test
    void test3()
    {
        int[] seq=new int[]{1,2,3,4,5};
        SearchResult result = BinarySearch.search(1, seq);
        assertTrue(result.isFound());
        int actual=seq[result.getPosition()];
        assertEquals(1,actual);
    }

    @Test
    void test4()
    {
        int[] seq=new int[]{1,2,3,4,5};
        SearchResult result = BinarySearch.search(5, seq);
        assertTrue(result.isFound());
        int actual=seq[result.getPosition()];
        assertEquals(5,actual);
    }



}
