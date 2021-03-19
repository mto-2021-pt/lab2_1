package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test() {
        int key = -1;
        try {
            SearchResult res = BinarySearch.search(key, new int[]{});
        }catch(IllegalArgumentException e){
            assertTrue(true);
        }catch(Exception e){
            fail("Binary search did not threw correct exception when passed empty array.");
        }

        fail();
    }

    @Test
    void test2() {
        int key = 50;

        SearchResult res = BinarySearch.search(key, new int[]{ 1, 2, 3, 4, 17, 23});

        assertFalse(res.isFound());
        assertEquals(-1, res.getPosition());
    }



    @Test
    void test3() {
        int key = 10;
        int index = 1;

        SearchResult res = BinarySearch.search(key, new int[]{ 5, 10, 21, 22});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void test4() {
        int key = 5;
        int index = 0;

        SearchResult res = BinarySearch.search(key, new int[]{ 5});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

}
