package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test_v1_1() {
        // seq.length=1      Element jest w sekwencji
        int[] seq={2};
        SearchResult res = BinarySearch.search(2, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),1);
    }
    
    @Test
    void test_v1_2() {
        // seq.length=1      Elementu nie ma w sekwencji
        int[] seq={3};
        SearchResult res = BinarySearch.search(2, seq);
        
        assertFalse(res.isFound());
        assertEquals(res.getPosition(),-1);
    }
    
    @Test
    void test_v1_3() {
        // seq.length>1      Element jest pierwszym elementem
        int[] seq={2,3,4,5};
        SearchResult res = BinarySearch.search(2, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),1);
    }
    
    @Test
    void test_v1_4() {
        // seq.length>1      Element jest ostatnim elementem
        int[] seq={2,3,4,5,6};
        SearchResult res = BinarySearch.search(6, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),seq.length);
    }
    
    @Test
    void test_v1_5() {
        // seq.length>1      Element jest środkowym elementem
        int[] seq={2,3,4,5,6};
        SearchResult res = BinarySearch.search(4, seq);
        
        assertTrue(res.isFound());
        assertEquals(res.getPosition(),3);
    }
    
    @Test
    void test_v1_6() {
        // seq.length>1     Elementu nie ma w sekwencji
        int[] seq={2,3,4,5,6};
        SearchResult res = BinarySearch.search(8, seq);
        
        assertFalse(res.isFound());
        assertEquals(res.getPosition(),-1);
    }
    
    @Test
    void test_exception() {
        int[] seq={};
        
        try {
            BinarySearch.search(8, seq);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "seq.length == 0");
        }
    }

}
