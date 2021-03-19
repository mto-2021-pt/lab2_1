package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test1() {
        int key = -1;
        boolean catched = false;
        try {
            SearchResult res = BinarySearch.search(key, new int[]{});
        }catch(IllegalArgumentException e){
            catched = true;
        }catch(Exception e){
            fail("Binary search did not threw correct exception when passed empty array.");
        }

        assertTrue(catched);
    }

    @Test
    void test2() {
        int key = 1;
        int index = 0;

        SearchResult res = BinarySearch.search(key, new int[]{ 1 });

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void test3() {
        int key = 2;
        int index = -1;

        SearchResult res = BinarySearch.search(key, new int[]{ 17 });

        assertFalse(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void test4() {
        int key = 1;
        int index = 0;

        SearchResult res = BinarySearch.search(key, new int[]{ 1, 2, 3, 4, 17, 23});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void test5() {
        int key = 60;
        int index = 4;

        SearchResult res = BinarySearch.search(key, new int[]{ 4, 7, 13, 20, 60});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void test6() {
        int key = 40;
        int index = 2;

        SearchResult res = BinarySearch.search(key, new int[]{ 5, 12, 40, 500, 1998});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }


    @Test
    void test7() {
        int key = 1300;
        int index = 2;

        SearchResult res = BinarySearch.search(key, new int[]{ 7, 900, 1300, 900931});

        assertTrue(res.isFound());
        assertEquals(index, res.getPosition());
    }

    @Test
    void test8() {
        int key = 700;
        int index = -1;

        SearchResult res = BinarySearch.search(key, new int[]{ 5, 10, 21, 22});

        assertFalse(res.isFound());
        assertEquals(index, res.getPosition());
    }

}
