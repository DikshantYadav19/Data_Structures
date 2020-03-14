package com.programming.dynamicprogramming;

import java.util.Scanner;

public class WildCardMatching {

    public static void main(String args[]) {
        // Read pattern and string
        Scanner sc = new Scanner(System.in);

        String pattern = sc.next();
        String string = sc.next();

        WildCardMatching wildCardMatching = new WildCardMatching();
        System.out.println(wildCardMatching.isMatching(pattern, string));
    }

    public boolean isMatching(String p, String s) {
        char[] pattern = p.toCharArray();
        char[] str = s.toCharArray();

        // remove extra *  eg: a**b

        int patLength = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[patLength++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[patLength++] = pattern[i];
                isFirst = true;
            }
        }


        boolean arr[][] = new boolean[str.length + 1][patLength + 1];

        arr[0][0] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    arr[i][j] = arr[i - 1][j] || arr[i][j - 1];
                } else {
                    arr[i][j] = false;
                }
            }
        }

        return arr[str.length][patLength];
    }
}

