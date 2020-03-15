package com.programming.dynamicprogramming;

public class BurstMaxBalloons {
    public static void main(String args[]) {

        int[] balloons = {3, 1, 5, 8};

        BurstMaxBalloons maxBalloons = new BurstMaxBalloons();
        System.out.println(maxBalloons.maxBalloonsBurst(balloons));
    }

    private int maxBalloonsBurst(int[] balloons) {

        int[][] dp = new int[balloons.length][balloons.length];

        for (int l = 1; l <= balloons.length; l++) {
            for (int i = 0; i <= balloons.length - l; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j; k++) {
                    int leftValue = 1, rightValue = 1;

                    if (i != 0) {
                        leftValue = balloons[i - 1];
                    }
                    if (j != balloons.length - 1) {
                        rightValue = balloons[j + 1];
                    }

                    int after = 0, before = 0;
                    if (i != k) {
                        before = dp[i][k - 1];
                    }
                    if (j != k) {
                        after = dp[k + 1][j];
                    }
                    dp[i][j] = Math.max(leftValue * balloons[k] * rightValue + before + after, dp[i][j]);
                }
            }
        }
        return dp[0][balloons.length - 1];
    }
}
