import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by amit.k.mannur on 4/12/2018.
 */

class RotateString {

    static HashSet<String> strings = new HashSet<>();

    public static void main(String[] args) {
        rotateString("abcd", 21);
        rotateString("abcd");
        permutation("", "abcd");
        System.out.println(strings);
        System.out.println(strings.size());
        // System.out.println(permutations("abc"));
    }

    private static void rotateString(String s) {
        String ss = "";
        for (int i = 0; i < 4; i++) {
            ss = s.substring(i) + s.substring(0, i);
        }
        System.out.println(ss);

    }

    private static void rotateString(String s, int i) {
        i = i % s.length();
        String s1 = s.substring(i) + s.substring(0, i);
        System.out.println(s1);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            strings.add(prefix);
            System.out.println(prefix);

        } else {
            for (int i = 0; i < n; i++) {
                //System.out.println(prefix + str.charAt(i) + "   " + str.substring(0, i) + str.substring(i + 1, n));
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    private static List<String> permutations(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return Collections.singletonList(input);
        }
        List<String> permutationsList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String prefix = String.valueOf(input.charAt(i));
            String substring = new StringBuilder(input).deleteCharAt(i).toString();
            for (String str : permutations(substring)) {
                System.out.println(prefix + str);
                permutationsList.add(prefix + str);
            }
        }
        return permutationsList;
    }
}
