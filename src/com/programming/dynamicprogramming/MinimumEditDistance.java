package com.programming.dynamicprogramming;

public class MinimumEditDistance {
    
    /**
     * Minimum Edit Distance: Minimum number of edits(insert, delete, update) requires to convert a string into a given source string
     * 
     * In this example: we need to convert string "azced" to "abcdef".
     * */
    
    public static void main(String args[]) {

        String destString = "abcdef";
        String stringToBeConverted = "azced";

        MinimumEditDistance minimumEditDistance = new MinimumEditDistance();
        System.out.println(minimumEditDistance.findMinimumEditDistance(destString, stringToBeConverted));
    }

    private int findMinimumEditDistance(String destString, String stringToBeConverted) {
        int[][] dp = new int[stringToBeConverted.length() + 1][destString.length() + 1];

        for (int i = 0; i < destString.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < stringToBeConverted.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= stringToBeConverted.length(); i++) {
            for (int j = 1; j <= destString.length(); j++) {
                if (destString.charAt(j - 1) == stringToBeConverted.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                }
            }
        }
        return dp[stringToBeConverted.length()][destString.length()];
    }
}
