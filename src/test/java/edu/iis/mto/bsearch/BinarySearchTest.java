package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchForExistingElementInOneElementArray() {
        int[] seq=new int[]{1};
        int key=1;

        SearchResult result = BinarySearch.search(key,seq );
        int actual=seq[result.getPosition()];

        assertTrue(result.isFound());
        assertEquals(key,actual);
    }

    @Test
    void searchForNonexistingElementInOneElementArray()
    {
        int[] seq=new int[]{1};
        int key=3;

        SearchResult result = BinarySearch.search(key, seq);

        assertFalse(result.isFound());
        assertEquals( -1,result.getPosition());
    }

    @Test
    void searchForFirstExistingElementInArray()
    {
        int[] seq=new int[]{1,2,3,4,5};
        int key=1;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertTrue(result.isFound());
        assertEquals(key,actual);
    }

    @Test
    void searchForLastExistingElementInArray()
    {
        int[] seq=new int[]{1,2,3,4,5};
        int key=5;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertTrue(result.isFound());
        assertEquals(key,actual);
    }

    @Test
    void searchForMiddleExistingElementInArray()
    {
        int[] seq=new int[]{1,2,3,4,5};
        int key=3;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertTrue(result.isFound());
        assertEquals(key,actual);
    }

    @Test
    void searchForNonexistingElementInArray()
    {
        int[] seq=new int[]{1,2,4,5,6};
        int key=3;

        SearchResult result = BinarySearch.search(key,seq);

        assertFalse(result.isFound());
        assertEquals( -1,result.getPosition());
    }


}
