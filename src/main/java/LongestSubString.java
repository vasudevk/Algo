import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 11/7/2017.
 */
public class LongestSubString {

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


    static void longestSubstring(String inputString) {

        char[] charArray = inputString.toCharArray();
        String longestSubstring = null;
        int longestSubstringLength = 0;

        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (charPosMap.containsKey(ch)) {
                i = charPosMap.get(ch);
                charPosMap.clear();
            } else {
                charPosMap.put(ch, i);
            }
            if (charPosMap.size() > longestSubstringLength) {
                longestSubstringLength = charPosMap.size();
                longestSubstring = charPosMap.keySet().stream().map(Object::toString).collect(Collectors.joining());
            }
        }

        System.out.println("Input String : " + inputString);
        System.out.println("The longest substring : " + longestSubstring);
        System.out.println("The longest Substring Length : " + longestSubstringLength);
    }

    public static void main(String as[]) {
        LongestSubString longestSubString = new LongestSubString();
        //System.out.println(longestSubString.lengthOfLongestSubstring("akomitaseada"));
        longestSubString.longestSubstring("akomitaseada");
    }
}

