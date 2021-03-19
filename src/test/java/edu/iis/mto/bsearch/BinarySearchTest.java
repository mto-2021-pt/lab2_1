package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

	private static final int expectedResult = 0;
	private int[] seq = {1, 2, 3, 4, 5, 6, 7};
	private int[] oneElementSeq = {2};
	
	private SearchResult result;
	
    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchShouldReturnIndexOfFirstElementInSequenceWithOneElement() {
    	result = BinarySearch.search(2, oneElementSeq);
    	assertEquals(result.getPosition(), 0);
    	assertTrue(result.isFound());
    }
    
    @Test
    void searchShouldNotFindElementInSequenceWithOneElement() {
     	result = BinarySearch.search(1, oneElementSeq);
    	assertEquals(result.getPosition(), -1);
    	assertFalse(result.isFound());
    }
    
    @Test
    void test() {
        fail("Not yet implemented");
    }

}
