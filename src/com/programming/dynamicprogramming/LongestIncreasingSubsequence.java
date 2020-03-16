package com.programming.dynamicprogramming;

public class LongestIncreasingSubsequence {

    public static void main(String args[]) {
        int[] sequence = {3, 4, -1, 10, -6, 22, 3};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.findLongestIncreasingSubsequenceSize(sequence));
    }

    private int findLongestIncreasingSubsequenceSize(int[] sequence) {
        int[] temp = new int[sequence.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = 1;
        }

        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }

        return max;
    }
}
