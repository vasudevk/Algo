/**
 * Created by amit.k.mannur on 4/17/2018.
 */

public class CountBits {
    public static void main(String[] args) {
        int i = 6;
        int j = 0;
        while (i != 0) {
            i = i & i - 1;
            ++j;
        }
        System.out.println(j);
    }
}
