package io.skoot.String;

public class Palindrome {

    public static void main(String[] args) {

        String palindrome = "ABBA";

//        StringBuilder reverse = new StringBuilder().append(palindrome).reverse();

        char[] chars = palindrome.toCharArray();
        String reverse = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        System.out.println(reverse);

        if (palindrome.equalsIgnoreCase(String.valueOf(reverse)))
            System.out.println("Input is a palindrome");
        else
            System.out.println("Not a palindrome");
    }
}