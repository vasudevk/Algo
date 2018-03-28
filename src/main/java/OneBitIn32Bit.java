/**
 * Created by amit.k.mannur on 3/25/2018.
 */

public class OneBitIn32Bit {
    public static void main(String[] args) {
        System.out.println(hammingWeight(3));
        System.out.println(hammingWeight2(3));
    }

    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
