package io.skoot.String;

public class MaxOccurringCharacter {

    static final int ASCII_SIZE = 256;

    public static void main(String[] args) {

        String string = "Seattle is a beautiful city!!!!";

        /*
         * Create array to keep the count of individual
         * characters and initialize the array as 0
         * */
        int count[] = new int[ASCII_SIZE];

        /*
         * Construct character count array from the input string
         * */
        int len = string.length();
        for (int i = 0; i < len; i++)
            count[string.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        /*
         * Traversing through the string and maintaining
         * the count of each character
         * */
        for (int i = 0; i < len; i++) {
            if (max < count[string.charAt(i)]) {
                max = count[string.charAt(i)];
                result = string.charAt(i);
            }
        }

        System.out.println(result);
    }
}