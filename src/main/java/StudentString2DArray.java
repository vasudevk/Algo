import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 3/27/2018.
 */
//GS
public class StudentString2DArray {

    String[][] students = {
            {"amit", "200"},
            {"sindhu", "10"},
            {"amit", "60"},
            {"sindhu", "50"},
            {"b", "100"},
            {"c", "200"}
    };

    public static void main(String[] args) {
        String[][] students = {
                {"amit", "200"},
                {"sindhu", "10"},
                {"amit", "60"},
                {"sindhu", "50"},
                {"b", "100"},
                {"c", "200"}
        };

        Map<String, List<Integer>> stringListMap = new ConcurrentHashMap<>();
        stringListMap.clear();
        for (String[] student : students) {
            stringListMap.computeIfPresent(student[0], (K, V) -> {
                V.add(Integer.parseInt(student[1]));
                return V;
            });
            stringListMap.computeIfAbsent(student[0], (V) -> {
                List<Integer> integers = new ArrayList<>();
                integers.add(Integer.parseInt(student[1]));
                return integers;

            });
        }
        System.out.println(stringListMap);
        Map<String, Integer> stringIntegerMap = new ConcurrentHashMap<>();
        stringListMap.forEach((K, V) -> stringIntegerMap.put(K, (V.stream().mapToInt(i -> i).sum()) / V.size()));

       // stringIntegerMap.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).findFirst().get();
        System.out.println(stringIntegerMap.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).findFirst().get());
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(1);
        List<Integer> integers=list.stream().sorted((e,e1)->-e.compareTo(e1)).collect(Collectors.toList());
        System.out.println(integers);

    }


}
