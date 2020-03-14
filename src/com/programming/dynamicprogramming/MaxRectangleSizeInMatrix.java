package com.programming.dynamicprogramming;

import com.programming.stacks.MaximumHistogramArea;

public class MaxRectangleSizeInMatrix {
    public static void main(String args[]) {
        int matrix[][] = {
                {1, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1}
        };

        MaxRectangleSizeInMatrix maxRectangleSizeInMatrix = new MaxRectangleSizeInMatrix();
        System.out.println(maxRectangleSizeInMatrix.findMaxRectSizeInMatrix(matrix));
    }

    private int findMaxRectSizeInMatrix(int[][] matrix) {

        int[] sumArray = new int[matrix[0].length];
        int maxArea = 0, area = 0;

        MaximumHistogramArea histogramArea = new MaximumHistogramArea();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < sumArray.length; j++) {
                if (matrix[i][j] == 0) {
                    sumArray[j] = 0;
                } else {
                    sumArray[j] += matrix[i][j];
                }
            }
            area = histogramArea.maxHistogram(sumArray);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}

