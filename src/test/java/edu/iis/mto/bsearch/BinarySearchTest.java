package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private BinarySearch binarySearch = BinarySearch.create();
    private static final int[] oneElemSeq = {1};

    @Test
    public void searchForExistingElem_singleElemSeq_positionFound() {
        int searchingElem = 1;
        int expectedPosition = 0;
        SearchResult searchResult = binarySearch.search(searchingElem, oneElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(expectedPosition, searchResult.getPosition());
    }

}
