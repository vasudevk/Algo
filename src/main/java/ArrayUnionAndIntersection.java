/**
 * Created by amit.k.mannur on 3/24/2018.
 */

public class ArrayUnionAndIntersection {

    public static void main(String[] args) {
        String s = "amii";
        String s1 = "zyamt";

        unionOfStrings(s, s1);
        intersectionOfStrings(s, s1);
    }

    private static void intersectionOfStrings(String s, String s1) {
        char[] chars = s.toCharArray();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = new char['z' + 1];
        char[] intersection = new char['z' + 1];
        for (char c : chars) {
            chars2[c]++;
        }
        for (char c : chars1) {
            if (chars2[c] > 0) {
                intersection[c] = (char) c;
            }
        }
        System.out.print("intersection: ");
        System.out.println(intersection);
    }

    private static void unionOfStrings(String s, String s1) {
        char[] chars = s.toCharArray();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = new char[26];
        char[] union = new char[26];
        for (char c : chars) {
            chars2[c-'a']++;
        }
        for (char c : chars1) {
            chars2[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chars2[i] > 0)
                union[i] = (char)(i+'a');
        }
        System.out.print("union :");
        System.out.println(union);
    }
}


