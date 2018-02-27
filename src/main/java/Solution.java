
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] as) {

        Solution solution = new Solution();
        System.out.println(solution.subStringsLessKDist("awaglk",4));
    }

    private static List<String> subStringsLessKDist(String inputString, int num) {
        List<String> listOfStrings = new ArrayList<String>();
        for (int i = 0; i <= inputString.length() - num; i++) {
            String substring = inputString.substring(i, i + num);
            if (countChar(substring))
                listOfStrings.add(substring);
        }
        return listOfStrings;
    }


    private static boolean countChar(String s) {
        Map hashMap = new HashMap();
        List list = new ArrayList();
        List list1=new ArrayList();
        list = s.chars().mapToObj(r -> (char) r).collect(Collectors.toList());
        list.forEach(e -> {
            hashMap.computeIfPresent(e, (K, V) -> {
                if((int) V ==1 ){
                    list1.add(K);
                }
                return ((int) V + 1);
            });
            hashMap.computeIfAbsent(e, (V) -> 1);
        });

        return list1.size() == 1;
    }
}