import org.example.Search;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchTests {


    @Test
    public void testExponentialSearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 8;
        int expectedIndex = 7;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }


    @Test
    public void testExponentialSearchFound() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 5;
        int expectedIndex = 2;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testExponentialSearchNotFound() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 6;
        int expectedIndex = -1;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testExponentialSearchFirstElement() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 1;
        int expectedIndex = 0;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    //The last element test
    @Test
    public void testExponentialSearchLastElement() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 11;
        int expectedIndex = 5;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    //The Empty array test
    @Test
    public void testExponentialSearchEmptyArray() {
        int[] arr = {};
        int target = 10;
        int expectedIndex = -1;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    //The duplicate element test
    @Test
    public void testExponentialSearchDuplicateElements() {
        int[] arr = {1, 3, 5, 5, 7, 9, 11};
        int target = 5;
        int expectedIndex = 2;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertTrue(actualIndex == expectedIndex || actualIndex == 3);
    }

    //The negative element test
    @Test
    public void testExponentialSearchNegativeElements() {
        int[] arr = {-11, -9, -7, -5, -3, -1};
        int target = -5;
        int expectedIndex = 3;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }


    @Test
    public void testExponentialSearchZeroElement() {
        int[] arr = {1, 3, 0, 7, 9, 11};
        int target = 0;
        int expectedIndex = -1;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    //The search large array
    @Test
    public void testExponentialSearchLargeArray() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int target = 999999;
        int expectedIndex = 999999;
        int actualIndex = Search.exponentialSearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

}
