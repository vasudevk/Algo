import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by amit.k.mannur on 3/12/2018.
 */
public class LongestSubStringDeleteLater {

    public static void main(String[] asd) {

        printLongestSubString("asdasdfgh");

    }

    private static void printLongestSubString(String str) {

        int longestString = 0;
        Set as = new HashSet();
        Map<Character, Integer> characterMap = new HashMap();
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
            }
        }
        System.out.println(as);
        System.out.println(longestString);
    }
}
