package org.example;

public class Search {

    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        if (n == 0) {
            return -1; //boundry Scenario
        }
        if (arr[0] == target) {
            return 0;
        }
        int i = 1;
        while (i < n && arr[i] <= target) {
            i = i * 2;
        }
        int left = i / 2;
        int r = i - 1;
        if (r >= n) {
            r = n - 1;
        }
        while (left <= r) {
            int temp = (r - left) / 2;
            int mid = left + temp;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
                if (left > r) {
                    return -1; // target not found
                }
            } else {
                r = mid - 1;
                if (left > r) {
                    return -1; // target not found
                }
            }
        }
        return -1; // target not found
    }


}
