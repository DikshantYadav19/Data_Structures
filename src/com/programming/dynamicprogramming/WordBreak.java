package com.programming.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String args[]) {
        Set<String> dict = new HashSet<String>();

        dict.add("I");
        dict.add("want");
        dict.add("to");
        dict.add("play");
        dict.add("football");

        String fullString = "wanttofootballIplay";

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.breakStringIntoWords(dict, fullString));
    }

    private String breakStringIntoWords(Set<String> dict, String fullString) {
        // Create a 2 D array of size fullString
        int strlen = fullString.length();
        int wordArray[][] = new int[strlen][strlen];

        for (int row = 0; row < strlen; row++) {
            for (int col = 0; col < wordArray[row].length; col++) {
                wordArray[row][col] = -1;
            }
        }

        // bottom-up
        for (int l = 1; l <= strlen; l++) {
            for (int i = 0; i < strlen - l + 1; i++) {
                int j = i + l - 1;
                String str = fullString.substring(i, j + 1);

                // if the substring is contained in dictionary
                if (dict.contains(str)) {
                    wordArray[i][j] = i;
                    continue;
                }

                // if not, find a k between i and j such that str(i, k - 1) and str(k, j) is true
                for (int k = i + 1; k <= j; k++) {
                    if (wordArray[i][k - 1] != -1 && wordArray[k][j] != -1) {
                        wordArray[i][j] = k;
                        break;
                    }
                }
            }
        }

        // if cannot be formed
        if (wordArray[0][strlen - 1] == -1) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        int i = 0, j = strlen - 1;

        while (i < j) {
            int k = wordArray[i][j];
            if (i == k) {
                buffer.append(fullString.substring(i, j + 1));
                break;
            }
            buffer.append(fullString.substring(i, k) + " ");
            i = k;
        }

        return buffer.toString();
    }
}

