/**
 * Created by amit.k.mannur on 9/1/2017.
 */
public class CharCount {
    public static void main(String... s) {
        int c[] = new int['z' + 1];
        String ss = "aaauazAZ".toLowerCase();
        char c1[] = ss.toCharArray();
        for (char c2 : c1) {
            c[c2] = 1 + c[c2];
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
