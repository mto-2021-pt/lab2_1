package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test1() {
        int key = 5;
        SearchResult result = BinarySearch.search(key,new int[]{5});
        assertTrue(result.isFound());
        assertEquals(0,result.getPosition());
    }
    @Test
    void test2() {
        int key = 5;
        SearchResult result = BinarySearch.search(key,new int[]{6});
        assertFalse(result.isFound());
        assertEquals(-1,result.getPosition());
    }
    @Test
    void test3() {
        int key = 10;
        SearchResult result = BinarySearch.search(key,new int[]{10,20,30});
        assertTrue(result.isFound());
        assertEquals(0,result.getPosition());
    }
    @Test
    void test4() {
        int key = 15;
        SearchResult result = BinarySearch.search(key,new int[]{9,12,15});
        assertTrue(result.isFound());
        assertEquals(2,result.getPosition());
    }
    @Test
    void test5() {
        int key = 10;
        SearchResult result = BinarySearch.search(key,new int[]{3,7,10,13,18});
        assertTrue(result.isFound());
        assertEquals(2,result.getPosition());
    }

    @Test
    void test6() {
        int key = 9;
        SearchResult result = BinarySearch.search(key,new int[]{6,7,8});
        assertFalse(result.isFound());
        assertEquals(-1,result.getPosition());
    }

    @Test
    void test7() {
        int key = 9;
        try{
            SearchResult result = BinarySearch.search(key,new int[]{});
            assertFalse(result.isFound());
            assertEquals(-1,result.getPosition());
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Nothing in the array", e.getMessage());
        }

    }
    @Test
    void test8() {
        int key = 9;
        try{
            SearchResult result = BinarySearch.search(key,null);
            assertFalse(result.isFound());
            assertEquals(-1,result.getPosition());
        }
        catch(NullPointerException e)
        {
            assertEquals("Cannot read the array length because \"seq\" is null", e.getMessage());
        }
    }

    @Test
    void test9() {
        int key = 3;
        int []tab = {3,3,3};
        SearchResult result = BinarySearch.search(key,tab);
        assertTrue(result.isFound());
        assertEquals(3,tab[result.getPosition()]);
    }

}
