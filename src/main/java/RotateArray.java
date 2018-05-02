import java.util.Arrays;
import java.util.Collections;

/**
 * Created by amit.k.mannur on 3/5/2018.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] sarr = {1, 2, 3, 4, 5, 6};
 /*

        System.arraycopy(sarr,0,sarr,4,2);

        Arrays.stream(sarr).forEach(e-> System.out.println(e));*/
        rotateArray(sarr, 9 % sarr.length);
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Collections.rotate(Arrays.asList(arr), 9);
        System.out.println(Arrays.deepToString(arr));
    }

    private static void rotateArray(int[] src, int shiftBy) {
        int pos = src.length - shiftBy;
        int[] res = new int[src.length];
        System.arraycopy(src, pos, res, 0, shiftBy);
        System.arraycopy(src, 0, res, shiftBy, pos);
        System.out.println(Arrays.toString(res));
    }

}
