import java.util.Comparator;

/**
 * Created by amit.k.mannur on 3/3/2018.
 */
public class MatrixFindANumber {

    public static void main(String[] as) {

        int[][] a = {{1, 3, 4, 6}, {12, 14, 16, 19}, {31, 34, 38, 40}, {41, 46, 47, 49}};
        findIntegerInMatrix(a, a.length, a[0].length, 16);
    }

    private static void findIntegerInMatrix(int[][] a, int length, int length1, int key) {
        int i;
        for (i = 0; i < length; i++) {
            if(a[i][length1-1]>key)
            if(binarySearch(a[i],key)>=0){
                System.out.println("found");
            }
        }
    }


    private static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length-1;
        while (low <= high) {
            int o = (low + high) >>> 1;
            Comparable q = (Comparable) a[o];
            int s = q.compareTo(key);
            if (s < 0) {
                low = o + 1;
            } else {
                if (s == 0) {
                    return o;
                } else {
                    high = o - 1;
                }
            }


        }
        return -(low + 1);

    }
}
