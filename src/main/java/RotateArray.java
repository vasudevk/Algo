import java.util.Arrays;

/**
 * Created by amit.k.mannur on 3/5/2018.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] sarr={1,2,3,4,5,6};


        System.arraycopy(sarr,0,sarr,4,2);

        Arrays.stream(sarr).forEach(e-> System.out.println(e));
    }

    private static void rotateArray(int[] src, int shiftBy) {

        int pos = src.length - shiftBy;
        int[] res = new int[src.length];
        System.arraycopy(src, pos, res, 0, pos - 1);
        System.arraycopy(src, 0, res, pos - 1, pos);
        System.out.println(Arrays.toString(res));
    }


}
