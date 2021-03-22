package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test_v1_1() {
        int[] seq={2};
        SearchResult res = BinarySearch.search(2, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),1);
    }
    
    @Test
    void test_v1_2() {
        int[] seq={3};
        SearchResult res = BinarySearch.search(2, seq);
        
        assertFalse(res.isFound());
        assertEquals(res.getPosition(),-1);
    }
    
    @Test
    void test_v1_3() {
        int[] seq={2,3,4,5};
        SearchResult res = BinarySearch.search(2, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),1);
    }
    
    @Test
    void test_v1_4() {
        int[] seq={2,3,4,5,6};
        SearchResult res = BinarySearch.search(6, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),seq.length);
    }
    
    @Test
    void test_v1_5() {
        int[] seq={2,3,4,5,6};
        SearchResult res = BinarySearch.search(4, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),3);
    }

}
