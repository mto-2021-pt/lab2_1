package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {



//    @BeforeEach
//    void setUp() throws Exception {}

    @Test
    void findOneElementTrue() {
        int key =4;
        int[] tab={4};

        SearchResult searchResult =BinarySearch.search(key,tab);

        assertTrue(searchResult.isFound());

    }

    @Test
    void findOneElementFalse() {
        int key =5;
        int[] tab={4};

        SearchResult searchResult =BinarySearch.search(key,tab);

        assertFalse(searchResult.isFound());

    }

    @Test
    void findFirstElement() {
        int key =4;
        int[] tab={4,2,5,8,9};

        SearchResult searchResult =BinarySearch.search(key,tab);

        assertEquals(searchResult.getPosition(),1);

    }

    @Test
    void findLastElement() {
        int key =9;
        int[] tab={4,2,5,8,9};

        SearchResult searchResult =BinarySearch.search(key,tab);

        assertEquals(searchResult.getPosition(),tab.length);

    }

    @Test
    void findMiddleElement() {
        int key =5;
        int[] tab={4,2,5,8,9};

        SearchResult searchResult =BinarySearch.search(key,tab);

        assertEquals(searchResult.getPosition(),(tab.length+1)/2);

    }

    @Test
    void findSequenceElementFalse() {
        int key =7;
        int[] tab={4,2,5,8,9};

        SearchResult searchResult =BinarySearch.search(key,tab);

        assertFalse(searchResult.isFound());

    }

//    @Test
//    void emptySequence() {
//        int key =7;
//        int[] tab={};
//
//        SearchResult searchResult =BinarySearch.search(key,tab);
//
//        assertEquals(tab.length,0);
//
//    }

    @Test
    void twoTheSameSequences() {
        int key =7;
        int[] tab={4,2,5,8,9};

        int key2 =7;
        int[] tab2={4,2,5,8,9};

        SearchResult searchResult =BinarySearch.search(key,tab);
        SearchResult searchResult2 =BinarySearch.search(key2,tab2);

        assertEquals(searchResult,searchResult2);

    }

    @Test
    void twoOtherSequences() {
        int key =4;
        int[] tab={4,2,5,8,9};

        int key2 =5;
        int[] tab2={4,2,5,8,9};

        SearchResult searchResult =BinarySearch.search(key,tab);
        SearchResult searchResult2 =BinarySearch.search(key2,tab2);

        assertNotEquals(searchResult,searchResult2);

    }



}
