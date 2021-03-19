package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private BinarySearch binarySearch = BinarySearch.create();
    private static final int[] oneElemSeq = {1};
    private static final int[] multiElemSeq = {1, 2, 3, 4, 5};

    @Test
    public void searchForExistingElem_singleElemSeq_positionFound() {
        int searchingElem = 1;
        int expectedPosition = 0;
        SearchResult searchResult = binarySearch.search(searchingElem, oneElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void searchForNonexistentElem_singleElemSeq_positionNotFound() {
        int searchingElem = 2;
        int expectedPosition = -1;
        SearchResult searchResult = binarySearch.search(searchingElem, oneElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_firstPosition_multiElemSeq_positionFound() {
        int searchingElem = 1;
        int expectedPosition = 0;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_lastPosition_multiElemSeq_positionFound() {
        int searchingElem = 5;
        int expectedPosition = 4;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_middlePosition_multiElemSeq_positionFound() {
        int searchingElem = 3;
        int expectedPosition = 2;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    public void searchForNonexistentElem_multiElemSeq_positionNotFound() {
        int searchingElem = 6;
        int expectedPosition = -1;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }
}
