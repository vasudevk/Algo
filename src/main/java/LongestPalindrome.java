/**
 * Created by amit.k.mannur on 9/5/2017.
 */
public class LongestPalindrome {
    public static void main(String... as) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("asasssaamittimas1s"));
        System.out.println(longestPalindrome.findLongestPalindromeInString("asasssaamittimas1s"));
    }

    public static String findLongestPalindromeInString(String str) {
        if (str == null)
            return null;

        String longestPalindrome = String.valueOf(str.charAt(0));

        for (int i = 0; i < str.length() - 1; i++) {

            String returnedPalindrome = findLongestPalindromeWithSpecifiedParameter(str, i, i);
            if (returnedPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = returnedPalindrome;
            }

            returnedPalindrome = findLongestPalindromeWithSpecifiedParameter(str, i, i + 1);
            if (returnedPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = returnedPalindrome;
            }
        }
        return longestPalindrome;
    }

    static public String findLongestPalindromeWithSpecifiedParameter(String inputString,
                                                                     int left, int right) {
        if (left > right)
            return null;

        while (left >= 0 && right < inputString.length()
                && inputString.charAt(left) == inputString.charAt(right)) {
            left--;
            right++;
        }
        return inputString.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }
}
