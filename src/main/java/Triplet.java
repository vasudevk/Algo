import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 1/22/2018.
 */
public class Triplet {
    static List tripList = new ArrayList();
    int a;
    int b;
    int sum;

    public Triplet(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    public static void main(String[] as) {
        Triplet triplet = new Triplet(0, 0, 0);

        triplet.getTriplets(new int[]{3, 1, 4, 6, 5});
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

        NavigableSet<Integer> set = new TreeSet<>();
        for (int element : arr) {
            set.add(element * element);
        }
        for (Integer a : set) {
            for (Integer b : set.tailSet(a, false)) {
                if (set.tailSet(b, false).contains(Math.sqrt((a*a + b*b)))) {
                    tripList.add(new Triplet((int) Math.sqrt(a), (int) Math.sqrt(b), (int) Math.sqrt(a + b)));
                }
            }
        }
    }
}
