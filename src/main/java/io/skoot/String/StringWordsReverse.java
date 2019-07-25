package io.skoot.String;

import java.util.StringJoiner;

/*
 * Reverse the words in a given String
 *
 * */

public class StringWordsReverse {

    public static void main(String[] args) {

        String word = "Seattle is a beautiful city";
        String[] words = word.split(" ");
        StringJoiner reverseWords = new StringJoiner(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            reverseWords.add(words[i]);
        }

        System.out.println(reverseWords);
    }
}