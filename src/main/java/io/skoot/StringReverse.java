package io.skoot;

import java.util.StringJoiner;

public class StringReverse {

    public static void main(String[] args) {

        String string = "Seattle is a beautiful city";
        String[] stringList = string.split(" ");
        StringJoiner reverseString = new StringJoiner(" ");

        for (int i = stringList.length - 1; i >= 0; i--) {
            reverseString.add(stringList[i]);
        }

        System.out.println(reverseString);
    }
}