import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.k.mannur on 4/2/2018.
 */

public class ZillowListInsideList {


    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(8);
        integers.add(9);
        integers.add(2);
        lists.add(integers);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(4);
        lists.add(integers1);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(2);
        lists.add(integers2);

        List<Integer> integers3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            integers3.addAll(preserveIndex(lists, i));
        }
        System.out.println(integers3);
    }

    private static List<Integer> preserveIndex(List<List<Integer>> lists, int i) {
        List<Integer> integers = new ArrayList<>();
        for (List<Integer> list : lists) {
            if (i < list.size())
                integers.add(list.get(i));
        }
        return integers;
    }
}
