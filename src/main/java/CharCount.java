/**
 * Created by amit.k.mannur on 9/1/2017.
 */
public class CharCount {
    public static void main(String... s) {
        String ss = "11223333".toLowerCase();
        char c1[] = ss.toCharArray();
        countCharInString(ss);
    }

    private static void countCharInString(String ss) {
        int c[] = new int['z' + 1];

        char c1[] = ss.toCharArray();
        for (char c2 : c1) {
            c[c2]++;
        }

        int i = 0;
        for (int c2 : c) {
            ++i;
            if (c2 != 0) {
                //if('a'==(char)(i-1))
                System.out.println((char) (i - 1) + " count: " + c2);
            }
        }
    }
}
