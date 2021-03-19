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

}
