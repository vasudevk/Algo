package io.skoot.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.StringJoiner;

/*
 * Reverse a given string
 * */
public class StringReverse {

    public static void main(String[] args) {

        String reverse = "Seattle is a beautiful city";

        withoutRecursion(reverse);
        usingStringSplit(reverse);
        usingStringBuilder(reverse);
        usingCharArray(reverse);
        usingArrayList(reverse);
    }

    private static void withoutRecursion(String reverse) {

        String reverseNonRecursion = "";
        for (int i = reverse.length() - 1; i >= 0; i--) {
            reverseNonRecursion += reverse.charAt(i);
        }

        System.out.println("Using Non-recursion:" + reverseNonRecursion);
    }

    private static void usingArrayList(String reverse) {

        char[] chars = reverse.toCharArray();
        List<Character> strings = new ArrayList<>();
        for (char c : chars) {
            strings.add(c);
        }

        Collections.reverse(strings);
        ListIterator li = strings.listIterator();
        while (li.hasNext())
            System.out.print(li.next());
    }

    private static void usingCharArray(String reverse) {

        char[] chars = reverse.toCharArray();
        StringBuilder reverseString = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {

            /*
             * reverseString += String.valueOf(chars[i]);
             * Do not use String + in a loop since this creates a new String object
             * for each iteration due to string immutability.
             * Hence it is always suggested to use StringBuilder or StringBuffer
             * */
            reverseString.append(String.valueOf(chars[i]));
        }

        System.out.println("Using Char Array: " + reverseString);
    }

    private static void usingStringBuilder(String reverse) {

        StringBuilder stringBuilder = new StringBuilder().append(reverse).reverse();
        System.out.println("Using String Builder: " + stringBuilder);
    }

    private static void usingStringSplit(String reverse) {

        String[] stringList = reverse.split(" ");
        StringJoiner reverseJoiner = new StringJoiner("");

        for (int i = stringList.length - 1; i >= 0; i--) {

            String[] stringLists = stringList[i].split("");
            StringJoiner reverseJoiners = new StringJoiner("");

            for (int j = stringLists.length - 1; j >= 0; j--) {
                reverseJoiners.add(stringLists[j]);
            }
            reverseJoiner.add(reverseJoiners + " ");
        }

        System.out.println("Using String Split: " + reverseJoiner);
    }
}