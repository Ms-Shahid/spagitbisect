package org.example;

public class Search {

    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        if (n == 0) {
            return -1; //Boundary Scenario if the array length is zero(Empty Array)
        }
        if (arr[0] == target) {
            return 0;// Boundary Scenario if the target is at index 0
        }
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }
        int left = i / 2;
        int right = Math.min(i, arr.length - 1);//Added Math.min function for improvement
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // element found, return index
            } else if (arr[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // target not found
    }
}
