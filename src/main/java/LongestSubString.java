import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 11/7/2017.
 */
public class LongestSubString {

    static void longestSubstring(String str) {
        int longestString = 0;
        Set as;
        Map<Character, Integer> characterMap = new LinkedHashMap<>();
        characterMap.clear();
        String as1 = new String();
        for (int i = 0; i < str.length() - 1; i++) {
            if (characterMap.containsKey(str.charAt(i))) {
                i = characterMap.get(str.charAt(i));
                characterMap.clear();
            } else {
                characterMap.put(str.charAt(i), i);
            }
            if (characterMap.size() > longestString) {
                longestString = characterMap.size();
                as = characterMap.keySet();
                as1 = Arrays.stream(as.toArray())
                        .map(Object::toString)
                        .collect(Collectors.joining());

            }
        }
        System.out.println(as1);
        System.out.println(longestString);
    }

    public static void main(String as[]) {
        LongestSubString longestSubString = new LongestSubString();
        //System.out.println(longestSubString.lengthOfLongestSubstring("akomitaseada"));
        longestSubString.longestSubstring("akomitaseada");
    }

    public Set lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new LinkedHashSet<Character>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            char c = s.charAt(j);
            char c1 = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                j++;
            } else {
                set.remove(c1);
                i++;
            }
        }


        return set;
    }

    public int lengthOfLongestSubstring1(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (!result.contains(Character.toString(s.charAt(i)))) {
                result = result + Character.toString(s.charAt(i));
            }
        }
        System.out.println(result);
        return result.length();

    }
}

