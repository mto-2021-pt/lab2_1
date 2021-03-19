package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private BinarySearch binarySearch = BinarySearch.create();
    private static final int[] oneElemSeq = {1};
    private static final int[] multiElemSeq = {1, 2, 3, 4, 5};
    private static final int[] duplicatedElemSeq = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
    private static final int[] unorderedElemSeq = {5, 3, 2, 4, 7, 1, 6};
    private static final int[] descElemSeq = {7, 6, 5, 4, 3, 2, 1};
    private static final int[] emptySeq = {};
    private static final int firstPosition = 0;
    private static final int lastPosition = 4;
    private static final int middlePosition = 2;
    private static final int notFound = -1;

    @Test
    public void searchForExistingElem_singleElemSeq_positionFound() {
        int searchingElem = 1;
        SearchResult searchResult = binarySearch.search(searchingElem, oneElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(firstPosition, searchResult.getPosition());
    }

    @Test
    public void searchForNonexistentElem_singleElemSeq_positionNotFound() {
        int searchingElem = 2;
        SearchResult searchResult = binarySearch.search(searchingElem, oneElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(notFound, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_firstPosition_multiElemSeq_positionFound() {
        int searchingElem = 1;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(firstPosition, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_lastPosition_multiElemSeq_positionFound() {
        int searchingElem = 5;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(lastPosition, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_middlePosition_multiElemSeq_positionFound() {
        int searchingElem = 3;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(middlePosition, searchResult.getPosition());
    }

    @Test
    public void searchForNonexistentElem_multiElemSeq_positionNotFound() {
        int searchingElem = 6;
        SearchResult searchResult = binarySearch.search(searchingElem, multiElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(notFound, searchResult.getPosition());
    }

    @Test
    public void searchForNonexistentElem_emptySeq_exceptionThrown(){
        int searchingElem = 1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> binarySearch.search(searchingElem, emptySeq));
    }

    @Test
    public void searchForNonexistentElem_nullSeq_exceptionThrown(){
        int searchingElem = 1;
        Assertions.assertThrows(NullPointerException.class, () -> binarySearch.search(searchingElem,null));
    }

    @Test
    public void searchForExistingElem_multiElemSeqWithDuplicates_positionFound() {
        int searchingElem = 1;
        SearchResult searchResult = binarySearch.search(searchingElem, duplicatedElemSeq);
        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(searchingElem, duplicatedElemSeq[searchResult.getPosition()]);
    }

    @Test
    public void searchForExistingElem_unorderedMultiElemSeq_positionNotFound() {
        int searchingElem = 1;
        SearchResult searchResult = binarySearch.search(searchingElem, unorderedElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(notFound, searchResult.getPosition());
    }

    @Test
    public void searchForExistingElem_descMultiElemSeq_positionNotFound() {
        int searchingElem = 1;
        SearchResult searchResult = binarySearch.search(searchingElem, descElemSeq);
        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(notFound, searchResult.getPosition());
    }
}
