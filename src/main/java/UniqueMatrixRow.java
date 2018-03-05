import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

/**
 * Created by amit.k.mannur on 3/4/2018.
 */
public class UniqueMatrixRow {

    public static void main(String[] a) {
        int m[][] = {{1, 2, 3, 4}, {1, 2, 3, 4}, {2, 3, 4, 5}, {4, 3, 2, 1}};
        Set<List<Integer>> s = new LinkedHashSet<>();
        List<List<Integer>> l = new ArrayList<>();
        IntStream.range(0, m.length).forEach(e -> l.add(stream(m[e]).boxed().collect(Collectors.toList())));
        s.addAll(l);
        System.out.println(s);
    }
}
