package com.mapClasses;

public class MinimumSubArray {
    public static void main(String[] args) {
        System.out.println("MAXIMUM SUB ARRAY IS : " + subArray(new int[]{1, 2, 3, 9, 6, 7, 8, 7}, 3));
    }

    private static int subArray(int[] arr, int k) {
        int maxSum = 0;
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            int windowSum = sum(arr, arr.length - 1);
            maxSum = windowSum;
            x = Integer.max(windowSum, maxSum);
        }
        return x;
    }

    private static int sum(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += i;
        return sum;
    }
}
/*
Psudo Code :
--------------
def max_sub_array_of_size_k(arr, k):
    max_sum = 0
    window_sum = sum(arr[:k])  # First window sum
    max_sum = window_sum

    for i in range(len(arr) - k):
        # Slide window: subtract the element going out, add the element coming in
        window_sum = window_sum - arr[i] + arr[i + k]
        max_sum = max(max_sum, window_sum)

    return max_sum
 */