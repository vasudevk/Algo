import java.util.HashSet;

/**
 * Created by amit.k.mannur on 4/12/2018.
 */

public class RotateString {

    static HashSet<String> strings = new HashSet<>();

    public static void main(String[] args) {
        //rotateString("abcd");
        permutation("", "abc");
        System.out.println(strings);
        System.out.println(strings.size());
    }

    private static void rotateString(String s) {

        for (int i1 = 0; i1 < s.length(); i1++) {
            String ss;
            ss = s.substring(i1) + s.substring(0, i1);
            strings.add(ss);
            System.out.println(ss);
        }

    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            strings.add(prefix);
           System.out.println(prefix);
        }
        else{
            for (int i = 0; i < n; i++) {
                System.out.println(prefix + str.charAt(i) + "   " + str.substring(0, i) + str.substring(i + 1, n));
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
