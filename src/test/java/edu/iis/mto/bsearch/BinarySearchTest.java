package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchForExistingElem_singleElementSequence() {
        int[] seq = new int[1];
        int key = 1337;
        seq[0] = key;
        SearchResult result = BinarySearch.search(key, seq);
        if(!result.isFound() || result.getPosition() != 0 || seq[result.getPosition()] != key) {
            fail();
        }
    }

    @Test
    void searchForNonExistingElem_singleElementSequence() {
        int[] seq = new int[1];
        seq[0] = 1337;
        SearchResult result = BinarySearch.search(2137, seq);
        if(result.isFound() || result.getPosition() != -1) {
            fail();
        }
    }

    @Test
    void searchForExistingElem_MultiElementsSequence_FirstElement() {
        int[] seq = new int[4];
        int key = 1;
        seq[0] = key;
        seq[1] = 2;
        seq[2] = 3;
        seq[3] = 4;
        SearchResult result = BinarySearch.search(key, seq);
        if(!result.isFound() || result.getPosition() != 0 || seq[result.getPosition()] != key) {
            fail();
        }
    }

    @Test
    void searchForExistingElem_MultiElementsSequence_LastElement() {
        int[] seq = new int[4];
        int key = 4;
        seq[0] = 1;
        seq[1] = 2;
        seq[2] = 3;
        seq[3] = key;
        SearchResult result = BinarySearch.search(key, seq);
        if(!result.isFound() || result.getPosition() != 3 || seq[result.getPosition()] != key) {
            fail();
        }
    }

    @Test
    void searchForExistingElem_MultiElementsSequenceOdd_MiddleElement() {
        int[] seq = new int[5];
        int key = 3;
        seq[0] = 1;
        seq[1] = 2;
        seq[2] = key;
        seq[3] = 4;
        seq[4] = 5;
        SearchResult result = BinarySearch.search(key, seq);
        if(!result.isFound() || result.getPosition() != 2 || seq[result.getPosition()] != key) {
            fail();
        }
    }

    @Test
    void searchForExistingElem_MultiElementsSequenceEven_MiddleElement() {
        int[] seq = new int[4];
        int key = 2;
        seq[0] = 1;
        seq[1] = key;
        seq[2] = 3;
        seq[3] = 4;
        SearchResult result = BinarySearch.search(key, seq);
        if(!result.isFound() || result.getPosition() != 1 || seq[result.getPosition()] != key) {
            fail();
        }
    }

    @Test
    void searchForExistingElem_MultiElementsSequenceNegative_MiddleElement() {
        int[] seq = new int[4];
        int key = -7;
        seq[0] = -10;
        seq[1] = key;
        seq[2] = -4;
        seq[3] = -2;
        SearchResult result = BinarySearch.search(key, seq);
        if(!result.isFound() || result.getPosition() != 1 || seq[result.getPosition()] != key) {
            fail();
        }
    }

    @Test
    void searchForNonExistingElem_MultiElementsSequence() {
        int[] seq = new int[5];
        seq[0] = 1;
        seq[1] = 2;
        seq[2] = 3;
        seq[3] = 4;
        seq[4] = 5;
        SearchResult result = BinarySearch.search(99, seq);
        if(result.isFound() || result.getPosition() != -1) {
            fail();
        }
    }

    @Test
    void testForException_EmptySequence() {
        int[] seq = new int[0];
        assertThrows(IllegalArgumentException.class,()->{
            BinarySearch.search(3,seq);
        });
    }

    @Test
    void testForException_NotUniqueValues() {
        int[] seq = new int[4];
        seq[0] = 1;
        seq[2] = 4;
        assertThrows(IllegalArgumentException.class,()->{
            BinarySearch.search(3,seq);
        });
    }

    @Test
    void testForException_NotSortedValues() {
        int[] seq = new int[3];
        seq[0] = 2;
        seq[1] = 1;
        seq[2] = 3;
        assertThrows(IllegalArgumentException.class,()->{
            BinarySearch.search(1,seq);
        });
    }

    @Test
    void testForException_DecreasingValues() {
        int[] seq = new int[3];
        seq[0] = 4;
        seq[1] = 3;
        seq[2] = 2;
        assertThrows(IllegalArgumentException.class,()->{
            BinarySearch.search(3,seq);
        });
    }

    @Test
    void testForNullSequence() {
        assertThrows(NullPointerException.class,()->{
            BinarySearch.search(1,null);
        });
    }

    // Znajomość algorytmu wyszukiwania może pomóc zoptymalizować proces testowania, stwarza możliwość lepszego dobrania warunków i odrzucenia niepotrzebnych przypadków testowych

}
