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
    void searchShouldReturnIndexOfFirstElementInSequenceWithMultipleElements() {
    	result = BinarySearch.search(1, seq);
    	assertEquals(result.getPosition(), 0);
    	assertTrue(result.isFound());
    }
    
    @Test
    void searchShouldReturnIndexOfLastElementInSequenceWithMultipleElements() {
    	result = BinarySearch.search(7, seq);
    	assertEquals(result.getPosition(), seq.length - 1);
    	assertTrue(result.isFound());
    }
    
    @Test
    void searchShouldReturnIndexOfMidleElementInSequenceWithMultipleElements() {
    	result = BinarySearch.search(4, seq);
    	assertEquals(result.getPosition(), (seq.length - 1)/2);
    	assertTrue(result.isFound());
    }
    
    @Test
    void searchShouldNotFindElementInSequenceWithMultipleElements() {
    	result = BinarySearch.search(8, seq);
    	assertEquals(result.getPosition(), -1);
    	assertFalse(result.isFound());
    }
    
    @Test
    void searchShouldThrowNullPointerExceptionWhenSequenceIsNull() {
    	assertThrows(NullPointerException.class, ()-> BinarySearch.search(8, null));
    }
    
    @Test
    void searchSequenceIsEmpty() {
    	int[] sequence = {}; 
    	assertThrows(IllegalArgumentException.class, ()-> BinarySearch.search(8, sequence));
    }
    
    
    @Test
    void searchSequenceIsInIncorrectOrder() {
    	int[] sequence = {7, 6, 5, 4, 3, 2, 1}; 
        result = BinarySearch.search(5, sequence);
        assertEquals(-1, result.getPosition());
        assertFalse(result.isFound());
    }

    @Test
    void searchSequenceIsInDescendingOrder() {
    	int[] sequence = {7, 6, 5, 4, 3, 2, 1}; 
        result = BinarySearch.search(5, sequence);
        assertEquals(-1, result.getPosition());
        assertFalse(result.isFound());
    }
    
    @Test
    void searchSequenceHaveEqualElements() {
    	int[] sequence = {1, 2, 3, 3, 5, 6, 7};
        result = BinarySearch.search(5, sequence);
        assertEquals(4, result.getPosition());
        assertTrue(result.isFound());
    }
    
    @Test
    void test() {
        fail("Not yet implemented");
    }

}
