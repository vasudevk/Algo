import java.util.Arrays;
import java.util.LinkedHashMap;
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
        String as1 = "";
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
}

