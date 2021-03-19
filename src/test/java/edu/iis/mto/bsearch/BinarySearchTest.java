package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;


import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchForExistingElementInOneElementArray() {
        int[] seq=new int[]{1};
        int key=1;

        SearchResult result = BinarySearch.search(key,seq );
        int actual=seq[result.getPosition()];

        assertThat(result.isFound(), Is.is(true));
        assertThat(key,Is.is(actual));
    }

    @Test
    void searchForNonexistingElementInOneElementArray()
    {
        int[] seq=new int[]{1};
        int key=3;

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.isFound(), Is.is(false));
        assertThat( -1,Is.is(result.getPosition()));
    }

    @Test
    void searchForFirstExistingElementInArray()
    {
        int[] seq=new int[]{1,2,3,4,5};
        int key=1;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertThat(result.isFound(), Is.is(true));
        assertThat(key,Is.is(actual));
    }

    @Test
    void searchForLastExistingElementInArray()
    {
        int[] seq=new int[]{1,2,3,4,5};
        int key=5;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertThat(result.isFound(), Is.is(true));
        assertThat(key,Is.is(actual));
    }

    @Test
    void searchForMiddleExistingElementInArray()
    {
        int[] seq=new int[]{1,2,3,4,5};
        int key=3;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertThat(result.isFound(), Is.is(true));
        assertThat(key,Is.is(actual));
    }

    @Test
    void searchForNonexistingElementInArray()
    {
        int[] seq=new int[]{1,2,4,5,6};
        int key=3;

        SearchResult result = BinarySearch.search(key,seq);

        assertThat(result.isFound(), Is.is(false));
        assertThat( -1,Is.is(result.getPosition()));
    }


    @Test
    void searchingInEmptyArray()
    {
        int[] seq={};
        int key=1;

        assertThrows(IllegalArgumentException.class,
                () -> BinarySearch.search(key,seq));

    }

    @Test
    void searchingInDescendingOrderArray()
    {
        int[] seq={5,4,3,2,1};
        int key=1;
        SearchResult result = BinarySearch.search(key,seq);

        assertThat(result.isFound(), Is.is(false));
        assertThat( -1,Is.is(result.getPosition()));
    }

    @Test
    void searchForExistingElementInArrayWithDuplicates()
    {
        int[] seq={3,3,3,3,3};
        int key=3;

        SearchResult result = BinarySearch.search(key, seq);
        int actual=seq[result.getPosition()];

        assertThat(result.isFound(), Is.is(true));
        assertThat(key,Is.is(actual));

    }

    @Test
    void searchFoNonexistingElementInArrayWithDuplicates()
    {
        int[] seq={3,3,3,3,3};
        int key=5;

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.isFound(), Is.is(false));
        assertThat( -1,Is.is(result.getPosition()));

    }
//wiedza nt. implementacji algorytmu wyszukiwania ulatwi implementacje testow - latwiej dobrac warunki, wykluczyc te niepotrzebne

}
