import java.util.Arrays;

/**
 * Created by amit.k.mannur on 4/19/2018.
 */

class SplitArray {

    // Function to split array in Java
    public static void main(String[] args) {

        int[] inp = {1, 2, 1, 4, 5};
        int n = inp.length;

        int[] a = new int[(n + 1) / 2];
        int[] b = new int[n - a.length];

        for (int i = 0; i < n; i++) {
            if (i < a.length)
                a[i] = inp[i];
            else
                b[i - a.length] = inp[i];
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
