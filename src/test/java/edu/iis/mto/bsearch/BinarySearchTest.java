package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    int key = 12;
    int wrongKey = 17;
    int[] sequence = new int[]{12};
    int[] longSequence = new int[]{12,15,55,500};
    int[] emptySequence = new int[]{};
    int[] sequenceOfTwelves = new int[]{12,12,12,12,12};
    int[] sequenceWithNegativeNumbers = new int[]{12,15,55,500,-5,-8};
    int[] decreasingSequence = new int[]{421,122,58,12,7,3};

    @Test
    void sequenceOfLengthOneTest(){
        SearchResult sr = BinarySearch.search(key,sequence);
        assertTrue(sr.isFound());
        assertEquals(key,sequence[sr.getPosition()]);
    }

    @Test
    void sequenceOfLengthOneWithoutKeyTest(){
        SearchResult sr = BinarySearch.search(wrongKey,sequence);
        assertFalse(sr.isFound());
        assertEquals(-1,sr.getPosition());
    }

    @Test
    void isFirstElementOfSequenceFoundTest(){
        SearchResult sr = BinarySearch.search(key,longSequence);
        assertTrue(sr.isFound());
        assertEquals(key,longSequence[sr.getPosition()]);
    }

    @Test
    void isLastElementOfSequenceFoundTest(){
        key = 500;
        SearchResult sr = BinarySearch.search(key,longSequence);
        assertTrue(sr.isFound());
        assertEquals(key,longSequence[sr.getPosition()]);
    }

    @Test
    void isElementOfSequenceFoundTest(){
        key = 55;
        SearchResult sr = BinarySearch.search(key,longSequence);
        assertTrue(sr.isFound());
        assertEquals(key,longSequence[sr.getPosition()]);
    }

    @Test
    void isElementOutOfSequenceFound(){
        SearchResult sr = BinarySearch.search(wrongKey,longSequence);
        assertFalse(sr.isFound());
        assertEquals(-1,sr.getPosition());
    }

    @Test
    void emptySequenceTest(){
        assertThrows(IllegalArgumentException.class,()->{
            BinarySearch.search(key,emptySequence);
        });
    }

    @Test
    void sequenceIsNullTest(){
        assertThrows(NullPointerException.class,()->{
            BinarySearch.search(key,null);
        });
    }

    @Test
    void sequenceOfIdenticalNumbersTest(){
        SearchResult sr = BinarySearch.search(key,sequenceOfTwelves);
        assertTrue(sr.isFound());
        assertEquals(key,sequenceOfTwelves[sr.getPosition()]);
    }

    @Test
    void sequenceWithNegativeNumbersTest(){
        SearchResult sr = BinarySearch.search(key,sequenceWithNegativeNumbers);
        assertTrue(sr.isFound());
        assertEquals(key,sequenceWithNegativeNumbers[sr.getPosition()]);
    }

    @Test
    void decreasingSentenceTest(){
        SearchResult sr = BinarySearch.search(key,decreasingSequence);
        assertFalse(sr.isFound());
        assertEquals(-1,sr.getPosition());
    }
}
