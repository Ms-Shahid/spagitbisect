package org.example;

public class Search {

    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // Handle boundary scenarios
        if (n == 0) {
            // Empty array
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

        // Set the left and right bounds for binary search
        int left = startIndex / 2;
        int right = Math.min(startIndex, n - 1);

        // Perform binary search
        do {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // Element found, return index
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (left <= right);

        // Target not found
        return -1;
    }
}
