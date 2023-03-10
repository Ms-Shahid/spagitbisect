package org.example;

import java.util.Arrays;

public class Search {

    /**
     * Performs a binary search on a sorted array with an exponential bound.
     *
     * @param arr    the sorted array to search
     * @param target the value to search for in the array
     * @return the index of the value if found, or -1 if not found
     */

    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // Handle boundary scenarios
        if (n == 0) {
            // Empty array (so return -1 in case of empty array)
            return -1;
        } else if (arr[0] == target) {
            // Target is at index 0
            return 0;
        }

        // Find the start index for binary search
        int startIndex = 1;
        while (startIndex < n && arr[startIndex] <= target) {
            startIndex *= 2;
        }

        // Perform binary search to find the result
        int result = Arrays.binarySearch(arr, startIndex / 2, Math.min(startIndex, arr.length), target);

        // Adjust result to return -1 if value not found
        return result < 0 ? -1 : result;
    }
}
