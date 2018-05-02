import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] as) {
        String[] strs = {"cat", "dog", "act", "asd", "odg", "dsa", "mood", "mod"};
        Anagram anagram = new Anagram();
        System.out.printf(String.valueOf(anagram.groupAnagrams(strs)));
    }
    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a'] += 1;
            }
            String ns = new String(arr);
            map.computeIfPresent(ns, (K, V) -> {
                V.add(str);
                return V;
            });
            map.computeIfAbsent(ns, V -> {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                return al;
            });
        }
        result.addAll(map.values().stream().filter(e->e.size()>1).collect(Collectors.toList()));
        return result;
    }
}
