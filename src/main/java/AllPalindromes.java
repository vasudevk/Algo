/**
 * Created by amit.k.mannur on 11/9/2017.
 */
public class AllPalindromes {

    static String longest = "";

    private static boolean checkPalindrome(String str) {
        for (int i = 0; i <= str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        System.out.println(str);
        return true;
    }

    private static void printAllPalindrome(String str) {
        int longestlength=0;
        String longestString=null;
        for(int i=0;i<=str.length();i++)
            for(int j=i;j<str.length();j++)
                if(str.substring(i,j+1).length()>1)
                if(checkPalindrome(str.substring(i,j+1))) {
                    if(str.substring(i, j + 1).length()>longestlength){
                        longestlength=str.substring(i, j + 1).length();
                        longestString=str.substring(i, j + 1);
                    }
                }

        System.out.println(longestString);


        /*IntStream.range(0, str.length()).forEach(i -> IntStream.range(i, str.length()).forEach(j -> {
            if (checkPalindrome(str.substring(i, j + 1))) {
                if (str.substring(i, j + 1).length() > longest.length()) {
                    longest = str.substring(i, j + 1);
                }
            }
        }));*/
        System.out.println(longest);
    }

    public static void main(String[] args) {
        printAllPalindrome("aabbaaaaa");
        //   System.out.println(checkPalindrome("aabae"));
    }
}