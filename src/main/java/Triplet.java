import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import static java.lang.Math.sqrt;

/**
 * Created by amit.k.mannur on 1/22/2018.
 */
public class Triplet {
    static List tripList = new ArrayList();
    double a;
    double b;
    double sum;

    private Triplet(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    public static void main(String[] as) {
        Triplet triplet = new Triplet(0, 0, 0);

        triplet.getTriplets(new int[]{3, 1, 4, 6, 5,1,1,2,1});
        System.out.println(tripList);

}

    @Override
    public String toString() {
        return "Triplet{" +
                "a=" + a +
                ", b=" + b +
                ", sum=" + sum +
                '}';
    }

    private void getTriplets(int[] arr) {

        NavigableSet<Double> set = new TreeSet<>();
        for (double element : arr) {
            set.add(Double.valueOf(element * element));
        }
        for (Double a : set) {
            for (Double b : set.tailSet(a, false)) {
                if (set.tailSet(b, false).contains(sqrt((a*a + b*b)))) {
                    tripList.add(new Triplet((int) sqrt(a), (int) sqrt(b), (int) sqrt(a + b)));
                }
            }
        }
    }
}
