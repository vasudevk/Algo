package io.skoot.String;

import java.util.Scanner;

/*
 * Counting occurrence of a character in a given String
 * */
public class CharactersCount {

    public static void main(String[] args) {

        String string = "Seattle is a beautiful city!";
        int charCount = 0;

        Scanner sc = new Scanner(System.in);
        char c = sc.next().trim().charAt(0);

        for (char ch : string.toCharArray()) {
            if (ch == c)
                charCount++;
        }

        System.out.println("Character " + c + " is occurring " + charCount + " times in the input string");
    }
}