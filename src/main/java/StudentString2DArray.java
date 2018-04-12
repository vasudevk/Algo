import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 3/27/2018.
 */
//GS
    //sorting map based on values
    //sorting list
    //Map<String,List<Integer>>
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
        Map<String, Integer> stringIntegerMap = new LinkedHashMap<>();
        Map<String, Integer> stringIntegerMap2 = new LinkedHashMap<>();
        stringListMap.forEach((K, V) -> stringIntegerMap.put(K, (V.stream().mapToInt(i -> i).sum()) / V.size()));

       // stringIntegerMap.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).findFirst().get();
        //stringIntegerMap.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()));
        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
        toSort.addAll(stringIntegerMap.entrySet());
        toSort.sort(Map.Entry.comparingByValue());
        System.out.println("i m here sorted");
        System.out.println(toSort);



        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : toSort) {
            map.putIfAbsent(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

        System.out.println(map);



        stringIntegerMap2=stringIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                stringIntegerEntry -> stringIntegerEntry.getKey(), stringIntegerEntry1 -> stringIntegerEntry1.getValue(), (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("UN-sorted: "+stringIntegerMap);
        System.out.println("sorted: "+stringIntegerMap2);
    }


}
