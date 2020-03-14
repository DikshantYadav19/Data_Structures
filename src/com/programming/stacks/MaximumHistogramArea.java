package com.programming.stacks;

import java.util.Stack;

public class MaximumHistogramArea {

    /**
     * Find the max area from given histograms
     */

    public static void main(String args[]) {
        int histogram[] = {3, 4, 2, 4};

        MaximumHistogramArea histogramArea = new MaximumHistogramArea();
        System.out.println(histogramArea.maxHistogram(histogram));
    }

    public int maxHistogram(int[] histogram) {

        Stack<Integer> stack = new Stack();
        int area = 0, maxArea = 0, i;

        for (i = 0; i < histogram.length; ) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    area = i * histogram[top];
                } else {
                    area = histogram[top] * (i - stack.peek() - 1);
                }

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();

            if (stack.isEmpty()) {
                area = histogram[top] * i;
            } else {
                area = histogram[top] * (i - stack.peek() - 1);
            }

            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
